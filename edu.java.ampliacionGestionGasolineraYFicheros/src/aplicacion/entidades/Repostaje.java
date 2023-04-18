package aplicacion.entidades;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Repostaje {
	// CLASE REPOSTAJE
	
	// Atributos
	
	private int id; // Identificador
	private LocalDate fecha;
	private float litros;
	private float importe;
	private String dni;
	private String matricula;
	private boolean esFactura; // Boolean para diferenciar entre Normal y Factura
	
	// Constructores
	
		// Constructor 1: Sin ningún atributo
	public Repostaje() {
		super();
	}

		// Constructor 2: Con todos los atributos/propiedades /// ESTE NO SE VA A UTILIZAR, PERO LO PONGO PARA RECORDAR
	public Repostaje(int id, LocalDate fecha, float litros, float importe, String dni, String matricula) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.litros = litros;
		this.importe = importe;
		this.dni = dni;
		this.matricula = matricula;
	}
	
	// Getters And Setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public float getLitros() {
		return litros;
	}

	public void setLitros(float litros) {
		this.litros = litros;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public boolean getEsFactura() {
		return esFactura;
	}
	
	public void setEsFactura(boolean esFactura) {
		this.esFactura = esFactura;
	}

	// Método toString
	
	@Override
	public String toString() {
		return "Repostaje [id=" + id + ", fecha=" + fecha + ", litros=" + litros + ", importe=" + importe + ", dni=" + dni
				+ ", matricula=" + matricula + "]";
	}
	
	// Métodos -> En la implementacion

}
