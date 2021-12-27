package com.pro.user.sensitive.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pro.user.sensitive.entity.UserSensitiveEntity;
import com.pro.user.sensitive.exception.ResourceNotFound;
import com.pro.user.sensitive.repository.UserSensitiveRepository;
import com.pro.user.sensitive.request.UserSensitiveRequest;
import com.pro.user.sensitive.response.UserSensitiveResponse;
import com.pro.user.sensitive.sensitiveDto.UserSensitiveDto;
import com.pro.user.sensitive.service.UserSensitiveService;

@Service
public class UserSensitiveServiceImpl implements UserSensitiveService {

	@Autowired
	public UserSensitiveRepository userSensitiveRepository;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Override
	public UserSensitiveResponse saveSensitive(UserSensitiveRequest userSensitiveRequest) {
		try
		{
	
		if(userSensitiveRequest.getUserId()==0||userSensitiveRequest.getEmail().isBlank()||userSensitiveRequest.getEmail().isEmpty()
				||userSensitiveRequest.getPhone().isBlank()||userSensitiveRequest.getPhone().isEmpty())
			throw new  ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(ResourceNotFound rs)
		{
			throw new ResourceNotFound("please give proper input because there is some filed null");
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("some thing wrong in service");
		}
		UserSensitiveEntity entityPhone = new UserSensitiveEntity();
		entityPhone.setUserId(userSensitiveRequest.getUserId());
		entityPhone.setName("phone");
		String encryptedPhone = restTemplate.getForObject("http://localhost:9500/commons/encrypt/"+userSensitiveRequest.getPhone(),String.class);
		entityPhone.setValue(encryptedPhone);
		UserSensitiveEntity savedPhone = userSensitiveRepository.save(entityPhone);
		
		UserSensitiveEntity entityEmail = new UserSensitiveEntity();
		entityEmail.setUserId(userSensitiveRequest.getUserId());
		entityEmail.setName("email");
		String encryptedEmail = restTemplate.getForObject("http://localhost:9500/commons/encrypt/"+userSensitiveRequest.getEmail(),String.class);
		entityEmail.setValue(encryptedEmail);
		UserSensitiveEntity savedEmail = userSensitiveRepository.save(entityEmail);
	

		System.out.println("Phone : "+savedPhone);
		System.out.println("Email : "+savedEmail);
		
		UserSensitiveResponse userSensitiveResponse = new UserSensitiveResponse();
		userSensitiveResponse.setUserId(userSensitiveRequest.getUserId());
		userSensitiveResponse.setPhone(savedPhone.getValue());
		userSensitiveResponse.setEmail(savedEmail.getValue());
		
		return userSensitiveResponse;
	}

	@Override
	public UserSensitiveDto getvalueById(int id) {
		try
		{
		UserSensitiveDto dto = new UserSensitiveDto();
		UserSensitiveEntity entity = userSensitiveRepository.getById(id);
		BeanUtils.copyProperties(entity, dto);
		String decryptedValue = restTemplate.getForObject("http://localhost:9500/commons/decrypt/"+dto.getValue(),String.class);
		dto.setValue(decryptedValue);
		return dto;
		}
		catch(IllegalArgumentException e)
		{
		throw new  ResourceNotFound("given  userId  not exist");	
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("something  went wrong  in service layer");
		}
	}

	@Override
	public UserSensitiveDto updateValue(int id, UserSensitiveDto dto) {

		UserSensitiveEntity entity = userSensitiveRepository.getById(id);
		try
		{
			if(entity==null)
				throw new IllegalArgumentException("there is no data");
		}
		catch(IllegalArgumentException e)
		{
			throw new ResourceNotFound("Given userId does not exists in db");
			
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("Something went wrong in service layer");
		}
		String encryptedValue = restTemplate.getForObject("http://localhost:9500/commons/encrypt/"+entity.getValue(),String.class);
		entity.setValue(encryptedValue);
		UserSensitiveEntity userSensitiveEntity = userSensitiveRepository.save(entity);
		UserSensitiveDto esensitiveDto = new UserSensitiveDto();
		BeanUtils.copyProperties(userSensitiveEntity, esensitiveDto);
		return esensitiveDto;
	}

	@Override
	public void deleteValue(int id) {
	    UserSensitiveEntity entity=userSensitiveRepository.getById(id);
	    try
		{
			if(entity==null)
				throw new IllegalArgumentException("User Id is null");
		}
		catch(IllegalArgumentException  e) {
			throw new  ResourceNotFound("give User Id is doesnt exist in db");
		}
		catch(Exception e)
		{
			throw new ResourceNotFound("Something  went wrong  in service layer");
		}
	    userSensitiveRepository .delete(entity);
		
	}
}
