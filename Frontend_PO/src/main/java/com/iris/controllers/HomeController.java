package com.iris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iris.models.User;
import com.iris.services.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class HomeController {

	@Autowired
	UserService userService;
	

	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("uObj")==null){
			map.addAttribute("msg","Session does not exist");
			return true;	
		}	
		return false;	
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(ModelMap map) {
		map.addAttribute("myIndex", "Welcome to Purchase Order Tool");

		return "IndexPage";
	}
	
	@PostMapping(value = "/user")
	public ResponseEntity<?> registerUser(@RequestBody User uObj) { 
		boolean b = userService.registerUser(uObj);
		if(b) {
			return new ResponseEntity<String>("User Added", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Problem in registering user", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
		
		System.out.println(email+" "+password);
		User uObj = userService.loginUser(email, password);
		System.out.println("User Obj : " + uObj);
		if (uObj != null) {
			 return new  ResponseEntity<Object>(uObj,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<String>("User is Invalid",HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser() {
		session.removeAttribute("uObj");
		session.invalidate();
		return "IndexPage";
	}
}
