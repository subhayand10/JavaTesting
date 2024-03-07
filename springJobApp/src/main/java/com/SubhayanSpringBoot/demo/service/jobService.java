package com.SubhayanSpringBoot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SubhayanSpringBoot.demo.model.jobModel;
import com.SubhayanSpringBoot.demo.repo.jobRepo;
import com.SubhayanSpringBoot.demo.repo.jobRepoDB;

@Service
public class jobService {
	@Autowired
	//private jobRepo repo;
	private jobRepoDB repo;
	
	public void addJob(jobModel jobPost) {
		//repo.getJob(jobPost);
		repo.save(jobPost);
	}
	
	public List<jobModel> getAllJobs(){
		//return repo.getAllJobs();
		return repo.findAll();
	}
	public jobModel getJob1  (int id){
		//return repo.getJob1(id);
		return repo.findById(id).orElse(new jobModel());
	}
	public void updateJob  (jobModel jobPost){
		System.out.println("here");
		repo.save(jobPost);
	}
	public void deleteJob  (int id){
		repo.deleteById(id);
	}
	public List<jobModel> search(String keyword){
		//return repo.getAllJobs();
		return repo.findBypostProfile(keyword);
	}
	public List<jobModel> searchExp(int exp){
		//return repo.getAllJobs();
		return repo.findByReqExperienceIsLessThanEqual(exp);
	}
}
