package HomeWork.EmployeeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEmployeeServis {


    public EmployeeServis employeeServis = new EmployeeServis();

    @Test
    void add() {


        employeeServis.addWorker("Ivan", "Ivanov", 45, 2);
        employeeServis.addWorker("ivan2", "ivanova", 455, 6);
        employeeServis.addWorker("Gary", "Potter", 445, 2);
        employeeServis.addWorker("Pit", "Ivanov", 4575, 9);
        employeeServis.findWorker("ivan2", "ivanova");
        //Assertions.assertEquals(("ivan2","ivanova"),employeeServis.find("ivan2","ivanova")));
        Assertions.assertThrows(EmployeeAlredyAddedException.class, () -> employeeServis.addWorker("Ivan", "Ivanov", 45, 2)
        );
        var actual = employeeServis.findWorker("Ivan", "Ivanov");
        assertThat(actual.getSecondName()).isEqualTo("Ivan");
        assertThat(actual.getFirstName()).isEqualTo("Ivanov");
        assertThat(actual.getSalary()).isEqualTo(45);
        assertThat(actual.getDeprtament()).isEqualTo(2);
    }

    @Test
    void removeForEmployeeServise() {
        employeeServis.addWorker("Ivan", "Ivanov", 45, 2);
        employeeServis.addWorker("ivan2", "ivanova", 455, 6);
        employeeServis.removeWorker("ivan2", "ivanova");
        Assertions.assertThrows(EmployeeNotFoundException.class, () ->
                employeeServis.findWorker("ivan2", "ivanova"));

    }

    @Test
    void getAllForEmployeeServis() {
        var actual1 = employeeServis.list();


        employeeServis.addWorker("Ivan", "Ivanov", 45, 2);
        employeeServis.addWorker("ivan2", "ivanova", 455, 6);
        Assertions.assertEquals(actual1, employeeServis.list());
    }
}
