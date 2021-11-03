package com.verizonnate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


import java.util.List;

@Service 
@Transactional
public class ContactService {

	@Autowired
	private ContactRepository repo;  //making instance of product repo
	
	public List<Contact> listAll(){
		return repo.findAll();
		
		
	}
	
	public void save(Contact contact) {
		repo.save(contact);
	}
	public Contact get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
