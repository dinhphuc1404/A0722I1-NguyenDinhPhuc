package com.example.case_study.repository.employee;

import com.example.case_study.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division,Integer> {
}
