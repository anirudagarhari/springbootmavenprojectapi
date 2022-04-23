package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employe;
import com.example.demo.repository.EmployRepository;
@Service


public class EmployserviceImp implements Employservice{
	@Autowired
private EmployRepository employeRepository;
	@Override
	public List<Employe> getAllEmploye() {
		// TODO Auto-generated method stub
		return  employeRepository.findAll();
	}
	@Override
	public void saveEmploye(Employe employe) {
		// TODO Auto-generated method stub
		this.employeRepository.save(employe);
		
	}
	@Override
	public Employe getEmployeById(long id)
	{
		Optional<Employe> optional=employeRepository.findById(id);
		Employe employe=null;
		if(optional.isPresent()) {
			employe =optional.get();
			
		}else
		{
			throw new RuntimeException("Employe not found for id ::"+id);
		}
		return employe;
		
	}
	@Override
	public void deleteEmployeById(long id)
	{
		this.employeRepository.deleteById(id);
	}
	
	

}
