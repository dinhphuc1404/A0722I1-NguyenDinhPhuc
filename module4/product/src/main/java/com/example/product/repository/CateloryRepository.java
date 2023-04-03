package com.example.product.repository;

import com.example.product.entity.Catelogy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateloryRepository extends JpaRepository<Catelogy,Integer> {
}
