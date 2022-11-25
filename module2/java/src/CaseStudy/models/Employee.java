package CaseStudy.models;

public class Employee extends Person{
    private String level; // trình độ
    private String salary; //lương
    private String position; //chức vụ

    public Employee() {
    }

    public Employee(String level, String salary, String position) {
        this.level = level;
        this.salary = salary;
        this.position = position;
    }

    public Employee(String id, String name, int age, String sex, String address, int idCard, String email, String level, String salary, String position) {
        super(id, name, age, sex, address, idCard, email);
        this.level = level;
        this.salary = salary;
        this.position = position;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Override
    public String toString() {
        return super.toString() +
                "level='" + level + '\'' +
                ", salary='" + salary + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
