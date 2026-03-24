package com.gal.IssueManagment.api;

import com.gal.IssueManagment.entity.Issue;
import com.gal.IssueManagment.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssueController {

    private static final Logger logger = LoggerFactory.getLogger(IssueController.class);

    @Autowired
    private IssueService issueService;

    // 1. Unresolved issues
    @GetMapping("/unresolved/{empId}")
    public List<Issue> getUnresolvedIssues(@PathVariable Long empId) {
        logger.info("Fetching unresolved issues for employee {}", empId);
        return issueService.getUnresolvedIssues(empId);
    }

    // 2. Issues this month
    @GetMapping("/this-month")
    public List<Issue> getIssuesThisMonth() {
        logger.info("Fetching issues for current month");
        return issueService.getIssuesThisMonth();
    }

    // 3. Employee names this month
    @GetMapping("/employees-this-month")
    public List<String> getEmployeeNames() {
        logger.info("Fetching employee names who raised issues this month");
        return issueService.getEmployeeNamesThisMonth();
    }
}