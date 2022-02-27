package com.sosam.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HikeRoadRepo extends JpaRepository<HikeRoad, String>{

	@Query(value="SELECT PMCODE, MCODE, MNAME, PMNAME, PMLENG, PMDIFF, SUM(PMUP) AS PMUP, SUM(PMDOWN) AS PMDOWN "
			+ "FROM HIKEROAD "
			+ "WHERE PMNAME <> :pmname "
			+ "AND MCODE=:mcode "
			+ "GROUP BY PMNAME",
			nativeQuery=true
	)
	Optional<List<HikeRoad>> findAllBymcode(@Param("mcode") String mcode, @Param("pmname") String pmname);

}
