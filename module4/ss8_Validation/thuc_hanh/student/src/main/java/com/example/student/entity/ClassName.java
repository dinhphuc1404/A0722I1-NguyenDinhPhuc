package com.example.student.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClassName {
    @Id
    @Column(length = 20)
    private String classCode;
    private String className;

    @OneToMany(mappedBy = "className",fetch = FetchType.LAZY)
    private Set<Student> students;

    public ClassName() {
    }

    public ClassName(String classCode, String className, Set<Student> students) {
        this.classCode = classCode;
        this.className = className;
        this.students = students;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
