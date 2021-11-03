package com.verizonnate;

import java.util.List;
import java.util.NoSuchElementException;

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

@RestController  //telling spring that this control handles request for restful webservices
public class ContactController {

	@Autowired
	private ContactService service;
	
@GetMapping("/contacts")
public List<Contact> list() {
    return service.listAll();
}
	
@GetMapping("/contact/{id}")
public ResponseEntity<Contact> get(@PathVariable Integer id) {
    try {
        Contact contact = service.get(id);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
    }      
}

@PostMapping("/contacts")
public void add(@RequestBody Contact contact) {
    service.save(contact);
}

@PutMapping("/contact/{id}")
public ResponseEntity<?> update(@RequestBody Contact contact, @PathVariable Integer id) {
    try {
        Contact existbook = service.get(id);
        service.save(contact);
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }      
}

@DeleteMapping("/contact/{id}")
public void delete(@PathVariable Integer id) {
    service.delete(id);
}


}
