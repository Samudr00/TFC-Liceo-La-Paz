package tfc.sdr.service;

import java.util.List;

import org.springframework.data.domain.Example;

import tfc.sdr.model.Evento;

public interface IEventosService {
	
	List<Evento> buscarTodos();
	
	Evento buscarPorId(int idEvento);

	Evento guardarEvento(Evento evento);

	void eliminar(int idEvento);

	List<Evento> buscarByExample(Example<Evento> example);

}
