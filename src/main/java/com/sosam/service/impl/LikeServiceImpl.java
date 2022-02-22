package com.sosam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sosam.model.Like;
import com.sosam.model.LikeId;
import com.sosam.model.LikeRepo;
import com.sosam.service.LikeService;

@Service("likeService")
public class LikeServiceImpl implements LikeService {

	private LikeRepo likeRepo;
	
	public LikeServiceImpl(LikeRepo likeRepo) {
		this.likeRepo = likeRepo;
	}
	
	@Override
	public Like likeClick(String mCode, String uId, String flag) {
		LikeId likeid = new LikeId(mCode, uId);
		return this.likeRepo.save(new Like(likeid, flag));
	}
}
