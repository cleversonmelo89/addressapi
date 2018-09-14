package com.br.address.addressapi.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.address.addressapi.model.Address;
import com.br.address.addressapi.repository.AddressRepository;

@RestController
@RequestMapping("/address")
public class AddressResource {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Address> listAddress(){
		Iterable<Address> listAddress = addressRepository.findAll();
		return listAddress;
	}
	
	@GetMapping(value="/{id}", produces="application/json")
	public @ResponseBody Address findById(@PathVariable long id){
		Address getAddress = addressRepository.findOne(id);
		return getAddress;
	}
	
	@PutMapping()
	public Address updateAddress(@RequestBody @Valid Address address){
		Address getAddress = addressRepository.findOne(address.getId());
		address.setId(getAddress.getId());
		return addressRepository.save(address);
	}
	
	@PostMapping()
	public Address createAddress(@RequestBody @Valid Address address){
		return addressRepository.save(address);
	}
	
	@DeleteMapping()
	public Address deleteAddress(@RequestBody Address address){
		addressRepository.delete(address);
		return address;
	}
	
	@DeleteMapping(value="/{id}")
	public @ResponseBody Address deleteById(@PathVariable long id){
		Address getAddress = addressRepository.findOne(id);
		addressRepository.delete(getAddress);
		return getAddress;
	}

}
