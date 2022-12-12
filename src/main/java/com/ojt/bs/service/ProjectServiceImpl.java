package com.ojt.bs.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojt.bs.entity.Project;
import com.ojt.bs.repository.ProjectRepository;
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectRepository;
	
	@Override
	public List<Project> getAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project get(int id) {
		return projectRepository.findById(id).orElse(null);
	}

	@Override
	public Project create(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project update(Project project) {
		Project orginalProject  = projectRepository.findById(project.getId()).orElse(null);
		
		if(orginalProject!= null) {
			orginalProject.setName(project.getName());
			orginalProject.setMember(project.getMember());
			orginalProject.setProject_status(null);
			orginalProject.setStartDate(LocalDate.now());
			orginalProject = projectRepository.save(orginalProject);
		}
		return orginalProject;
		}
	@Override
	public boolean delete(int id) {
		Project project = this.get(id);
		if(project == null) {
			return false;
		}
		 projectRepository.deleteById(id);
		 return true;
	}

}
