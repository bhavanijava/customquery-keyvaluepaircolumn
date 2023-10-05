package com.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

	@Query(value = "SELECT * FROM spring.college WHERE JSON_EXTRACT(properties, CONCAT('$.\"', :key, '\"')) = :value ", nativeQuery = true)
	    List<College> findCollegesByAddress(@Param("key") String key, @Param("value") String value);
	
}
