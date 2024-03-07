package com.SubhayanSpringBoot.demo.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SubhayanSpringBoot.demo.model.jobModel;

@Repository
public class jobRepo {
	List<jobModel> jobs = new ArrayList<jobModel>(Arrays.asList(
			new jobModel(1, "Java Dev", "Java and Spring Knowledge", 2,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
			new jobModel(2, "Java Boot Dev", "Java and Spring Boot Knowledge", 4,
					List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
			new jobModel(3, "AWS Dev", "AWS with Java and Spring Boot Knowledge", 1,
					List.of("AWS", "J2EE", "Spring Boot", "Hibernate"))));

	public List<jobModel> getAllJobs() {
		return jobs;
	}

	public void getJob(jobModel job) {
		jobs.add(job);
	}

	public jobModel getJob1(int id) {
		for (jobModel job : jobs) {
			if (job.getPostId() == id) {
				return job;
			}
		}
		return null;
	}

	public void updateJob(jobModel jobPost) {
		System.out.println("here");
		for (jobModel job : jobs) {
			if (job.getPostId() == jobPost.getPostId()) {
				job.setPostDesc(jobPost.getPostDesc());
				job.setPostProfile(jobPost.getPostProfile());
				job.setPostTechStack(jobPost.getPostTechStack());
				job.setReqExperience(jobPost.getReqExperience());
			}
		}
	}


	public void deleteJob(int id) {
		for (jobModel job : jobs) {
			if (job.getPostId() == id) {
				jobs.remove(job);
			}
		}
	}
}
