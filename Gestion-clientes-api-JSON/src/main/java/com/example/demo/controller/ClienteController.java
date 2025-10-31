package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ClienteRequest;
import com.example.demo.model.request.AccountUpdate;
import com.example.demo.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
    private ClienteService service; 

	@GetMapping(value="/todos", produces="application/json")
	public List<ClienteRequest> todos(){
		return service.listar();
	}
	
	@GetMapping(value = "/ultimaActualizacion", produces = "application/json")
	public Map<String, Object> obtenerUltimaActualizacion() {
	    Map<String, Object> ultima = service.getUltimaActualizacion();
	    return ultima;
	}
	
	@PostMapping(value = "/registrar", consumes = "application/json", produces = "application/json")
    public Map<String, Object> registrarLista(@Valid @RequestBody List<@Valid ClienteRequest> requests) {
        service.procesarLista(requests);
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", "Se recibieron " + requests.size() + " clientes correctamente");
        resp.put("clientes", requests);
        return resp;
	}
	
	
	@PostMapping(value = "/account/update", consumes = "application/json", produces = "application/json")
	public List<Map<String, Object>> updateAccount1(@Valid @RequestBody List<@Valid AccountUpdate> requests) {
	    return requests.stream()
	            .map(service::updateAccount)
	            .toList();
	}


}