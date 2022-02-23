package com.sosam.model.mapper;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sosam.model.Mountain;
import com.sosam.model.MountainJoin;

@Repository
public interface MountainMapper {
    public Optional<List<MountainJoin>> mntnFilter(MountainJoin mj) throws Exception;
}
