package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalculadoraController {

    // Lista para guardar historial
    private final List<String> historial = new ArrayList<>();

    @GetMapping("/calcular") // Página principal
    public String formulario(Model model) {
        model.addAttribute("historial", historial);
        return "formulario"; // templates/formulario.html
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam BigDecimal num1,
                           @RequestParam BigDecimal num2,
                           @RequestParam String operacion,
                           Model model) {

        BigDecimal resultado;
        String textoOperacion;

        switch (operacion) {
            case "suma":
                resultado = num1.add(num2);
                textoOperacion = num1 + " + " + num2 + " = " + resultado;
                break;
            case "resta":
                resultado = num1.subtract(num2);
                textoOperacion = num1 + " - " + num2 + " = " + resultado;
                break;
            case "multiplicacion":
                resultado = num1.multiply(num2);
                textoOperacion = num1 + " × " + num2 + " = " + resultado;
                break;
            case "division":
                if (num2.compareTo(BigDecimal.ZERO) == 0) {
                    model.addAttribute("error", "No se puede dividir entre cero");
                    return "resultado";
                }
                resultado = num1.divide(num2, 2, BigDecimal.ROUND_HALF_UP);
                textoOperacion = num1 + " ÷ " + num2 + " = " + resultado;
                break;
            default:
                resultado = BigDecimal.ZERO;
                textoOperacion = "Operación desconocida";
        }

        // Agregamos al historial
        historial.add(textoOperacion);

        // Pasamos valores a la vista
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("operacion", operacion);
        model.addAttribute("resultado", resultado);
        model.addAttribute("historial", historial);

        return "resultado"; // templates/resultado.html
    }
    
    @PostMapping("/limpiar-historial")
    public String limpiarHistorial() {
        historial.clear(); // limpia la lista
        return "redirect:/calcular"; // vuelve al formulario
    }
}
