package tfc.sdr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import tfc.sdr.model.Evento;
import tfc.sdr.model.Verificacion;

public interface EventosRepository extends JpaRepository<Evento, Integer>{

	List<Evento> findByVerificacion(Verificacion verificado);

}
