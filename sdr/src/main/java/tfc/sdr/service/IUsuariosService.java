package tfc.sdr.service;

import tfc.sdr.model.Usuario;

public interface IUsuariosService {

	Usuario guardarUsuario(Usuario usuario);
	
	Usuario findById(int id);

	Usuario buscarPorUsername(String username);
}
