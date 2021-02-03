package com.team6.internetPortal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.service.IAdminService;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	@GetMapping("/")
	public Set<String> getAllAdmin(){
		 return adminService.getAllAdmin();
	}
	
}
