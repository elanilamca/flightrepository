package com.elango.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.elango.entities.Location;

@EnableJpaRepositories
public interface LocationRepository extends JpaRepository<Location, Integer>{

	@Query(value = "select loc.type,count(loc.type) from location as loc group by loc.type",nativeQuery = true)
	public List<Object[]> findTypeAndTypeCount();
	
	//nativeQuery = true
	
	// @Query("select h from HomepageSection as h where parent_id = :parentid and del_flag = '0'")
	  //  List<HomepageSection> findChildrenSectionsByParent(@Param("parentid") String parentid);
}
