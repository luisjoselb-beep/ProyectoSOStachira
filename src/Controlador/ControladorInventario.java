package Controlador;

import SuministroEmergencia.SuministroEmergencia;

public class ControladorInventario {
    private SuministroEmergencia[] inventario;
    private int contador = 0; // Para saber qué posición sigue

    public void inicializarInventario(int tamaño) {
        inventario = new SuministroEmergencia[tamaño];
        contador = 0;
    }

    public boolean registrarLote(String id, String nombre, String desc, double peso, String tipo, boolean listo) {
        if (contador < inventario.length) {
            inventario[contador] = new SuministroEmergencia();
            inventario[contador].registrarLote(id, nombre, desc, peso, listo, tipo);
            contador++;
            return true; // Registro exitoso
        }
        return false; // Inventario lleno
    }

    // AQUÍ USAS EL FOR PARA LISTAR (Como pediste)
    public String obtenerListadoCompleto() {
        String reporte = "--- INVENTARIO GENERAL ---\n";
        for (int i = 0; i < contador; i++) { // Solo recorres lo que realmente se ha llenado
            reporte += "LOTE #" + (i) + "\n";
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
    // Aquí es donde el controlador usa el índice para encontrar el objeto correcto
    inventario[indice].alternarEstadoEnvio(); 
}
}
