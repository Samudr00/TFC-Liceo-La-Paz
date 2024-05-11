package tfc.sdr.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="viajes")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String destino;
	private String salida;
	@Enumerated(value = EnumType.STRING)
	private Transporte transporte;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Integer presupuesto;
	private String descripcion;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getSalida() {
		return salida;
	}
	public void setSalida(String salida) {
		this.salida = salida;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Integer getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(Integer presupuesto) {
		this.presupuesto = presupuesto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Viaje [id=" + id + ", destino=" + destino + ", salida=" + salida + ", transporte=" + transporte
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", presupuesto=" + presupuesto
				+ ", descripcion=" + descripcion + "]";
	}

	
	
}
