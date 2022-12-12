package com.ojt.bs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ojt.bs.entity.Project;
@EnableJpaRepositories
public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
