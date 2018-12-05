package com.cg.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springmvc.dao.IEmployeeDao;
import com.cg.springmvc.dto.Employee;

@Service("employeeservice")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public Employee addEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployeeData(emp);
	}


	

	
}
