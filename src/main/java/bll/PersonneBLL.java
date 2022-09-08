package bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.Personne;
import dal.PersonneDAO;

@Service
public class PersonneBLL {
	@Autowired
	private PersonneDAO dao;
	
	public List<Personne> selectAll() {
		return dao.findAll();
	}
	
	public Personne selectById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Personne p) {
		dao.save(p);
	}
	
	public void delete(Personne p) {
		dao.delete(p);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public boolean contains(int id) {
		return dao.existsById(id);
	}
}
