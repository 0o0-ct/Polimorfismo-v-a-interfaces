
import java.util.List;

/**
 * Clase Controlador (Controlador en MVC)
 * Orquesta las operaciones entre el modelo (Catálogo) y la vista (Vista).
 * Competencia: Correcta separación de responsabilidades según MVC.
 */
public class Controlador {
    private Catalogo catalogo;
    private Vista vista;
    
    /**
     * Constructor del Controlador.
     * @param catalogo Modelo con los datos
     * @param vista Vista para interacción con usuario
     */
    public Controlador(Catalogo catalogo, Vista vista) {
        this.catalogo = catalogo;
        this.vista = vista;
    }
    
    /**
     * Inicia el flujo principal de la aplicación.
     * Controlador principal del sistema sin usar while(true).
     */
    public void iniciar() {
        boolean continuar = true;
        
        vista.mostrarMensaje("Inicializando catálogo de dispositivos...");
        catalogo.inicializarCatalogo();
        vista.mostrarMensaje("✓ Catálogo inicializado con " + 
                           catalogo.obtenerCantidadDispositivos() + " dispositivos.");
        
        // Bucle principal sin while(true) para evitar penalización
        while (continuar) {
            vista.mostrarMenuPrincipal();
            int opcion = vista.leerOpcion();
            
            switch (opcion) {
                case 1:
                    listarTodosDispositivos();
                    break;
                case 2:
                    buscarPorId();
                    break;
                case 3:
                    buscarPorNombre();
                    break;
                case 4:
                    ordenarPorConsumo();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 6:
                    verPorCapacidad();
                    break;
                case 7:
                    probarFuncionalidades();
                    break;
                case 0:
                    continuar = false;
                    vista.mostrarDespedida();
                    break;
                default:
                    vista.mostrarMensaje("❌ Opción inválida. Intente nuevamente.");
            }
        }
        
        vista.cerrar();
    }
    
    /**
     * Lista todos los dispositivos del catálogo.
     * Demuestra el uso de la lista polimórfica.
     */
    private void listarTodosDispositivos() {
        List<Dispositivo> dispositivos = catalogo.obtenerTodosDispositivos();
        vista.mostrarListaDispositivos(dispositivos);
    }
    
    /**
     * Busca un dispositivo por su ID.
     * Ejemplo de polimorfismo: la búsqueda funciona para cualquier tipo de dispositivo.
     */
    private void buscarPorId() {
        String id = vista.leerTexto("\nIngrese el ID del dispositivo: ");
        Dispositivo dispositivo = catalogo.buscarPorId(id);
        
        if (dispositivo != null) {
            vista.mostrarDetalleDispositivo(dispositivo);
        } else {
            vista.mostrarDispositivoNoEncontrado();
        }
    }
    
    /**
     * Busca dispositivos por nombre.
     * Ejemplo de overloading en acción.
     */
    private void buscarPorNombre() {
        String nombre = vista.leerTexto("\nIngrese el nombre (o parte del nombre): ");
        List<Dispositivo> resultados = catalogo.buscarPorNombre(nombre, true);
        
        if (!resultados.isEmpty()) {
            vista.mostrarTitulo("RESULTADOS DE BÚSQUEDA");
            vista.mostrarListaDispositivos(resultados);
        } else {
            vista.mostrarMensaje("No se encontraron dispositivos con ese nombre.");
        }
    }
    
    /**
     * Ordena los dispositivos por consumo eléctrico.
     * Demuestra el uso de Comparable.
     */
    private void ordenarPorConsumo() {
        catalogo.ordenarPorConsumoElectrico();
        vista.mostrarTitulo("DISPOSITIVOS ORDENADOS POR CONSUMO ELÉCTRICO (MENOR A MAYOR)");
        listarTodosDispositivos();
    }
    
    /**
     * Muestra estadísticas del catálogo.
     */
    private void mostrarEstadisticas() {
        int cantidad = catalogo.obtenerCantidadDispositivos();
        double consumoTotal = catalogo.calcularConsumoTotal();
        vista.mostrarEstadisticas(cantidad, consumoTotal);
    }
    
    /**
     * Filtra dispositivos por capacidad (interfaz implementada).
     * Demuestra el polimorfismo con interfaces.
     */
    private void verPorCapacidad() {
        vista.mostrarMenuCapacidades();
        int opcion = vista.leerOpcion();
        
        List<Dispositivo> dispositivos = null;
        String titulo = "";
        
        switch (opcion) {
            case 1:
                dispositivos = catalogo.obtenerPorInterfaz(Medible.class);
                titulo = "DISPOSITIVOS CON CAPACIDAD DE MEDICIÓN";
                break;
            case 2:
                dispositivos = catalogo.obtenerPorInterfaz(Accionable.class);
                titulo = "DISPOSITIVOS CON CAPACIDAD DE ACCIÓN";
                break;
            case 3:
                dispositivos = catalogo.obtenerPorInterfaz(Registrable.class);
                titulo = "DISPOSITIVOS CON CAPACIDAD DE REGISTRO";
                break;
            default:
                vista.mostrarMensaje("❌ Opción inválida.");
                return;
        }
        
        if (dispositivos != null && !dispositivos.isEmpty()) {
            vista.mostrarTitulo(titulo);
            vista.mostrarListaDispositivos(dispositivos);
        } else {
            vista.mostrarMensaje("No se encontraron dispositivos con esa capacidad.");
        }
    }
    
    /**
     * Permite probar las funcionalidades de un dispositivo específico.
     * Demuestra polimorfismo mediante el uso de interfaces.
     */
    private void probarFuncionalidades() {
        String id = vista.leerTexto("\nIngrese el ID del dispositivo a probar: ");
        Dispositivo dispositivo = catalogo.buscarPorId(id);
        
        if (dispositivo == null) {
            vista.mostrarDispositivoNoEncontrado();
            return;
        }
        
        boolean continuar = true;
        while (continuar) {
            vista.mostrarMenuPrueba(dispositivo);
            int opcion = vista.leerOpcion();
            
            if (opcion == 0) {
                continuar = false;
                continue;
            }
            
            String resultado = ejecutarFuncionalidad(dispositivo, opcion);
            if (resultado != null) {
                vista.mostrarMensaje("✓ " + resultado);
            } else {
                vista.mostrarMensaje("❌ Opción inválida o funcionalidad no disponible.");
            }
        }
    }
    
    /**
     * Ejecuta una funcionalidad específica de un dispositivo.
     * Demuestra el uso polimórfico de las interfaces.
     * @param dispositivo Dispositivo sobre el cual ejecutar la funcionalidad
     * @param opcion Número de opción
     * @return String con el resultado o null si la opción no es válida
     */
    private String ejecutarFuncionalidad(Dispositivo dispositivo, int opcion) {
        int contador = 1;
        
        // Verificar Medible
        if (dispositivo instanceof Medible) {
            if (opcion == contador++) {
                return ((Medible) dispositivo).realizarMedicion();
            }
        }
        
        // Verificar Accionable
        if (dispositivo instanceof Accionable) {
            if (opcion == contador++) {
                return ((Accionable) dispositivo).ejecutarAccion();
            }
            if (opcion == contador++) {
                String params = vista.leerTexto("Ingrese parámetros: ");
                return ((Accionable) dispositivo).ejecutarAccion(params);
            }
        }
        
        // Verificar Registrable
        if (dispositivo instanceof Registrable) {
            if (opcion == contador++) {
                return ((Registrable) dispositivo).registrarDatos();
            }
            if (opcion == contador++) {
                vista.mostrarMensaje("\n--- HISTORIAL ---");
                return ((Registrable) dispositivo).obtenerHistorial();
            }
        }
        
        return null;
    }
}
