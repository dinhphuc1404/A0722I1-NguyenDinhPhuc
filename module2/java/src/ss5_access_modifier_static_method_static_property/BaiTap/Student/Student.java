package ss5_access_modifier_static_method_static_property.BaiTap.Student;

public class Student {
    private String name = "John";
    private String classs = "C02";
    Student(){

    }

    public String getName() {
        return name;
    }

    public String getClasss() {
        return classs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classs='" + classs + '\'' +
                '}';
    }
}
