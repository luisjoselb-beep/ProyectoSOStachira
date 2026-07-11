package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorGestion {

    private SuministroEmergencia envioInmediato;
    private SuministroEmergencia pedidoEspecial;

    public void registrarLotes(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        
        // 1. OBJETO POR DEFECTO:
        // Se construye vacío y se llena con los datos dinámicos que el usuario escribe en la interfaz.
        envioInmediato = new SuministroEmergencia();
        envioInmediato.setIdLote(id);
        envioInmediato.setNombreInsumo(nombre);
        envioInmediato.setDescripcionUso(desc);
        envioInmediato.setPesoKg(peso);
        envioInmediato.setTipoAyuda(tipo);
        envioInmediato.setListoParaEnvio(listo);

        // 2. OBJETO PARAMÉTRICO:
        // Se construye usando el constructor paramétrico con los DATOS FIJOS de la práctica (Parte B).
        pedidoEspecial = new SuministroEmergencia("MED003", "Kits Primeros Auxilios", "Vendas y alcohol", 5.2, true, "Medicina");

        // Consola: Verificación del registro
        System.out.println("--- REGISTRO EXITOSO ---");
        System.out.println("Por Defecto (Dinámico): " + envioInmediato.mostrarFichaLogistica());
        System.out.println("Paramétrico (Fijo/Práctica): " + pedidoEspecial.mostrarFichaLogistica());
    }

    public String obtenerInfoRegistros() {
        if (envioInmediato == null || pedidoEspecial == null) {
            return "No hay lotes registrados o la memoria fue liberada.";
        }
        return "--- REGISTRO POR DEFECTO (Dinámico) ---\n" + envioInmediato.mostrarFichaLogistica() + 
               "\n\n--- REGISTRO PARAMÉTRICO (Fijo Parte B) ---\n" + pedidoEspecial.mostrarFichaLogistica();
    }

    public void limpiarMemoria() {
        // Al asignar null, eliminamos la referencia en el Stack.
        // Esto permite que el Garbage Collector libere el espacio en el Heap.
        envioInmediato = null;
        pedidoEspecial = null;
        
        System.out.println("--- MEMORIA LIBERADA: Objetos eliminados del Heap ---");
    }
}