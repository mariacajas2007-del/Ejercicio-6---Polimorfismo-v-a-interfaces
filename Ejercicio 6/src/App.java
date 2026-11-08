import Modelo.CargaInicial;
import Modelo.CatalogoIntegraciones;
import Controlador.ControladorIntegraciones;
import Vista.MenuConsola;

public class App {
    public static void main(String[] args) throws Exception {
        CatalogoIntegraciones catalogo = new CatalogoIntegraciones();
        CargaInicial.cargar(catalogo);
        ControladorIntegraciones controlador = new ControladorIntegraciones(catalogo);
        MenuConsola menu = new MenuConsola(controlador);
        menu.iniciar();
    }
}
