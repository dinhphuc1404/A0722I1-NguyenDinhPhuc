package com.example.case_study.repository.contract;

import com.example.case_study.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
}
