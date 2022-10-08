package com.home.dataservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import net.bytebuddy.implementation.bind.annotation.Default;

@Entity
@JsonIgnoreType
@JsonIgnoreProperties
public class MetaData {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer fileid;
	String filename, filetype, username, filestatus;
	Integer size;

	public MetaData() {
		super();
	}

	Date uploadeddate, deleteddate;
	Boolean isFile;
	Boolean active;
	public Integer getFileid() {
		return fileid;
	}

	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFilestatus() {
		return filestatus;
	}

	public void setFilestatus(String filestatus) {
		this.filestatus = filestatus;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Date getUploadeddate() {
		return uploadeddate;
	}

	public void setUploadeddate(Date uploadeddate) {
		this.uploadeddate = uploadeddate;
	}

	public Boolean getIsFile() {
		return isFile;
	}

	public void setIsFile(Boolean isFile) {
		this.isFile = isFile;
	}

	public Date getDeleteddate() {
		return deleteddate;
	}

	public void setDeleteddate(Date deleteddate) {
		this.deleteddate = deleteddate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public MetaData(Integer fileid, String filename, String filetype, String username, String filestatus, Integer size,
			Date uploadeddate, Date deleteddate, Boolean isFile, Boolean active) {
		super();
		this.fileid = fileid;
		this.filename = filename;
		this.filetype = filetype;
		this.username = username;
		this.filestatus = filestatus;
		this.size = size;
		this.uploadeddate = uploadeddate;
		this.deleteddate = deleteddate;
		this.isFile = isFile;
		this.active = active;
	}

	@Override
	public String toString() {
		return "MetaData [fileid=" + fileid + ", filename=" + filename + ", filetype=" + filetype + ", username="
				+ username + ", filestatus=" + filestatus + ", size=" + size + ", uploadeddate=" + uploadeddate
				+ ", deleteddate=" + deleteddate + ", isFile=" + isFile + ", active=" + active + "]";
	}

 

}
