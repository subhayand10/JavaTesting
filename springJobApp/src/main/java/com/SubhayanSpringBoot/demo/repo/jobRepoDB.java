package com.SubhayanSpringBoot.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SubhayanSpringBoot.demo.model.jobModel;

public interface jobRepoDB extends JpaRepository<jobModel, Integer> {
	
	List<jobModel> findBypostProfile(String postProfile);
	List<jobModel> findByReqExperienceIsLessThanEqual(int exp);

}
