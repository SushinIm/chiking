package com.sosam.model.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.sosam.model.MountainJoin;

@Mapper
public interface MountainMapper {
    public List<MountainJoin> mntnFilter(MountainJoin mj) throws Exception;
}
