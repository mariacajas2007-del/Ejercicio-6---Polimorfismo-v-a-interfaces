package Controlador;

import Modelo.CatalogoIntegraciones;
import Modelo.ServicioOperaciones;
import Modelo.IntegracionAPI;
import Modelo.Transaccional;
import Modelo.Documentable;
import Modelo.Auditable;

public class ControladorIntegraciones {
    
    private final CatalogoIntegraciones catalogo;
    private final ServicioOperaciones servicio;

    public ControladorIntegraciones(CatalogoIntegraciones catalogo) {
        this.catalogo = catalogo;
        this.servicio = new ServicioOperaciones();
    }

    public Iterable<IntegracionAPI> listar() {
        return catalogo.getIntegraciones();
    }

    public IntegracionAPI buscar(String id) {
        return catalogo.buscarPorId(id);
    }

    public void ordenarPorLatencia() {
    catalogo.ordenarPorLatencia();
}

    public void cobrar(String id, double monto) {
        IntegracionAPI integracion = buscar(id);

        if (integracion instanceof Transaccional) {
            servicio.procesar((Transaccional) integracion, monto);
        } else {
            System.out.println("La integración no permite realizar cobros.");
        }
    }

    public void reintegrar(String id, double monto) {
        IntegracionAPI integracion = buscar(id);

        if (integracion instanceof Transaccional) {
            servicio.reintegrar((Transaccional) integracion, monto);
        } else {
            System.out.println("Petición ignorada: esta integración no permite" + "reintegros.");
        }
    }

    public void generarDocumento(String id, String referencia) {
        IntegracionAPI integracion = buscar(id);

        if (integracion instanceof Documentable) {
            servicio.procesar((Documentable) integracion, referencia);
        } else {
            System.out.println("La integración no permite generar documentos.");
        }
    }

    public void consultarEstado(String id) {
    IntegracionAPI integracion = buscar(id);

    if (integracion == null) {
        System.out.println("No se encontró la integración.");
    } else if (integracion instanceof Auditable) {
        servicio.procesar(
                (Auditable) integracion,
                "Consulta de estado de la integración " + id
        );
    } else {
        System.out.println(
                "La integración no permite consultar el estado."
        );
    }
} }

