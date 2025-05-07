import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = EmployeeDataBase.getAllEmployees();

        //forEach
        employees.forEach(e-> System.out.println(e.getName()+" : " + e.getSalary()));
        employees.stream().forEach(System.out::println);
        System.out.println("filter : --------------------");
        //find the dept
        Set<Employee> emp = employees.stream().filter(e->e.getDept().equals("Development") && e.getSalary() > 65000).collect(Collectors.toSet());
        System.out.println("count:"+(long) emp.size()+"\n"+ emp);

        //map
        Map<Integer, Double> devDept = employees.stream().filter(e-> e.getDept().equals("HR")).collect(Collectors.toMap(Employee::getId, Employee::getSalary));
        System.out.println(devDept);

        //distinct
        List<String> dis = employees.stream().map(Employee::getDept).distinct().toList();
        System.out.println(dis);

        //nested list
        List<Stream<String>> projectName = employees.stream().map(e-> e.getProjects().stream().map(Project::getName).toString().lines()).toList();
        System.out.println("map nested: " + projectName);

        List<String> pName = employees.stream().flatMap(e->e.getProjects().stream().map(Project::getName)).toList();
        System.out.println("Flatmap nested: " + pName);
    }
}