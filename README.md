# Sistema de Gestión de Integraciones

## Descripción

Prototipo de consola desarrollado en Java para administrar integraciones con servicios externos de pagos, logística y certificación de Factura Electrónica en Línea (FEL).

Las operaciones de pago, generación de documentos y consulta de estados son simuladas. El programa no se conecta a servicios externos reales.

## Funcionalidades

- Carga diez integraciones de ejemplo al iniciar.
- Lista integraciones y muestra su estado de conexión.
- Busca una integración por ID y muestra su configuración.
- Ordena el catálogo por latencia promedio.
- Simula cobros y reintegros para pasarelas de pago.
- Simula la generación de documentos FEL.
- Consulta el estado y registra actividad.
- Ignora operaciones que una integración no admite sin detener el programa.

## Diseño

El catálogo guarda los distintos tipos de integración en una sola lista polimórfica de tipo `List<IntegracionAPI>`. La clase abstracta `IntegracionAPI` reúne los datos comunes y las clases concretas representan cada tipo de servicio.

El proyecto utiliza MVC:

- **Modelo:** datos, integraciones, interfaces, catálogo y operaciones.
- **Vista:** menú de consola.
- **Controlador:** conecta las opciones del menú con el modelo.

## Interfaces

- `Transaccional`: declara las operaciones de cobro y reintegro.
- `Documentable`: declara la generación de documentos.
- `Auditable`: declara la consulta del estado y el registro de actividad.

## Organización del proyecto

```text
src/
├── App.java
├── Controlador/
│   └── ControladorIntegraciones.java
├── Modelo/
│   ├── Auditable.java
│   ├── CargaInicial.java
│   ├── CatalogoIntegraciones.java
│   ├── CertificadorFEL.java
│   ├── Documentable.java
│   ├── IntegracionAPI.java
│   ├── PasarelaPago.java
│   ├── ProveedorLogistico.java
│   ├── ServicioOperaciones.java
│   └── Transaccional.java
└── Vista/
    └── MenuConsola.java
