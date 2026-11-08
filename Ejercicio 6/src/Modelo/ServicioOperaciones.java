package Modelo;

public class ServicioOperaciones {

    public void procesar(
            Transaccional integracion,
            double monto) {

        integracion.cobrar(monto);
    }

    public void reintegrar(
            Transaccional integracion,
            double monto) {

        integracion.reintegrar(monto);
    }

    public void procesar(
            Documentable integracion,
            String referencia) {

        integracion.generalDocumento(referencia);
    }

    public void procesar(
            Auditable integracion,
            String actividad) {

        System.out.println(
                "Estado: " + integracion.consultarEstado()
        );

        integracion.registrarActividad(actividad);
    }
}
