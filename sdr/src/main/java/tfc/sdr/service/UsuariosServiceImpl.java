package tfc.sdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfc.sdr.model.Usuario;
import tfc.sdr.repository.UsuarioRepository;

@Service
public class UsuariosServiceImpl implements IUsuariosService{
	
	@Autowired
	UsuarioRepository usuariosRepo;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuariosRepo.save(usuario);
	}

}
