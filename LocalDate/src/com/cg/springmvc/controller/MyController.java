package com.cg.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvc.dto.Employee;
import com.cg.springmvc.service.IEmployeeService;



@Controller
public class MyController {
	@Autowired
	IEmployeeService employeeservice;
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String getAll(){
		return "home";
		
	}
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addEmployee(@ModelAttribute("my") Employee emp,Map<String,Object> model ){
		List<String> myDeg=new ArrayList<>();
		myDeg.add("SoftWare Engg");
		myDeg.add("Sr Consoltant");
		myDeg.add("Manager");
		model.put("deg",myDeg);
		return "addemployee";
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@Valid @ModelAttribute("my") Employee emp,BindingResult result,Map<String,Object> model) {
		//System.out.println("Name is "+emp.getEmpName());
		Employee employee = null;
		if(result.hasErrors()){
			List<String> myDeg=new ArrayList<>();
			myDeg.add("SoftWare Engg");
			myDeg.add("Sr Consoltant");
			myDeg.add("Manager");
			model.put("deg",myDeg);
			return new ModelAndView("addemployee");
		}else{
			employee.setDate(new Date());
			employee = employeeservice.addEmployeeData(emp);
		}
		return new ModelAndView("success","edata",employee);
		
	}
	
}
