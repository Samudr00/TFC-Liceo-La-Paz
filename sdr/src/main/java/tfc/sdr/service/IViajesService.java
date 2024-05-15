package tfc.sdr.service;

import java.util.List;

import tfc.sdr.model.Viaje;

public interface IViajesService {

	List<Viaje> buscarTodos();

	Viaje buscarPorId(int idViaje);

	Viaje guardarViaje(Viaje viaje);

	void eliminarViaje(int idViaje);

	List<Viaje> buscarPorPresupuesto(Integer presupuestoMinimo, Integer presupuestoMaximo);
}
