package com.team6.internetPortal.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team6.internetPortal.entity.Report;
import com.team6.internetPortal.service.IReportService;

@RestController
public class ReportsController
{
    @Autowired
    IReportService reportsService;


    @PostMapping("/reports")
    public Report saveReport(@RequestBody Report report){

        return reportsService.saveReport(report);
    }

    @GetMapping("/reports/{id}")
    public Optional<Report> saveReport(@PathVariable Long id){

        return reportsService.getReport(id);
    }

    @GetMapping("/reports/comment/{id}")
    public Report getByCommentId(@PathVariable Long id){

        return reportsService.getByCommentId(id);
    }

    @GetMapping("/reports/user/{id}")
    public Report getByUserId(@PathVariable Long id){

        return reportsService.getByUserId(id);
    }


    @GetMapping("/reports/video/{id}")
    public Optional<Report> getByVid(@PathVariable Long id){

        return reportsService.getByVid(id);
    }


}
