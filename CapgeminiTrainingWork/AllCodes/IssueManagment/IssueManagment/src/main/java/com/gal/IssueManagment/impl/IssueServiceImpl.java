package com.gal.IssueManagment.impl;

import com.gal.IssueManagment.entity.Issue;
import com.gal.IssueManagment.repo.IssueRepository;
import com.gal.IssueManagment.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> getUnresolvedIssues(Long empId) {
        return issueRepository.findByEmployeeIdAndResolvedFalse(empId);
    }

    @Override
    public List<Issue> getIssuesThisMonth() {
        return issueRepository.findIssuesThisMonth();
    }

    @Override
    public List<String> getEmployeeNamesThisMonth() {

        List<Issue> issues = issueRepository.findIssuesThisMonth(); // ✅ IMPORTANT

        return issues.stream()
                .map(issue -> issue.getEmployee().getName())
                .distinct()
                .toList();
    }
}