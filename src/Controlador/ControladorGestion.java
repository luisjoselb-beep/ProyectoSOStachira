package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorGestion {

    private SuministroEmergencia envioInmediato;
    private SuministroEmergencia pedidoEspecial;

    public void registrarLotes(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        
        // por defecto
        envioInmediato = new SuministroEmergencia();
        envioInmediato.registrarLote(id, nombre, desc, peso, listo, tipo);

        // parametrico
        pedidoEspecial = new SuministroEmergencia("MED003", "Kits Primeros Auxilios", "Vendas y alcohol", 5.2, true, "Medicina");

        // muestra en consola
        System.out.println("--- Registro Exitoso ---");
        System.out.println("Por Defecto: " + envioInmediato.mostrarFichaLogistica());
        System.out.println("Parametrico: " + pedidoEspecial.mostrarFichaLogistica());
    }

    //metodo obtenerInfoRegistros
    public String obtenerInfoRegistros() {
        if (envioInmediato == null || pedidoEspecial == null) {
            return "No hay lotes registrados o la memoria fue liberada.";
        }
        return "--- REGISTRO POR DEFECTO ---\n" + envioInmediato.mostrarFichaLogistica().replace("|", "\n") + "\n" + 
               "\n\n--- REGISTRO PARAMETRICO---\n" + pedidoEspecial.mostrarFichaLogistica().replace("|", "\n") + "\n";
    }
    
    //limpiar memoria
    public void limpiarMemoria() {
        envioInmediato = null;
        pedidoEspecial = null;
        System.out.println("--- MEMORIA LIBERADA: Objetos eliminados del Heap ---");
    }
}