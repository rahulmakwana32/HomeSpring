package com.home.dataservice.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.dataservice.model.MetaData;
import com.home.dataservice.service.DaoService;

@RestController
@CrossOrigin(origins = {"http://localhost:3000","http://10.0.0.146:3000"})
@RequestMapping("/api")
public class DaoController {

	@Autowired
	DaoService dao;

	@RequestMapping(value = "/savefilemetadata", method = RequestMethod.POST)
	public String savefilemetadate(@RequestBody List<MetaData> file) {

 
		file.forEach(f -> dao.addMetatData(f));

		return "File metadata save successfully";
	}
	
	
	@RequestMapping(value="/getFiles/{username}",method =RequestMethod.GET)
 	public List<MetaData> getFiles(@PathVariable("username") String username ){
		System.out.println("Fetch "+username);
		return	dao.getFiles(username);
		 
		
	}
	
	
	@RequestMapping(value="/deletefiles/{id}",method =RequestMethod.GET)
	public String deleteFile(@PathVariable("id") Integer id ){
		System.out.println("softdelete "+id);
		 	dao.softdelete(id);
		
		return "Updated Metata Succesfully";
		 
		
	}

}
