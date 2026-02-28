import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class streamapiquestion {
    public static void main(String[] args) {
        List<Department> departments = EmployeeRepository.getDepartments();
        List<Employee> employees = EmployeeRepository.getEmployees();

        // Question 1
        double sum = employees.stream().mapToDouble(emp -> emp.getSalary()).sum();
        System.out.println("sum = "+sum);

        // Question 2
        Map<String, Long> deptCount = employees.stream()
                .filter(emp -> emp.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        emp -> emp.getDepartment().getDepartmentName(),
                        Collectors.counting()
                ));

        deptCount.forEach((dept, count) ->
                System.out.println(dept + " -> " + count));


        // Question 3
        Optional<Employee> optMin = employees.stream().min((e1,e2)->e1.getHireDate().compareTo(e2.getHireDate()));
        System.out.println(optMin.get());

        // Question 4
        employees.forEach(emp -> {
            Period period = Period.between(emp.getHireDate(), LocalDate.now());

            System.out.println(emp.getFirstName() +
                    " -> " + period.getYears() * 12 + period.getMonths()
                    + " months and " + period.getDays() + " days");
        });

        // Question 5
        employees.stream()
                .filter(emp -> emp.getDepartment() == null)
                .forEach(emp -> System.out.println(emp.getFirstName()));

        // Question 6
        departments.stream()
                .filter(dept -> employees.stream()
                        .noneMatch(emp -> emp.getDepartment() != null &&
                                emp.getDepartment().getDepartmentId() == dept.getDepartmentId()))
                .forEach(dept -> System.out.println(dept.getDepartmentName()));

        //Question 7
        Map<Department, Long> deptCounts = employees.stream()
                .filter(emp -> emp.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));

        long max = deptCounts.values().stream()
                .max(Long::compare)
                .orElse(0L);

        deptCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .forEach(entry ->
                        System.out.println(entry.getKey().getDepartmentName()));


    }
}
