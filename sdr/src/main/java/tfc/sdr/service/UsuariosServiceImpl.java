package tfc.sdr.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
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

	
	 
	 @Override
		public Usuario findById(int id) {
			Optional<Usuario> optional = usuariosRepo.findById(id);
			if(optional.isPresent()) {
				return optional.get();
			}
			return null;
		}
	 
	 	@Override
	    @Transactional(readOnly = true)
	    public Usuario buscarPorUsername(String username) {
	        return usuariosRepo.findByUsername(username);
	    }
	}


