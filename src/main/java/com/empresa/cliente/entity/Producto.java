package com.empresa.cliente.entity;

public class Producto {
	private int id;
	private String nombres;
	private double precio;
	private int stock;
	private String estado;

	public Producto() {

	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombres=" + nombres + ", precio=" + precio + ", stock=" + stock + ", estado="
				+ estado + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
