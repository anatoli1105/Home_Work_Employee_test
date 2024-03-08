package HomeWork.EmployeeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.List;
import java.util.*;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class deportmentServiseTest {
    @Mock
    EmployeeServis employeeServis;
    @InjectMocks
    DeportamentServis deportamentServis;
    @BeforeEach

    void setUp(){
        List employee = new List();
        var employee1=new Employee("ivan2","ivanova",455,6);

        employee.add(String.valueOf(employee1));
        employee.add(String.valueOf(new Employee("Gary","Potter",445,2)));
         employee.add(String.valueOf(new Employee("Gary","Potter2",447,2)));
         employee.add(String.valueOf(new Employee("Pit","Ivanov",4575,9)));



                when(employeeServis.list()).thenReturn((Collection<Employee>) employee);
    }

    @Test

    void  deportmentTestForMaxSalary(){
       var actual=deportamentServis.maxSalaryDeportament(2);

        Assertions.assertEquals(deportamentServis.maxSalaryDeportament(2), 447);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> deportamentServis.maxSalaryDeportament(5));
    }
    @Test
    void  deportmentTestForMinSalary(){
        Assertions.assertEquals(deportamentServis.minSalary(9), 447);
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> deportamentServis.maxSalaryDeportament(5));
        //assertThat()
    }
    @Test
    void deportamentTestForFind(){
        var actual=deportamentServis.deportamentWorks(2);
       // assertThat(actual).containsExactlyInAnyOrder(
              //  (new Employee("Gary","Potter",445,2)),
                //(new Employee("Gary","Potter2",447,2));
       // );


    }
    @Test
    void findWorksDeportamentTest(){
        var actual=deportamentServis.findDeportamentWorks();
        Map<Employee,Employee> expected =new HashMap<>();
        expected.put((new Employee("ivan2","ivanova",455,6)),
                (new Employee("ivan2","ivanova",455,6)));
        expected.put((new Employee("Gary","Potter",445,2)),
                (new Employee("Gary","Potter",445,2)));

        expected.put((new Employee("Gary","Potter2",447,2)),
                  (new Employee("Gary","Potter2",447,2)));

        expected.put((new Employee("Pit","Ivanov",4575,9)),
                (new Employee("Pit","Ivanov",4575,9)));
        Assertions.assertEquals(deportamentServis.maxSalaryDeportament(2), 447);
    }

}
