package Modelo;

import java.util.Map;
public class PasarelaPago extends IntegracionAPI implements Transaccional, Auditable {
    
    public PasarelaPago(String id, String proveedor, boolean conectada, double latenciaPromedio, Map<String, String> configuracion) {
        super(id, proveedor, conectada, latenciaPromedio, configuracion);
    }

    @Override 
    public String getTipo() {
        return "Pasarela de Pago";
    }

    @Override 
    public void cobrar(double monto) {
       if (monto <= 0) {
        System.out.println("El monto debe ser mayor que cero");
        return;
       }
       
       System.out.println("Cobro simulado de Q" + monto + " procesado por " + getProveedor());
    }

    @Override 
    public void reintegrar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor que cero");
            return;
        }

        System.out.println("Reintegro simulado de Q" + monto +  " procesado por " + getProveedor());
    }

    @Override 
    public String consultarEstado() {
        return isConectada() ? "Conectada" : "Desconectada";
    }

    @Override 
    public void registrarActividad(String actividad) {
        System.out.println("Actividad registrada en" + getProveedor() + ": " + actividad);
    }   
}
