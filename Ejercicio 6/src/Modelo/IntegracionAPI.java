package Modelo;

import java.util.Map;
import java.util.Objects;
import java.util.HashMap;
import java.util.Collections;

public abstract class IntegracionAPI implements Comparable<IntegracionAPI> {
    private final String id;
    private final String proveedor;
    private boolean conectada;
    private final double latenciaPromedio;
    private final Map<String, String> configuracion;

    public IntegracionAPI(String id, String proveedor, boolean conectada, double latenciaPromedio, Map<String, String> configuracion) {
        this.id = id;
        this.proveedor = proveedor;
        this.conectada = conectada;
        this.latenciaPromedio = latenciaPromedio;
        this.configuracion = new HashMap<>(configuracion);
    }

    public String getId() {
        return id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public boolean isConectada() {
        return conectada;
    }

    public double getLatenciaPromedio() {
        return latenciaPromedio;
    }

    public Map<String, String> getConfiguracion() {
        return Collections.unmodifiableMap(configuracion);
    }

    public abstract String getTipo();

    @Override
    public int compareTo(IntegracionAPI otra) {
        return Double.compare(this.latenciaPromedio, otra.latenciaPromedio);
    }

    @Override
    public String toString() {
        return "IntegracionAPI{" +
                "id='" + id + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", conectada=" + conectada +
                ", latenciaPromedio=" + latenciaPromedio +
                ", configuracion=" + configuracion +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) 
            return true;
        if (object == null || getClass() != object.getClass())
             return false;

        IntegracionAPI otra = (IntegracionAPI) object;
        return Objects.equals(id, otra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }    
}
