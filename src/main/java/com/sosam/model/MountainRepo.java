package com.sosam.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MountainRepo extends JpaRepository<Mountain, String>{

	List<Mountain> findBymNameContains(String mName);

	Mountain findBymCode(String mCode);

	@Query("SELECT todo FROM Todo todo where todo.item like %:item% order by todo.id desc")  
	List<Mountain> findUseJPQL(@Param("item") String item);  
}
