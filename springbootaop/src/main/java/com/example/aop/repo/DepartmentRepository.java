package com.example.aop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aop.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
