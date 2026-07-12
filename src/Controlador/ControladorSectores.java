package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorSectores {

    private SuministroEmergencia[] sectorAlimentos = new SuministroEmergencia[3];

    // Este método solo se encarga de la gestión del arreglo
    public void registrarLoteEnSector(int i, String id, String nombre, String desc, double peso, boolean listo, String tipo) {
        // 1. Cumplimos la nota del PDF: Hacemos new antes de usar la posición
        sectorAlimentos[i] = new SuministroEmergencia(); 
        
        // 2. Reutilizamos el método que YA existe en la clase SuministroEmergencia
        sectorAlimentos[i].registrarLote(id, nombre, desc, peso, listo, tipo);
    }

    public String obtenerReporteCompleto() {
        String reporte = "--- REPORTES SECTOR ALIMENTOS ---\n";
        for (int i = 0; i < sectorAlimentos.length; i++) {
            if (sectorAlimentos[i] != null) {
                reporte += "LOTE #" + (i) + "\n";
        reporte += "----------------------------\n";
        reporte += "ID: " + sectorAlimentos[i].getIdLote() + "\n";
        reporte += "Nombre: " + sectorAlimentos[i].getNombreInsumo() + "\n";
        reporte += "Descripción: " + sectorAlimentos[i].getDescripcionUso() + "\n";
        reporte += "Peso: " + sectorAlimentos[i].getPesoKg() + " kg\n";
        reporte += "Tipo: " + sectorAlimentos[i].getTipoAyuda() + "\n";
        reporte += "Envío: " + (sectorAlimentos[i].isListoParaEnvio() ? "Sí" : "No") + "\n";
        reporte += "----------------------------\n\n";
            }
        }
        return reporte;
    }
    
    public int getCantidadFaltante() {
        // Calculamos cuántos espacios del arreglo son null
        int faltantes = 0;
        for (int i = 0; i < sectorAlimentos.length; i++) {
            if (sectorAlimentos[i] == null) {
                faltantes++;
            }
        }
        return faltantes;
    }
    
}