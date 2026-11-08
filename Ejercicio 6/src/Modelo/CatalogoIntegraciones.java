package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoIntegraciones {

    private final List<IntegracionAPI> integraciones =
            new ArrayList<>();

    public void agregar(IntegracionAPI integracion) {
        if (buscarPorId(integracion.getId()) != null) {
            System.out.println("Ya existe una integración con ese ID.");
            return;
        }

        // Se agrega una sola vez.
        integraciones.add(integracion);
    }

    public List<IntegracionAPI> getIntegraciones() {
        return Collections.unmodifiableList(integraciones);
    }

    public IntegracionAPI buscarPorId(String id) {
        for (IntegracionAPI integracion : integraciones) {
            if (integracion.getId().equals(id)) {
                return integracion;
            }
        }

        return null;
    }

    public void ordenarPorLatencia() {
        Collections.sort(integraciones);
    }
}
