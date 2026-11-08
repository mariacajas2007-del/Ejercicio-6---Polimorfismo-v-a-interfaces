package Modelo;

import java.util.Map;
public class CertificadorFEL extends IntegracionAPI implements Documentable, Auditable {
    
    public CertificadorFEL(String id, String proveedor, boolean conectada, double latenciaPromedio, Map<String, String> configuracion) {
        super(id, proveedor, conectada, latenciaPromedio, configuracion);
    }

    @Override
    public String getTipo() {
        return "Certificación FEL";
    }

    @Override
    public void generalDocumento(String referencia) {
        System.out.println("Documento FEL simulado pra la referencia" + referencia + "generado por" + getProveedor() + ".");
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
