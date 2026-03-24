package com.gal.IssueManagment.repo;

import com.gal.IssueManagment.entity.Issue;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    // 1. Unresolved issues by employee
    List<Issue> findByEmployeeIdAndResolvedFalse(Long empId);

    // 2. Issues this month
    @Query("SELECT i FROM Issue i WHERE MONTH(i.createdDate) = MONTH(CURRENT_DATE)")
    List<Issue> findIssuesThisMonth();

    // 3. Employee names this month
    @Query("SELECT DISTINCT i.employee.name FROM Issue i WHERE MONTH(i.createdDate) = MONTH(CURRENT_DATE)")
    List<String> findEmployeeNamesThisMonth();
}