package com.ojt.bs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojt.bs.entity.Project;
import com.ojt.bs.service.ProjectService;

@RestController
@RequestMapping("project")
public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@PostMapping("/create")
	public ResponseEntity<Project>save(@Valid @RequestBody Project project){		
		Project newProject = projectService.create(project);
	return new ResponseEntity<Project>(newProject,HttpStatus.ACCEPTED);
		
	}
	@GetMapping(value = "/list")
	public ResponseEntity<List<Project>>getAllProjects(){
		List<Project> project = projectService.getAll();
		return new ResponseEntity<List<Project>>(project,HttpStatus.OK);
		
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Project>getProject(@PathVariable int id){
		Project project = projectService.get(id);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
		
}
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Project>updateProduct(@Valid @RequestBody Project project){
		Project newProduct = projectService.update(project);
		return new ResponseEntity<Project>(newProduct,HttpStatus.OK);
		
}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?>deleteProduct(@PathVariable int id){
//		Project project = projectService.get(id);
//		if (project == null) {
//			return ResponseEntity.notFound().build();
//		}
//		boolean isDeleted = projectService.delete(id);
//		
//		if (!isDeleted) {
//			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//		}
		projectService.delete(id);
		return ResponseEntity.ok().build();
		
}

}
