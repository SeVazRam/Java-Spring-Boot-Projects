package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ClienteRequest {
	@NotBlank(message="El nombre es obligatorio")
	private String nombre;
	@NotNull(message="El id es obligatorio")
	private Integer id;
	@NotBlank(message="El numCuenta es obligatorio")
	private String numeroCuenta;
	@PositiveOrZero(message="Los ingresos deben ser >= 0")
	private Double ingresos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNumeroCuenta() { return numeroCuenta; }
    public void setNumeroCuenta(String numeroCuenta) { this.numeroCuenta = numeroCuenta; }
	
	public Double getIngresos() {
		return ingresos;
	}
	public void setIngresos(Double ingresos) {
		this.ingresos = ingresos;
	}

}
