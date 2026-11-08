package Modelo;

public interface Auditable {
    String consultarEstado();
    void registrarActividad(String actividad);
}
