package com.ojt.bs.service;

import java.util.List;

import com.ojt.bs.entity.Project;

public interface ProjectService {
	
	public List<Project> getAll();

	public Project get(int id);

	public Project create(Project user);

	public Project update(Project user);

	public boolean delete(int id);


}
