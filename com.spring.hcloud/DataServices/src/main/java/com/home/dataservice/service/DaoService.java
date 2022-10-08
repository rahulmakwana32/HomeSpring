package com.home.dataservice.service;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.dataservice.model.MetaData;
import com.home.dataservice.repo.MetaDataRepo;

@Service
public class DaoService {

	@Autowired
	MetaDataRepo repo;

	public void addMetatData(MetaData f) {
        f.setActive(true);
		repo.save(f);

	}

	public List<MetaData> getFiles(String username) {
		return repo.findByUsernameAndActive(username,true);
		
	}

	public void softdelete(Integer id) {
		// TODO Auto-generated method stub
		
        MetaData fetchid= repo.findByFileid(id);
		fetchid.setActive(false);
		fetchid.setDeleteddate(new Date());
 		repo.save(fetchid);
	}

}
