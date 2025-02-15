package com.quitq.ECom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quitq.ECom.dto.MessageDto;
import com.quitq.ECom.exception.InputValidateionException;
import com.quitq.ECom.exception.InvalidIdException;
import com.quitq.ECom.model.Vendor;
import com.quitq.ECom.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	VendorService vendorService;
	@PostMapping("/add")
	public ResponseEntity<?> addVendor(@RequestBody Vendor v,MessageDto messageDto)
	{
		try {
			vendorService.validate(v);
			
		} catch (InputValidateionException e) {
			// TODO Auto-generated catch block
			messageDto.setMsg(e.getMessage());

			e.printStackTrace();

			return ResponseEntity.badRequest().body(messageDto);
		}
		return ResponseEntity.ok(vendorService.addVendor(v));
		
	}
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllVendor(MessageDto messageDto)
	{
		
		return ResponseEntity.ok(vendorService.getAll());
		
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getVendor(@PathVariable int id,MessageDto messageDto)
	{
		
		try {
			Vendor v=vendorService.findById(id);
			return ResponseEntity.ok(v);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			messageDto.setMsg(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(messageDto);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteVendor(@PathVariable int id,MessageDto messageDto)
	{
	try {
		vendorService.delete(id);
		return ResponseEntity.ok("Vendor deleted Successfully");
	} catch (InvalidIdException e) {
		// TODO Auto-generated catch block
		messageDto.setMsg(e.getMessage());
		e.printStackTrace();
		return ResponseEntity.badRequest().body(messageDto);
	}	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateVendor(@PathVariable int id,@RequestBody Vendor v,MessageDto messageDto)
	{
		try {
			Vendor vendor=vendorService.updateVendor(v, id);
			return ResponseEntity.ok(vendor);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			messageDto.setMsg(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(messageDto);
		}
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getVendorByProductName(@PathVariable int id,MessageDto messageDto)
	{
		Vendor v;
		try {
			v = vendorService.getVendorByProductId(id);
			return ResponseEntity.ok(v);

		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			messageDto.setMsg(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(messageDto);
		}
		}
	@GetMapping("/category/{categoryName}")
	public ResponseEntity<?> getVendorByCategoryName(@PathVariable String name,MessageDto messageDto)
	{
		List<Vendor> v;
		try {
			v = vendorService.getVendorsByCategoryName(name);
			return ResponseEntity.ok(v);

		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			messageDto.setMsg(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(messageDto);
		}
		}
		
	}


