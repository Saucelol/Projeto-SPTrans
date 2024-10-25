package asdasf.daf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asdasf.daf.entities.Bilhete;

@Repository
public interface BilheteDao extends JpaRepository<Bilhete, Integer> {

}
