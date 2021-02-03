package com.team6.internetPortal.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.team6.internetPortal.service.IAdminService;

@Service
public class AdminService  implements IAdminService{

	
	@Value("${admins}")
	private String adminString;
	
	public Set<String> getAllAdmin(){
		System.out.println(adminString);
		if(adminString != null) {
			return new HashSet<>(Arrays.asList(adminString.split(",")));
		}
		return new HashSet<String>();
	}
}
