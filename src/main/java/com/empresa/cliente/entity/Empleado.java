package com.empresa.cliente.entity;

public class Empleado {
	
	private int id;
	private String dni;
	private String nombres;
	private String telefono;
	private String estado;
	private String user;
	
	public Empleado() {

	}

	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dni=" + dni + ", nombres=" + nombres + ", telefono=" + telefono + ", estado="
				+ estado + ", user=" + user + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
