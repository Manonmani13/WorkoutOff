package com.muthu.crud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.muthu.crud.Reposi.UserDao;
import com.muthu.crud.model.User;

@Controller
public class UserController {
	@Autowired
	UserDao userdao;
	@RequestMapping("index")
	public String index()
	{
		return "index.jsp";
	}
	@RequestMapping("add")
	public String addUser(User user)
	{
		userdao.save(user);
	 return "index.jsp";	
	}
	@RequestMapping("read")
	public ModelAndView read(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("show.jsp");
		User user=userdao.findById(id).orElse(new User());
		mav.addObject(user);
		return mav;
	}
	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam int id)
	{
		ModelAndView mav=new ModelAndView("delete.jsp");
		User user=userdao.findById(id).orElse(new User());
		userdao.deleteById(id);
		mav.addObject(user);
		return mav;
	}
	@RequestMapping("update")
	public ModelAndView update(User user)
	{
		ModelAndView mav=new ModelAndView("update.jsp");
		user=userdao.findById(user.getId()).orElse(new User());
		userdao.deleteById(user.getId());
		mav.addObject(user);
		return mav;
	}
	
}
