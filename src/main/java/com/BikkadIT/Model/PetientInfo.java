package com.BikkadIT.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hospital_Details")
public class PetientInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	
	private String paddress;
	
	private String pbloodgrp;
	
	private String pdieses;
	
	private int page;
	
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getPbloodgrp() {
		return pbloodgrp;
	}

	public void setPbloodgrp(String pbloodgrp) {
		this.pbloodgrp = pbloodgrp;
	}

	public String getPdieses() {
		return pdieses;
	}

	public void setPdieses(String pdieses) {
		this.pdieses = pdieses;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "PetientInfo [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", pbloodgrp=" + pbloodgrp
				+ ", pdieses=" + pdieses + ", page=" + page + "]";
	}
	
	
}
