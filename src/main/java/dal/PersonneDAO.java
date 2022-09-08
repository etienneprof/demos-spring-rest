package dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.Personne;

@Repository
public interface PersonneDAO extends JpaRepository<Personne, Integer> {

}
