package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ClienteRequest;
import com.example.demo.model.request.AccountUpdate;

@Service
public class ClienteService {
	private static final Logger log = LoggerFactory.getLogger(ClienteService.class);
	
	private final Map<Integer,ClienteRequest> store = new ConcurrentHashMap<>();
	 private Map<String, Object> ultimaActualizacion;
	
	public void procesarCliente(ClienteRequest req) {
		log.info("Procesando cliente: {} (id={})", req.getNombre(), req.getId());
		//Double ingresos = req.getIngresos();
		if (req.getIngresos() != null && req.getIngresos() < 3000) {
			log.warn("Ingresos insualmente bajos para el id={}", req.getId());
		}
		store.put(req.getId(), req);
		log.debug("Guardado en memoria {}", req);
	}
	
	public void procesarLista(List<ClienteRequest> requests) {
		log.info("Procesando la lista de {} clientes", requests.size());
		requests.forEach(this::procesarCliente);
	}
	
	public List<ClienteRequest> listar() {
        return new ArrayList<>(store.values());
    }
	
	public Map<String, Object> updateAccount(AccountUpdate req) {
        log.info("Actualizando cuenta para customerId={}", req.getCustomerId());

        Integer idCliente;
        try {
            idCliente = Integer.parseInt(req.getCustomerId());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("customerId debe ser numérico y coincidir con el id del cliente");
        }

        ClienteRequest cliente = store.get(idCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("No se encontró cliente con id=" + idCliente);
        }

        log.info("Cliente encontrado: {}", cliente.getNombre());
        
        Map<String, Object> resp = new HashMap<>();
        resp.put("mensaje", "Cuenta actualizada correctamente");
        resp.put("cliente", cliente);
        resp.put("accountUpdate", req);
        ultimaActualizacion =resp;
        return resp;
    }
	 public Map<String, Object> getUltimaActualizacion() {
	        return ultimaActualizacion;
	    }

}
