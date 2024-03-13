package HomeWork.EmployeeTest;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;

@Service
public class DeportamentServis {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeportamentServis that = (DeportamentServis) o;
        return Objects.equals(employeeServis, that.employeeServis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeServis);
    }

    private final EmployeeServis employeeServis;

    public DeportamentServis(EmployeeServis employeeServis) {
        this.employeeServis = employeeServis;
    }

    public Employee maxSalaryDeportament(int deportament) {
        return employeeServis.list().stream().filter(o -> o.getDeprtament() == deportament)
                .max(Comparator.comparingInt(o -> o.getSalary()))
                .orElse(null);
    }

    public Employee minSalary(int deportament) {
        return employeeServis.list().stream().filter(e -> e.getDeprtament() == deportament)
                .min(Comparator.comparingInt(e -> e.getSalary()))
                .orElse(null);
    }

    public Employee deportamentWorks(int deportament) {
        return (Employee) employeeServis.list().stream().filter(o -> o.getDeprtament() == deportament)
                .collect(Collectors.toList());

    }

    public Map<Integer, List<Employee>> findDeportamentWorks() {
        return employeeServis.list().stream().collect(Collectors.groupingBy(o -> o.getDeprtament()));

    }

    public Integer sumSally(int deportament){
        return employeeServis.list().stream().filter(o -> o.getDeprtament() == deportament)
                .collect(Collectors.summingInt(o->o.getSalary()));
    }


}
