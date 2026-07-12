package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorSuministros {
    private SuministroEmergencia reservaInicial;
    private SuministroEmergencia lotePrioritario;
    private SuministroEmergencia donacionReciente;

    public ControladorSuministros() {
        // Inicialización de los objetos que pide la parte A
        reservaInicial = new SuministroEmergencia(); // Constructor por defecto
        lotePrioritario = new SuministroEmergencia("PRI-001", "Primeros Auxilios", "Vendas", 2.5, true, "Medicina");
    }

    public void registrarDonacion(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        donacionReciente = new SuministroEmergencia();
        donacionReciente.registrarLote(id, nombre, desc, peso, listo, tipo);
        System.out.println("[LOG] Donación registrada en el sistema: " + id);
    }

    public void alternarPrioritario() {
        if (lotePrioritario != null) {
            lotePrioritario.alternarEstadoEnvio();
            System.out.println("[LOG] Se ha alternado el estado del Lote Prioritario.");
        }
    }

    public String obtenerResumen() {
        return "--- RESERVA INICIAL (Default) ---\n" + reservaInicial.mostrarFichaLogistica().replace("|", "\n") + "\n" +
               "\n\n--- LOTE PRIORITARIO (Paramétrico) ---\n" + lotePrioritario.mostrarFichaLogistica().replace("|", "\n") + "\n" +
               "\n\n--- DONACIÓN RECIENTE (Registro del usuario) ---\n" + 
               (donacionReciente != null ? donacionReciente.mostrarFichaLogistica().replace("|", "\n"): "Aún no hay una donación registrada.");
    }
}
