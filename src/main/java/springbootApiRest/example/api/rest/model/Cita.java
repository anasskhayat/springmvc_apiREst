package springbootApiRest.example.api.rest.model;

import java.util.Date;

public class Cita {
	
	private Long id;
	private String texto;
	private Date fecha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cita(Long id, String texto, Date fecha) {
		super();
		this.id = id;
		this.texto = texto;
		this.fecha = fecha;
	}
	
	public Cita() {}  
}
