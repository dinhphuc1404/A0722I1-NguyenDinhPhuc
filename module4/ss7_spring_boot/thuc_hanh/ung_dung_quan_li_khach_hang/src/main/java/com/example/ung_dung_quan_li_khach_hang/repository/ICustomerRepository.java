package com.example.ung_dung_quan_li_khach_hang.repository;

import com.example.ung_dung_quan_li_khach_hang.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
