package com.team6.internetPortal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.entity.Admin;
import com.team6.internetPortal.repository.IAdminRepository;
import com.team6.internetPortal.service.IAdminService;

@Service
public class AdminService  implements IAdminService{

	@Autowired
	private IAdminRepository adminRepository;
	
	public List<Admin> getAllAdmin(){
		
		List<Admin> a = adminRepository.findAll();
		System.out.println(a.get(0).getUser());
		System.out.println(a.get(0).getId());
		return a;
	}
}
