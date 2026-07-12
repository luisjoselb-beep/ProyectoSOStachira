package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorGestion {

    private SuministroEmergencia envioInmediato;
    private SuministroEmergencia pedidoEspecial;

    public void registrarLotes(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        
        // 1. OBJETO POR DEFECTO:
        // Ahora usamos el método que creamos en el modelo en lugar de 6 setters.
        envioInmediato = new SuministroEmergencia();
        envioInmediato.registrarLote(id, nombre, desc, peso, listo, tipo);

        // 2. OBJETO PARAMÉTRICO:
        // Este se mantiene igual, ya que usa el constructor paramétrico.
        pedidoEspecial = new SuministroEmergencia("MED003", "Kits Primeros Auxilios", "Vendas y alcohol", 5.2, true, "Medicina");

        // Consola: Verificación del registro
        System.out.println("--- Registro Exitoso ---");
        System.out.println("Por Defecto: " + envioInmediato.mostrarFichaLogistica());
        System.out.println("Paramétrico: " + pedidoEspecial.mostrarFichaLogistica());
    }

    // El resto de tus métodos (obtenerInfoRegistros y limpiarMemoria) 
    // se quedan exactamente igual, ya que no dependen de cómo se asignaron los datos.
    public String obtenerInfoRegistros() {
        if (envioInmediato == null || pedidoEspecial == null) {
            return "No hay lotes registrados o la memoria fue liberada.";
        }
        return "--- REGISTRO POR DEFECTO (Dinámico) ---\n" + envioInmediato.mostrarFichaLogistica().replace("|", "\n") + "\n" + 
               "\n\n--- REGISTRO PARAMÉTRICO (Fijo Parte B) ---\n" + pedidoEspecial.mostrarFichaLogistica().replace("|", "\n") + "\n";
    }

    public void limpiarMemoria() {
        envioInmediato = null;
        pedidoEspecial = null;
        System.out.println("--- MEMORIA LIBERADA: Objetos eliminados del Heap ---");
    }
}