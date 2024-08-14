package com.ems.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.JpaSort.Path;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ems.entity.Employee;
import com.ems.service.EmpService;


import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private EmpService empservice;
	
	@GetMapping("/")
	public String index(Model m) {
	List<Employee> list = empservice.getAllEmp();
	long count = empservice.countEmployees();
	m.addAttribute("emplst",list);
	 m.addAttribute("count", count); 
		return "emplist";
	}
	
	@GetMapping("/create")
	public String create() {
		return "createemp";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model m) {
		Employee emp = empservice.getEmpById(id);
		m.addAttribute("emp",emp);
		return "editemp";
	}
	

	
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee employee, HttpSession session)
			  {
	Employee newEmp=empservice.saveEmp(employee);
		
		if(newEmp != null)
		{
		session.setAttribute("succmsg", "Register successfully");
		}
		else {
			session.setAttribute("msg", "Something wrong");
		}
		return "redirect:/clearSession";
	}
	
	
	@PostMapping("/updateemp")
	public String updateemp(@ModelAttribute Employee employee, HttpSession session)
			  {
	Employee updateemp=empservice.saveEmp(employee);
		
		if(updateemp != null)
		{
		session.setAttribute("umsg", "Updated successfully");
		}
		else {
			session.setAttribute("smsg", "Something went wrong");
		}
		return "redirect:/clearSession";
	}
	
	@GetMapping("/deleteemp/{id}")
	public String deleteemp(@PathVariable int id, HttpSession session) {
		boolean d = empservice.deleteEmp(id);
		if(d) {
			session.setAttribute("dmsg", "Deleted successfully");
		}else{
			session.setAttribute("dmsg", "Something went wrong");
		}
		return "redirect:/clearSession";
	}
		
	
	  @GetMapping("/clearSession")
	    public String clearSessionMessages(HttpSession session) {
	        session.removeAttribute("succmsg");
	        session.removeAttribute("msg");
	        session.removeAttribute("umsg");
	        session.removeAttribute("smsg");
	        session.removeAttribute("dmsg");
	        return "redirect:/";
	    }
	
	

}

