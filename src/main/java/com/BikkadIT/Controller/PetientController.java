package com.BikkadIT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping(value="/addMultiple" , consumes = "application/json")
	public ResponseEntity<List<PetientInfo>> saveMultiData(@RequestBody List<PetientInfo> petientInfos){
		List<PetientInfo> saveMultiple = serviceImpl.saveMultiple(petientInfos);
		
		return new ResponseEntity<List<PetientInfo>>(saveMultiple , HttpStatus.CREATED);
		}
	
	
	@GetMapping(value="/getAllData", produces="application/json")
	public ResponseEntity<List<PetientInfo>> getAllData (){
		List<PetientInfo> list = serviceImpl.getall();
		
		return new ResponseEntity<List<PetientInfo>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/getsingleData/{id}", produces="application/json")
	public ResponseEntity<PetientInfo>getPartiData(@PathVariable int id){
		PetientInfo getparticulardata = serviceImpl.getparticulardata(id);
		return new  ResponseEntity<PetientInfo>(getparticulardata,HttpStatus.OK);
		
	}
	@PutMapping(value="/updateData", consumes="application/json")
	public ResponseEntity<String> updateData(@RequestBody PetientInfo petientInfo){
		PetientInfo updatedata = serviceImpl.updatedata(petientInfo);
		
		return new ResponseEntity<String>("DATA Update",HttpStatus.OK);
		
	} 
	@PostMapping(value="/login", consumes="application/json")
	public ResponseEntity<String> login(@RequestBody PetientInfo petientInfo){
		PetientInfo logincheck = serviceImpl.logincheck(petientInfo);
		
		if(logincheck!=null) {
			
		return new  ResponseEntity<String>("login Successfull",HttpStatus.OK);
		}
		return new  ResponseEntity<>("login Failed",HttpStatus.BAD_REQUEST);
		
	}
	@DeleteMapping(value="/Delete/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable int id){
		PetientInfo deleteById = serviceImpl.deleteById(id);
		return new ResponseEntity<String>("Data Deleted",HttpStatus.OK);
		
	}
	@DeleteMapping(value="/DeleteAll")
	public ResponseEntity<String> deleteAllData (){
		serviceImpl.deleteall();
		return new ResponseEntity<String>("DELETED All DATA",HttpStatus.OK);
		
		
	}
	
}
