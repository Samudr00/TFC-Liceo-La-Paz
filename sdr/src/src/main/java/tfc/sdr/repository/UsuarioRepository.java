package tfc.sdr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tfc.sdr.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
}
