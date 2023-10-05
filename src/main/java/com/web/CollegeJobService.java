package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CollegeJobService {

	@Autowired
	private CollegeRepository collegeRepository;
	
	@Scheduled(cron = "*/5 * * * * *")
	public void m1() {
		List<College> colleges	= collegeRepository.findCollegesByAddress("1","123 Main St, City1");
		System.out.println(colleges);
	}
}
