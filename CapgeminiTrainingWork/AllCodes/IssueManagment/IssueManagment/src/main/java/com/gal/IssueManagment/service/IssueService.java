package com.gal.IssueManagment.service;

import com.gal.IssueManagment.entity.Issue;
import java.util.List;

public interface IssueService {

    List<Issue> getUnresolvedIssues(Long empId);

    List<Issue> getIssuesThisMonth();

    List<String> getEmployeeNamesThisMonth();
}