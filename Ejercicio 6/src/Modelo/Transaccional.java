package Modelo;

public interface Transaccional {
    void cobrar(double monto);
    void reintegrar(double monto);
}
