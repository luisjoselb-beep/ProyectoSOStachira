package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorSectores {

    private SuministroEmergencia[] sectorAlimentos = new SuministroEmergencia[3];

    // gestion del arreglo
    public void registrarLoteEnSector(int i, String id, String nombre, String desc, double peso, boolean listo, String tipo) {
        // New (arreglo)
        sectorAlimentos[i] = new SuministroEmergencia(); 
        
        // met. SuministroEmergencia
        sectorAlimentos[i].registrarLote(id, nombre, desc, peso, listo, tipo);
    }
    //reportes
    public String obtenerReporteCompleto() {
        String reporte = "--- REPORTES SECTOR ALIMENTOS ---\n";
        for (int i = 0; i < sectorAlimentos.length; i++) {
            if (sectorAlimentos[i] != null) {
                reporte += "LOTE #" + (i+1) + "\n";
        reporte += "----------------------------\n";
        reporte += "ID: " + sectorAlimentos[i].getIdLote() + "\n";
        reporte += "Nombre: " + sectorAlimentos[i].getNombreInsumo() + "\n";
        reporte += "Descripcion: " + sectorAlimentos[i].getDescripcionUso() + "\n";
        reporte += "Peso: " + sectorAlimentos[i].getPesoKg() + " kg\n";
        reporte += "Tipo: " + sectorAlimentos[i].getTipoAyuda() + "\n";
        reporte += "Envio: " + (sectorAlimentos[i].isListoParaEnvio() ? "Sí" : "No") + "\n";
        reporte += "----------------------------\n\n";
            }
        }
        return reporte;
    }
    //para calcular los Null
    public int getCantidadFaltante() {
        
        int faltantes = 0;
        for (int i = 0; i < sectorAlimentos.length; i++) {
            if (sectorAlimentos[i] == null) {
                faltantes++;
            }
        }
        return faltantes;
    }
    
}