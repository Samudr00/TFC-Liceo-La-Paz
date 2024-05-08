package tfc.sdr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

	@Override
	public Evento buscarPorId(int idEvento) {
		Optional<Evento> optional = eventosRepo.findById(idEvento);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Evento guardarEvento(Evento evento) {
		return eventosRepo.save(evento);
	}
	
	@Override
	public void eliminar(int idEvento) {
		eventosRepo.deleteById(idEvento);
	}

	@Override
	public List<Evento> buscarByExample(Example<Evento> example) {
		return eventosRepo.findAll(example);
	}

}
