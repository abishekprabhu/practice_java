import java.util.Arrays;
import java.util.List;

public class EmployeeDataBase {

    public static List<Employee> getAllEmployees()

    {
        Project p1 = new Project("P001", "Alpha", "ABC Crop", "Alice");
        Project p2 = new Project("P002", "Beta", "EFG Crop", "Bob");
        Project p3 = new Project("P003", "Gamma", "HIJ Crop", "Alice");
        Project p4 = new Project("P004", "Delta", "KLM Crop", "Charlie");
        Project p5 = new Project("P005", "Epsilon", "NOP Crop", "Eva");

        Employee e1 = new Employee(1, "John Doe", "Development", Arrays.asList(p1, p2), 800000, "Male");
        Employee e2 = new Employee(2, "Jane Smith", "Development", List.of(p3), 800000, "Female");
        Employee e3 = new Employee(3, "Robert Brown", "Sales", List.of(p4), 600000, "Male");
        Employee e4 = new Employee(4, "Lisa White", "HR", List.of(p1), 55000, "Female");
        Employee e5 = new Employee(5, "James Wilson", "Marketing", List.of(p5), 850400, "Male");

        return Arrays.asList(e1, e2, e3, e4, e5);

    }

}
