package com.quitq.ECom.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quitq.ECom.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor,Integer> {
@Query("select v from Product p join p.v vendor where p.id=?1")
	Vendor findByProductId(int id);
@Query("select v from Product p join p.v vendor join p.c cat where cat.categoryName=?1")
List<Vendor> findByCategoryName(String categoryName);



}
