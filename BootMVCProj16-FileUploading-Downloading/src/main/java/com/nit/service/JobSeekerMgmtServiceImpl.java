package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.JobSeekerInfo;
import com.nit.repo.IJobSeekerRepo;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJobSeekerRepo jsRepo;

	@Override
	public String registerJobSeeker(JobSeekerInfo info) {
		return "Job Seeker is saved with "+jsRepo.save(info).getJsId()+" id value";
	}

	@Override
	public List<JobSeekerInfo> fetchAllJobSeekers() {
		return jsRepo.findAll();
	}
	
	@Override
	public String fetchResumePathByJsId(Integer jsid) {
		return jsRepo.getResumePathByJsId(jsid);
	}
	
	@Override
	public String fetchPhotoPathByJsId(Integer jsid) {
		return jsRepo.getPhotoPathByJsId(jsid);
	}
	
}
