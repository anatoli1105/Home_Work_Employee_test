package HomeWork.EmployeeTest;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServis {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeServis that = (EmployeeServis) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }

    private final Map<String, Employee> employees = new HashMap<>(10);

    public void addWorker(String secondName, String firstname, int salary, int deportament) {
        if (employees.size() >= 10) {
            throw new EmployeeStorageFullException();
        }
        String employee = find(secondName, firstname);


        if (employee != null) {
            throw new EmployeeAlredyAddedException();
        }
        employees.put(key(secondName, firstname), new Employee(secondName, firstname,salary,deportament));


    }

    public void removeWorker(String secondName, String firstname) {
        String employee = key(secondName, firstname);
        if (find(secondName, firstname) == null) {
            throw new EmployeeNotFoundException();
        } else {

            employees.remove(employee);

        }
    }

    public Employee findWorker(String secondName, String firstname) {
        var key=find(secondName,firstname);
        var employee=employees.get(key);
        if(employee!=null){
            return employee;

        }
        throw new EmployeeNotFoundException();








    }






    public String find(String secondName, String firstname) {

        for (String iter : employees.keySet()) {
           // if(StringUtils.isAlpha(secondName)||StringUtils.isAlpha(firstname)){
               // throw new NameException();
           // }
           // else {
               // StringUtils.upperCase(secondName);
                //StringUtils.upperCase(firstname);
           // }
            if (iter.equals(key(secondName, firstname))) {
                return iter;
            }
        }
        return null;
    }

    public Map<String, Employee> listWorker() {
        return employees;
    }


    public static String key(String secondName, String firstname) {
        return secondName + "," + firstname;
    }

    public Collection<Employee> list() {
        return Collections.unmodifiableCollection(employees.values());
    }



}