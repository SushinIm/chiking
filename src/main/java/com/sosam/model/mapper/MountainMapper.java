package com.sosam.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sosam.model.FilterVo;
import com.sosam.model.MountainJoin;

@Mapper
public interface MountainMapper {
    public List<MountainJoin> mntnFilter(FilterVo f) throws Exception;
}
