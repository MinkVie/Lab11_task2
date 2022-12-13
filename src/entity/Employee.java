package entity;

public class Employee {

    private String idEmployee;

    private String name;

    private int salary;

    public Employee() {
    }

    public Employee(String idEmployee, String name, int salary) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.salary = salary;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
