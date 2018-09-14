package com.br.address.addressapi.resource;

import javax.persistence.GeneratedValue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.br.address.addressapi.AddressapiApplicationTests;
import com.br.address.addressapi.model.Address;
import com.br.address.addressapi.repository.AddressRepository;

public class AddressResourcetest extends AddressapiApplicationTests{
	
	private MockMvc mockMvc;
	
	@Autowired
	private AddressResource addressResource;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(addressResource).build();
	}
	
	@Test
	public void testGETAddressResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/address")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETIdAddressResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/address/1"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPOSTAddressResource() throws Exception {
		String json = "{ \"rua\": \"rua\", \"numero\": 0, \"cep\": \"cep\", \"cidade\": \"cidade\", \"estado\": \"estado\", \"bairro\": \"bairro\", \"complemento\": \"complemento\" }";
		this.mockMvc.perform(MockMvcRequestBuilders.post("/address")
				.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
				.content(json)
				).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPUTAddressResource() throws Exception {
		
		Address address = new Address();
		address.setRua("rua");
		address.setNumero(2);
		address.setCep("cep");
		address.setCidade("cidade");
		address.setEstado("estado");
		addressRepository.save(address);
		Address return_address = addressRepository.findAll().get(0); 
		String json = "{ \"id\": "+return_address.getId()+", \"rua\": \"rua\", \"numero\": 1, \"cep\": \"cep\", \"cidade\": \"cidade\", \"estado\": \"estado\", \"bairro\": \"bairro\", \"complemento\": \"complemento\" }";
		this.mockMvc.perform(MockMvcRequestBuilders.put("/address")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json)
				).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testDELETEAddressResource() throws Exception {
		Address address = new Address();
		address.setRua("rua");
		address.setNumero(2);
		address.setCep("cep");
		address.setCidade("cidade");
		address.setEstado("estado");
		addressRepository.save(address);
		Address return_address = addressRepository.findAll().get(0); 
		this.mockMvc.perform(MockMvcRequestBuilders.delete("/address/"+return_address.getId()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
