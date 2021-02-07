package com.team6.internalPortal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.team6.internetPortal.InternetPortalApplication;
import com.team6.internetPortal.service.impl.AdminService;

@SpringBootTest(classes = InternetPortalApplication.class)
public class AdminServiceImplTest {

    @Autowired
    private AdminService iAdminService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void func() throws Exception {

        assertEquals(1,iAdminService.getAllAdmin().size());

    }
}