package SuministroEmergencia;

public class SuministroEmergencia {
    private String idLote;
    private String nombreInsumo;
    private String descripcionUso;
    private double pesoKg;
    private boolean listoParaEnvio;
    private String tipoAyuda;

    public SuministroEmergencia(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoAyuda) {
        this.idLote = idLote;
        this.nombreInsumo = nombreInsumo;
        this.descripcionUso = descripcionUso;
        this.pesoKg = pesoKg;
        this.listoParaEnvio = listoParaEnvio;
        this.tipoAyuda = tipoAyuda;
    }
    
    public void registrarLote(){
        
    }
    
    public void mostrarFichaLogistica(){
        
    }
    
    public void alternarEstadoEnvio(){
    
    }    
}
