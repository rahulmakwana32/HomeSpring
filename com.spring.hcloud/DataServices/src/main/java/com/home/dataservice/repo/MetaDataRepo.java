package com.home.dataservice.repo;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.home.dataservice.model.MetaData;
 

public interface MetaDataRepo extends JpaRepository<MetaData, Integer> {

	List<MetaData> findByUsername(String username);
	
	//List<MetaData> findByUsernameAndActiveIsEqualTo(String username,Integer id);
	
	MetaData findByFileid(Integer id);

	List<MetaData> findByUsernameAndActive(String username, Boolean i);

} 