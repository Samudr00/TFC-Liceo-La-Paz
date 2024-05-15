package tfc.sdr.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Enumerated(value = EnumType.STRING)
	private TransporteRegreso transporteRegreso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	private Integer presupuesto;
	private String descripcion;
	private String horaSalida;
	private String horaRegreso;
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
	public TransporteRegreso getTransporteRegreso() {
		return transporteRegreso;
	}
	public void setTransporteRegreso(TransporteRegreso transporteRegreso) {
		this.transporteRegreso = transporteRegreso;
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
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public String getHoraRegreso() {
		return horaRegreso;
	}
	public void setHoraRegreso(String horaRegreso) {
		this.horaRegreso = horaRegreso;
	}
	
	@Override
	public String toString() {
		return "Viaje [id=" + id + ", destino=" + destino + ", salida=" + salida + ", transporte=" + transporte
				+ ", transporteRegreso=" + transporteRegreso + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
				+ ", presupuesto=" + presupuesto + ", descripcion=" + descripcion + ", horaSalida=" + horaSalida
				+ ", horaRegreso=" + horaRegreso + "]";
	}
	
	
	
	
	
}
