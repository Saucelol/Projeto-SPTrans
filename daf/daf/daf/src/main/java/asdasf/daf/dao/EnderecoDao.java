package asdasf.daf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asdasf.daf.entities.Endereco;

@Repository
public interface EnderecoDao extends JpaRepository<Endereco, Integer> {

}
