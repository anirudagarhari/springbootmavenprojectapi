package com.example.demo.services;
import java.util.List;
import com.example.demo.model.Employe;

public interface Employservice {
	List<Employe> getAllEmploye();
	void saveEmploye(Employe employe);
	
	Employe getEmployeById(long id);
	
	void deleteEmployeById(long id);

}
