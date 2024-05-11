package tfc.sdr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
