package com.example.product.repository;

import com.example.product.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    //    @Query("select c from Customer as c where c.customerName like %?1% and c.customerAddress like %?2% and c.customerEmail like %?3%")
//    Page<Customer> search(String name,String address, String email, Pageable pageable);

    Page<Product>findAllByProductNameContainingAndCatelogy_CatelogyName(String name, String catelogyName, Pageable pageable);

    Page<Product>findAllByProductNameContaining(String name,Pageable pageable);
}
