package tfc.sdr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfc.sdr.model.Evento;
import tfc.sdr.model.Viaje;
import tfc.sdr.repository.ViajesRepository;

@Service
public class ViajesServiceImpl implements IViajesService{

	@Autowired
	ViajesRepository viajesRepo;
	
	@Override
	public List<Viaje> buscarTodos() {
		return viajesRepo.findAll();
	}

	@Override
	public Viaje buscarPorId(int idViaje) {
		Optional<Viaje> optional = viajesRepo.findById(idViaje);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Viaje guardarViaje(Viaje viaje) {
		return viajesRepo.save(viaje);
	}

	@Override
	public void eliminarViaje(int idViaje) {
		viajesRepo.deleteById(idViaje);
	}

	@Override
	public List<Viaje> buscarPorPresupuesto(Integer presupuestoMinimo, Integer presupuestoMaximo) {
	    return viajesRepo.findByPresupuestoBetween(presupuestoMinimo, presupuestoMaximo);
	}

	
	
	
}
