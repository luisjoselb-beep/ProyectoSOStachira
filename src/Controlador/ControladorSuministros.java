package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorSuministros {
    private SuministroEmergencia reservaInicial;
    private SuministroEmergencia lotePrioritario;
    private SuministroEmergencia donacionReciente;

    public ControladorSuministros() {
        reservaInicial = new SuministroEmergencia();
        lotePrioritario = new SuministroEmergencia("MED003", "Kits Primeros Auxilios", "Vendas y alcohol", 5.2, true, "Medicina");
    }

    public void registrarDonacion(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        donacionReciente = new SuministroEmergencia();
        donacionReciente.registrarLote(id, nombre, desc, peso, listo, tipo);
        System.out.println("[AVISO] Donación registrada en el sistema: " + id);
    }

    public void alternarPrioritario() {
        if (lotePrioritario != null) {
            lotePrioritario.alternarEstadoEnvio();
            System.out.println("[AVISO] Se ha alternado el estado del Lote Prioritario.");
        }
    }

    public String obtenerResumen() {
        return "--- RESERVA INICIAL (Por Defecto) ---\n" + reservaInicial.mostrarFichaLogistica().replace("|", "\n") + "\n" +
               "\n\n--- LOTE PRIORITARIO (Paramétrico) ---\n" + lotePrioritario.mostrarFichaLogistica().replace("|", "\n") + "\n" +
               "\n\n--- DONACIÓN RECIENTE (Registro del usuario) ---\n" + 
               (donacionReciente != null ? donacionReciente.mostrarFichaLogistica().replace("|", "\n"): "Aún no hay una donación registrada.");
    }
}
