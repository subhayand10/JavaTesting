package com.SubhayanSpringBoot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.SubhayanSpringBoot.demo.model.jobModel;
import com.SubhayanSpringBoot.demo.service.jobService;

@Controller
public class jobController {
	@Autowired
	private jobService service;

	@GetMapping({ "/", "home" })
	public String home() {
		return "home";
	}

	@GetMapping("/addjob")
	public String addJob() {
		return "addjob";
	}

	@PostMapping("/handleForm")
	public String handleForm(@ModelAttribute("jobPost") jobModel jobPost) {
		service.addJob(jobPost);
		return "success";
	}

	@GetMapping("/viewalljobs")
	public String viewJobs(Model m) {
		List<jobModel> jobs = service.getAllJobs();
		m.addAttribute("jobPosts", jobs);
		return "viewalljobs";
	}

	@GetMapping("/jobPosts")
	@ResponseBody
	public List<jobModel> getAlllJobs() {
		return service.getAllJobs();
	}

	@GetMapping("/jobPosts/{id}")
	@ResponseBody
	public jobModel getJob(@PathVariable int id) {
		return service.getJob1(id);
	}

	@PostMapping("/jobPosts")
	@ResponseBody
	public jobModel postData(@RequestBody jobModel jobPost) {
		service.addJob(jobPost);
		return service.getJob1(jobPost.getPostId());
	}

	@PutMapping("/jobPosts")
	@ResponseBody
	public jobModel putData(@RequestBody jobModel jobPost) {
		service.updateJob(jobPost);
		System.out.println("here");
		return service.getJob1(jobPost.getPostId());
	}

	@DeleteMapping("/jobPosts/{id}")
	public String deleteData(@PathVariable int id) {
		service.deleteJob(id);
		return "Deleted";
	}
	
	@GetMapping("/jobPosts/keyword/{keyword}")
	@ResponseBody
	public List<jobModel> search(@PathVariable String keyword) {
		return service.search(keyword);
	}
	@GetMapping("/jobPosts/exp/{exp}")
	@ResponseBody
	public List<jobModel> searchExp(@PathVariable  int exp) {
		return service.searchExp(exp);
	}

} 
