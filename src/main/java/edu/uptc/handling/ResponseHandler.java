package edu.uptc.handling;

import java.util.HashMap;
import java.util.Map; // Corrige para usar la interfaz Map

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObject) {
        Map<String, Object> map = new HashMap<>(); // Usa la interfaz Map

        map.put("message", message);
        map.put("status", status.value()); // Usa el valor numérico del estado
        map.put("data", responseObject);

        return new ResponseEntity<>(map, status); // Asegúrate de cerrar con punto y coma
    }
}

