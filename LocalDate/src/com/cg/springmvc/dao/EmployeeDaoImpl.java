package com.cg.springmvc.dao;

import java.util.List;




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvc.dto.Employee;

@Repository("emplyeedao")
public class EmployeeDaoImpl implements IEmployeeDao{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public Employee addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		em.persist(emp);
		em.flush();
		return emp;
	}

	

	

}
