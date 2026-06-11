package it.corso.bootcamp.controller;


import it.corso.bootcamp.dto.StudenteResponseDTO;
import it.corso.bootcamp.service.StudenteService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudenteController {

	
	private final StudenteService stu;
	
	public StudenteController(StudenteService ps) {
		this.stu = ps;
	}
	
	
	
	@GetMapping("/api/studenti")
	public List<StudenteResponseDTO> findAll() {
	return stu.findAll();

	
	}
	
}


