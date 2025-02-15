package com.quitq.ECom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quitq.ECom.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
@Query("select p from Product p join p.v vendor where vendor.name=?1")
public List<Product> getByVendorName(String name);
@Query("select p from Product p join p.c category where category.categoryName=?1")
public List<Product> getByCategoryName(String name);
@Query("select p from Product p where p.status=?1")
public List<Product> findByStatus(String status);
@Query("select p from Product p join p.warehouse w where w.id=?1")
public List<Product> getByWarehouseId(int id);
}
