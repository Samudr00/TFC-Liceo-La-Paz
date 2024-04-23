package tfc.sdr.service;

import java.util.List;

import tfc.sdr.model.Evento;

public interface IEventosService {
	
	List<Evento> buscarTodos();
	
	Evento buscarPorId(int idEvento);

	Evento guardarEvento(Evento evento);

}
