package tfc.sdr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfc.sdr.model.Evento;
import tfc.sdr.repository.EventosRepository;

@Service
public class EventosServiceImpl implements IEventosService{

	@Autowired
	EventosRepository eventosRepo;
	
	@Override
	public List<Evento> buscarTodos() {
		return eventosRepo.findAll();
	}

}
