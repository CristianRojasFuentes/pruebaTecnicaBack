package cl.prueba.tecnica.musica.encuesta.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String mensaje;
	private String detalle;
	
	public ErrorDetails(Date timestamp, String mensaje, String detalle) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDetalle() {
		return detalle;
	}
	
	
	
}
