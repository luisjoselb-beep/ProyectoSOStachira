package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorInventario {
    private SuministroEmergencia[] inventario;
    private int contador = 0;

    public void inicializarInventario(int tamaño) {
        inventario = new SuministroEmergencia[tamaño];
        contador = 0;
    }

    public boolean registrarLote(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        if (contador < inventario.length) {
            inventario[contador] = new SuministroEmergencia();
            inventario[contador].registrarLote(id, nombre, desc, peso, listo, tipo);
            contador++;
            return true;
        }
        return false;
    }

    public String obtenerListadoCompleto() {
        System.out.println("AVISO: Generando reporte completo de " + contador + " lotes.");
        String reporte = "--- INVENTARIO GENERAL ---\n";
        for (int i = 0; i < contador; i++) {
            reporte += "LOTE #" + (i+1) + "\n";
        reporte += "----------------------------\n";
        reporte += "ID: " + inventario[i].getIdLote() + "\n";
        reporte += "Nombre: " + inventario[i].getNombreInsumo() + "\n";
        reporte += "Descripción: " + inventario[i].getDescripcionUso() + "\n";
        reporte += "Peso: " + inventario[i].getPesoKg() + " kg\n";
        reporte += "Tipo: " + inventario[i].getTipoAyuda() + "\n";
        reporte += "Envío: " + (inventario[i].isListoParaEnvio() ? "Sí" : "No") + "\n";
        reporte += "----------------------------\n\n";
        }
        return reporte;
    }
    
    public boolean estaLleno() {
    return contador >= inventario.length;
    }
    
    public int getContador() { 
        return this.contador;
    }
    
    public void alternarLote(int indice) {
        
    if (indice >= 0 && indice < contador) {
    inventario[indice].alternarEstadoEnvio(); 
    System.out.println("AVISO: Estado del lote en el indice " + indice + " ha sido cambiado.");
    } else {
        System.err.println("ERROR: Intento de modificar indice fuera de rango: " + indice);
    }
    }
}
