package tfc.sdr.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tfc.sdr.model.Viaje;

public interface ViajesRepository extends JpaRepository<Viaje, Integer>{

    @Query("SELECT v FROM Viaje v WHERE v.presupuesto BETWEEN :presupuestoMinimo AND :presupuestoMaximo")
    List<Viaje> findByPresupuestoBetween(@Param("presupuestoMinimo") Integer presupuestoMinimo, 
                                         @Param("presupuestoMaximo") Integer presupuestoMaximo);
}
	


