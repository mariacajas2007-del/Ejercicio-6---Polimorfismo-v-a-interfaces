package Vista;

import Controlador.ControladorIntegraciones;
import java.util.Scanner;
import Modelo.IntegracionAPI;
import java.util.Map;

public class MenuConsola {
    
    private final ControladorIntegraciones controlador;
    private Scanner scanner;

    public MenuConsola(ControladorIntegraciones controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println(" Menú de Integraciones");
            System.out.println("1. Listar integraciones");
            System.out.println("2. Buscar integración por ID");
            System.out.println("3. Ordenar por latencia");
            System.out.println("4. Probar una operación de integración");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    listarIntegraciones();
                    break;

                case 2:
                    buscarIntegracionPorId();
                    break;
                case 3: 

                    controlador.ordenarPorLatencia();
                    System.out.println("Integraciones ordenadas por latencia.");
                    listarIntegraciones();
                    break;
                case 4:
                    probarOperacionIntegracion();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);       
    }

    private void listarIntegraciones() { 
        for (IntegracionAPI integracion : controlador.listar()) {
            System.out.println(integracion);
        }
    }

    private void buscarIntegracionPorId() {
        System.out.print("Escribe el ID: ");
        String id = scanner.nextLine();

        IntegracionAPI integracion = controlador.buscar(id);

        if (integracion == null) {
            System.out.println("No se encontró ninguna integración con el ID proporcionado.");
            return;
        }

        System.out.println(integracion);
        System.out.println("Configuración");

        for (Map.Entry<String, String> dato : integracion.getConfiguracion().entrySet()) {
            System.out.println("- " + dato.getKey() + ": " + dato.getValue());
        }
    }

    private void probarOperacionIntegracion() {
        System.out.print("Escribe el ID: ");
        String id = scanner.nextLine();

        IntegracionAPI integracion = controlador.buscar(id);

        if (integracion == null) {
            System.out.println("No se encontró ninguna integración con el ID proporcionado.");
            return;
        }

        System.out.println("Elija la operación: ");
        System.out.println("1. Cobrar");
        System.out.println("2. Reintegrar");
        System.out.println("3. Generar Documento");
        System.out.println("4. Consultar Estado");
        System.out.print("Seleccione una opción: ");

        int opcion = leerEntero();

        switch (opcion) {
            case 1:
                System.out.print("Monto: Q");
                controlador.cobrar(id, leerDecimal());
                break;
            case 2:
                System.out.print("Monto: Q");
                controlador.reintegrar(id, leerDecimal());
                break;
            case 3:
                System.out.print("Referencia del documento: ");
                controlador.generarDocumento(id, scanner.nextLine());
                break;
            case 4:
                controlador.consultarEstado(id);
                break;
            default:
                System.out.println("Operación no válida."); 
            }
        }

        private int leerEntero() {
            while (true) {
                try {
                    return Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Entrada inválida. Intente nuevamente: ");
                }
            }
        }

        private double leerDecimal() {
            while (true) {
                try {
                    return Double.parseDouble(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Entrada inválida. Intente nuevamente: ");
                }
            }
        }
}
 
