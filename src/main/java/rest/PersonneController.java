package rest;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bll.PersonneBLL;
import bo.Personne;

@RestController
@RequestMapping(path = "/personnes")
public class PersonneController {
	@Autowired
	private PersonneBLL bll;
	
	@GetMapping
	public ResponseEntity<List<Personne>> selectAll() {
		return new ResponseEntity<List<Personne>>(bll.selectAll(), HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Personne> selectById(@PathVariable("id") int id) {
		if (bll.contains(id)) {
			return new ResponseEntity<Personne>(bll.selectById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<Personne> insert(@RequestBody Personne p) {
		bll.save(p);
		return new ResponseEntity<Personne>(p, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Personne> update(
			@PathVariable("id") int id,
			@RequestBody Personne p) {
		if (bll.contains(id)) {
			p.setId(id);
			bll.save(p);
			return new ResponseEntity<Personne>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<Personne>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Personne> delete(@PathVariable("id") int id) {
		if (bll.contains(id)) {
			Personne p = bll.selectById(id);
			bll.delete(p);
			return new ResponseEntity<Personne>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<Personne>(HttpStatus.CONFLICT);
		}
	}
}