package com.br.address.addressapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.address.addressapi.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
