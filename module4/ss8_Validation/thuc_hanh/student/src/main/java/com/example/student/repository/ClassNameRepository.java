package com.example.student.repository;

import com.example.student.entity.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassNameRepository extends JpaRepository<ClassName, String> {
}
