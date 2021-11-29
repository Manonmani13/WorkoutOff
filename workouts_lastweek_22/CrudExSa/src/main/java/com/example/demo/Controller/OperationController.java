package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Res.OperationRepos;
import com.example.demo.model.Operation;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/op")
public class OperationController {
OperationRepos controll;
@GetMapping("/Details")
public ResponseEntity<List<Operation>> getallinfo(@RequestParam String name)
{
	try {
		List<Operation> tutorials = new ArrayList<Operation>();

		if (name == null)
			controll.forEach(tutorials::add);
		else
			controll.findByTitleContaining(name).forEach(tutorials::add);

		if (tutorials.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<>(tutorials, HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

}
