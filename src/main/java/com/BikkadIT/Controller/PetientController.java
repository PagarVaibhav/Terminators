package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.Model.PetientInfo;
import com.BikkadIT.Service.ServiceImpl;

@RestController
public class PetientController {

	@Autowired
	private ServiceImpl serviceImpl;
	
	@PostMapping(value="/save" , consumes="application/json")
	public ResponseEntity<String> save(@RequestBody PetientInfo petientInfo){
		int savedata = serviceImpl.savedata(petientInfo);
		if(savedata!=0) {
			return new ResponseEntity<String>("Data save Successfully" , HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Data Not Saved", HttpStatus.BAD_REQUEST);
	}
	@GetMapping(value="/getData", produces="application/json")
	public ResponseEntity<List<PetientInfo>> getAllData (){
		List<PetientInfo> list = serviceImpl.getall();
		
		return new ResponseEntity<List<PetientInfo>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/getsingleData/{id}", produces="application/json")
	public ResponseEntity<PetientInfo>getPartiData(@PathVariable int id){
		PetientInfo getparticulardata = serviceImpl.getparticulardata(id);
		return new  ResponseEntity<PetientInfo>(getparticulardata,HttpStatus.OK);
		
	}
	
	
}
