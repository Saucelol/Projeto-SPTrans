package asdasf.daf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asdasf.daf.entities.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Integer> {

}
