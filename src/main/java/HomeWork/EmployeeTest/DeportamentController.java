package HomeWork.EmployeeTest;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/departments")
public class DeportamentController {

    private final DeportamentServis servis;

    public DeportamentController(DeportamentServis servis) {
        this.servis = servis;
    }

    @GetMapping(path = "/{id}/salary/max")
    public Employee maxSalary(@PathVariable int deportament) {

        return servis.maxSalaryDeportament(deportament);

    }

    @GetMapping(path = "/{id}/salary/min")
    public Employee minSalary(@PathVariable int deportament) {

        return servis.minSalary(deportament);

    }

    @GetMapping(path = "/{id}/employees")
    public Employee allWorks(@PathVariable int deportament) {

        return servis.deportamentWorks(deportament);

    }



    @GetMapping(path = "/department/employees")
    public Map<Integer, List<Employee>> all() {

        return servis.findDeportamentWorks();

    }
    @GetMapping(path = "/{id}/salary/sum")
    public Integer sumSalary(@PathVariable int deportament) {

        return servis.sumSally(deportament);

    }

}
