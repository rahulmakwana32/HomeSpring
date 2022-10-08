package com.home.dataservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.dataservice.model.MetaData;

public interface LookupRepo extends JpaRepository<MetaData, Integer> {

}
