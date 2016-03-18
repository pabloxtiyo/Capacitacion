package com.pportillo.localiza.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Persona")
public class Persona implements java.io.Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    @ManyToOne @JoinColumn(name="fk_telefono")
    private Telefono telefono;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	    


}
