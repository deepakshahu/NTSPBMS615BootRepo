package com.nit.service;

import java.util.List;

import com.nit.entity.JobSeekerInfo;

public interface IJobSeekerMgmtService {
	public String registerJobSeeker(JobSeekerInfo info);
	public List<JobSeekerInfo> fetchAllJobSeekers();
	public String fetchResumePathByJsId(Integer jsid);
	public String fetchPhotoPathByJsId(Integer jsid);
}
