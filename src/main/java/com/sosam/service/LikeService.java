package com.sosam.service;

import java.util.List;
import java.util.Optional;

import com.sosam.model.Like;

public interface LikeService {

	Like likeClick(String mCode, String uId, String flag);

	String doILikeIt(String mCode, String uId);

}
