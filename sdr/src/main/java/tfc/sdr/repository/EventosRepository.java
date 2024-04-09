package tfc.sdr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tfc.sdr.model.Evento;

public interface EventosRepository extends JpaRepository<Evento, Integer>{

}
