package Modelo;

import java.util.Map;
public class ProveedorLogistico extends IntegracionAPI implements Auditable {
    
    public ProveedorLogistico(String id, String proveedor, boolean conectada, double latenciaPromedio, Map<String, String> configuracion) {
        super(id, proveedor, conectada, latenciaPromedio, configuracion);
    }

    @Override 
    public String getTipo() {
        return "Proveedor Logístico";
    }

    @Override 
    public String consultarEstado() {
        return isConectada() ? "Conectada" : "Desconectada";
    }

    @Override 
    public void registrarActividad(String actividad) {
        System.out.println("Actividad registrada en " + getProveedor() + ": " + actividad);
    }
}
