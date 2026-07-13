package SuministroEmergencia;

public class SuministroEmergencia {
    private String idLote;
    private String nombreInsumo;
    private String descripcionUso;
    private double pesoKg;
    private boolean listoParaEnvio;
    private String tipoAyuda;

    public SuministroEmergencia() {
        this.idLote = "SIN-ID";
        this.nombreInsumo = "N/A";
        this.descripcionUso = "Sin descripción";
        this.pesoKg = 0.0;
        this.listoParaEnvio = false;
        this.tipoAyuda = "General";
    }
    
    public SuministroEmergencia(String idLote, String nombreInsumo, String descripcionUso, double pesoKg, boolean listoParaEnvio, String tipoAyuda) {
        this.idLote = idLote;
        this.nombreInsumo = nombreInsumo;
        this.descripcionUso = descripcionUso;
        this.pesoKg = pesoKg;
        this.listoParaEnvio = listoParaEnvio;
        this.tipoAyuda = tipoAyuda;
    }

    public String getIdLote() {
        return idLote;
    }

    public void setIdLote(String idLote) {
        this.idLote = idLote;
    }

    public String getNombreInsumo() {
        return nombreInsumo;
    }

    public void setNombreInsumo(String nombreInsumo) {
        this.nombreInsumo = nombreInsumo;
    }

    public String getDescripcionUso() {
        return descripcionUso;
    }

    public void setDescripcionUso(String descripcionUso) {
        this.descripcionUso = descripcionUso;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public boolean isListoParaEnvio() {
        return listoParaEnvio;
    }

    public void setListoParaEnvio(boolean listoParaEnvio) {
        this.listoParaEnvio = listoParaEnvio;
    }

    public String getTipoAyuda() {
        return tipoAyuda;
    }

    public void setTipoAyuda(String tipoAyuda) {
        this.tipoAyuda = tipoAyuda;
    }

    public void registrarLote(String id, String nombre, String desc, double peso, boolean listo, String tipo) {
        this.idLote = id;
        this.nombreInsumo = nombre;
        this.descripcionUso = desc;
        this.pesoKg = peso;
        this.listoParaEnvio = listo;
        this.tipoAyuda = tipo;
    }
    
    public String mostrarFichaLogistica(){
        return "ID: " + idLote +
           " | Insumo: " + nombreInsumo + 
           " | Descripcion: " + descripcionUso + 
           " | Peso: " + pesoKg + "kg" +
           " | Tipo: " + tipoAyuda + 
           " | Listo?: " + (listoParaEnvio ? "Si" : "No");
    }
    
    public void alternarEstadoEnvio(){
        this.listoParaEnvio = !this.listoParaEnvio;
    }   
}