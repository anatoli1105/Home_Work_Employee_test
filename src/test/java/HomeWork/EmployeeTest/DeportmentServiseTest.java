package HomeWork.EmployeeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeportmentServiseTest {


    @Mock
    EmployeeServis employeeServis;

    @InjectMocks
    DeportamentServis deportamentServis;

    @BeforeEach
    void setUp() {
        Employee employee1;

        List<Employee> employee = new ArrayList<>();

        employee.add(new Employee("Gary", "Potter", 445, 1));
        employee.add(new Employee("Gary", "Potter2", 447, 2));
        employee.add(new Employee("Pit", "Ivanov", 4575, 9));


        when(employeeServis.list()).thenReturn(employee);


    }

    @Test
    void deportmentTestForMaxSalary() {
        var actual = (new Employee("Gary", "Potter2", 447, 2));

        Assertions.assertEquals(deportamentServis.maxSalaryDeportament(2), (actual));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> deportamentServis.maxSalaryDeportament(5));
    }

    @Test
    void deportmentTestForMinSalary() {
        var actual = (new Employee("Pit", "Ivanov", 4575, 9));
        Assertions.assertEquals(deportamentServis.minSalary(9), (actual));
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> deportamentServis.minSalary(5));

    }

    @Test
    void deportamentTestForFind() {
        var actual = deportamentServis.deportamentWorks(2);

        assertThat(actual).containsExactlyInAnyOrder(
                new Employee("Gary", "Potter", 445, 2),
                new Employee("Gary", "Potter2", 447, 2));


    }
    @Test
    void findWorksDeportamentTest() {

        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, (new Employee("Gary", "Potter", 445, 1)));
        map.put(2, (new Employee("Gary", "Potter2", 447, 2)));
        map.put(9, (new Employee("Pit", "Ivanov", 4575, 9)));
        Assertions.assertEquals(deportamentServis.findDeportamentWorks(), map);
    }

}
