package com.example.demo.DTO;

public class ClienteResponse {
	
	private String mensaje;
    private boolean exito;
	
    public ClienteResponse(String mensaje, boolean exito) {
        this.mensaje = mensaje;
        this.exito = exito;
    }
    public String getMensaje() { return mensaje; }
    public boolean isExito() { return exito; }	
}
