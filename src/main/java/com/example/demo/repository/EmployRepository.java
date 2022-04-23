package com.example.demo.repository;
import com.example.demo.model.Employe;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface EmployRepository extends JpaRepository <Employe , Long>{
	

}
