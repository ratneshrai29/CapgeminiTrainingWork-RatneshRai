package com.gal.IssueManagment;

import com.gal.IssueManagment.entity.Employee;
import com.gal.IssueManagment.entity.Issue;
import com.gal.IssueManagment.repo.IssueRepository;
import com.gal.IssueManagment.service.IssueService;
import com.gal.IssueManagment.impl.IssueServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IssueServiceTest {

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueServiceImpl issueService;

    public IssueServiceTest() {
        MockitoAnnotations.openMocks(this); // ✅ IMPORTANT
    }

    @Test
    void testUnresolvedIssues() {
        Mockito.when(issueRepository.findByEmployeeIdAndResolvedFalse(1L))
                .thenReturn(List.of(new Issue()));

        List<Issue> result = issueService.getUnresolvedIssues(1L);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    void testIssuesThisMonth() {
        Mockito.when(issueRepository.findIssuesThisMonth())
                .thenReturn(List.of(new Issue()));

        List<Issue> result = issueService.getIssuesThisMonth();

        assertNotNull(result);
    }

    @Test
    void testEmployeeNamesThisMonth() {

        Employee emp1 = new Employee();
        emp1.setName("Ratnesh");

        Employee emp2 = new Employee();
        emp2.setName("Ayush");

        Issue issue1 = new Issue();
        issue1.setEmployee(emp1);

        Issue issue2 = new Issue();
        issue2.setEmployee(emp2);

        // ✅ EXACT method name must match
        Mockito.when(issueRepository.findIssuesThisMonth())
                .thenReturn(List.of(issue1, issue2));

        List<String> result = issueService.getEmployeeNamesThisMonth();

//        System.out.println(result); // debug

        assertEquals(2, result.size());
        assertTrue(result.contains("Ratnesh"));
        assertTrue(result.contains("Ayush"));
    }
}