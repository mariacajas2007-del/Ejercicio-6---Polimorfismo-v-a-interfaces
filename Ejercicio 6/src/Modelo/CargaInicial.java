package Modelo;

import java.util.HashMap;
import java.util.Map;

public class CargaInicial {

    public static void cargar(CatalogoIntegraciones catalogo) {
        
        catalogo.agregar(new PasarelaPago(
                "P001", "PagoTarjetaGT", true, 120,
                crearConfiguracion("Pruebas", "GTQ")));

        catalogo.agregar(new PasarelaPago(
                "P002", "TransferenciaBanco", true, 180,
                crearConfiguracion("Pruebas", "GTQ")));

        catalogo.agregar(new PasarelaPago(
                "P003", "BilleteraDigital", true, 95,
                crearConfiguracion("Pruebas", "GTQ")));

        catalogo.agregar(new PasarelaPago(
                "P004", "PagoExpress", false, 240,
                crearConfiguracion("Pruebas", "GTQ")));

        catalogo.agregar(new PasarelaPago(
                "P005", "CardLink", true, 150,
                crearConfiguracion("Pruebas", "GTQ")));

        catalogo.agregar(new ProveedorLogistico(
                "L001", "CargoExpreso", true, 300,
                crearConfiguracion("Pruebas", "Guatemala")));

        catalogo.agregar(new ProveedorLogistico(
                "L002", "Guatex", true, 270,
                crearConfiguracion("Pruebas", "Guatemala")));

        catalogo.agregar(new ProveedorLogistico(
                "L003", "Forza", false, 350,
                crearConfiguracion("Pruebas", "Guatemala")));

        catalogo.agregar(new CertificadorFEL(
                "F001", "CertificadorFEL Uno", true, 210,
                crearConfiguracion("Pruebas", "GTQ")));

        catalogo.agregar(new CertificadorFEL(
                "F002", "CertificadorFEL Dos", true, 190,
                crearConfiguracion("Pruebas", "GTQ")));
    }

    private static Map<String, String> crearConfiguracion(String ambiente, String region) {
        Map<String, String> configuracion = new HashMap<>();
        configuracion.put("ambiente", ambiente);
        configuracion.put("region", region);
        configuracion.put("autenticacion", "Token de prueba");

        return configuracion;
    }
}
