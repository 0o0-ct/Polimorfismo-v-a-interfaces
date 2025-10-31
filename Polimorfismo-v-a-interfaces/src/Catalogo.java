
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase Catalogo (Modelo en MVC)
 * Maneja la colección polimórfica de dispositivos.
 * Competencia: Uso correcto de una sola estructura polimórfica.
 */
public class Catalogo {
    // Lista polimórfica única que almacena todos los dispositivos
    private List<Dispositivo> dispositivos;
    
    /**
     * Constructor del catálogo.
     * Inicializa la lista de dispositivos.
     */
    public Catalogo() {
        this.dispositivos = new ArrayList<>();
    }
    
    /**
     * Agrega un dispositivo al catálogo.
     * @param dispositivo Dispositivo a agregar
     */
    public void agregarDispositivo(Dispositivo dispositivo) {
        if (dispositivo != null) {
            dispositivos.add(dispositivo);
        }
    }
    
    /**
     * Obtiene todos los dispositivos del catálogo.
     * @return Lista de dispositivos
     */
    public List<Dispositivo> obtenerTodosDispositivos() {
        return new ArrayList<>(dispositivos); // Retornar copia para encapsulación
    }
    
    /**
     * Busca un dispositivo por su ID.
     * Ejemplo de polimorfismo: busca en toda la jerarquía.
     * @param id ID del dispositivo a buscar
     * @return Dispositivo encontrado o null
     */
    public Dispositivo buscarPorId(String id) {
        for (Dispositivo d : dispositivos) {
            if (d.getId().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }
    
    /**
     * Sobrecarga de búsqueda por nombre.
     * Ejemplo de overloading requerido.
     * @param nombre Nombre del dispositivo a buscar
     * @param porNombre Flag para distinguir de búsqueda por ID
     * @return Lista de dispositivos que coinciden con el nombre
     */
    public List<Dispositivo> buscarPorNombre(String nombre, boolean porNombre) {
        List<Dispositivo> resultados = new ArrayList<>();
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultados.add(d);
            }
        }
        return resultados;
    }
    
    /**
     * Ordena los dispositivos por consumo eléctrico.
     * Utiliza Comparable implementado en Dispositivo.
     * Competencia: Correcta implementación de Comparable.
     */
    public void ordenarPorConsumoElectrico() {
        Collections.sort(dispositivos);
    }
    
    /**
     * Obtiene dispositivos que implementan una interfaz específica.
     * Demuestra el uso de polimorfismo con interfaces.
     * @param interfaz Clase de la interfaz a filtrar
     * @return Lista de dispositivos que implementan la interfaz
     */
    public List<Dispositivo> obtenerPorInterfaz(Class<?> interfaz) {
        List<Dispositivo> resultados = new ArrayList<>();
        for (Dispositivo d : dispositivos) {
            if (interfaz.isAssignableFrom(d.getClass())) {
                resultados.add(d);
            }
        }
        return resultados;
    }
    
    /**
     * Obtiene la cantidad total de dispositivos.
     * @return int con el total de dispositivos
     */
    public int obtenerCantidadDispositivos() {
        return dispositivos.size();
    }
    
    /**
     * Calcula el consumo eléctrico total de todos los dispositivos activos.
     * @return double con el consumo total en watts
     */
    public double calcularConsumoTotal() {
        double total = 0;
        for (Dispositivo d : dispositivos) {
            if (d.isActivo()) {
                total += d.getConsumoElectrico();
            }
        }
        return total;
    }
    
    /**
     * Inicializa el catálogo con dispositivos de prueba.
     * Carga inicial requerida con al menos 10 equipos diversos.
     */
    public void inicializarCatalogo() {
        // 1. Sensor de Suelo
        agregarDispositivo(new SensorSuelo(
            "SS-001", "Sensor Suelo Parcela A", "AgriTech", 5.0, 
            "Parcela A - Zona Norte", "%", "Arcilloso", 0.3
        ));
        
        // 2. Sensor de Humedad
        agregarDispositivo(new SensorHumedad(
            "SH-001", "Sensor Humedad Invernadero", "SensorCorp", 3.5,
            "Invernadero Central", "%", 0.0, 100.0
        ));
        
        // 3. Sensor de Temperatura
        agregarDispositivo(new SensorTemperatura(
            "ST-001", "Sensor Temperatura Exterior", "ClimateMonitor", 4.0,
            "Estación Exterior", "°C", 35.0
        ));
        
        // 4. Estación Meteorológica
        agregarDispositivo(new EstacionMeteorologica(
            "EM-001", "Estación Meteorológica Principal", "WeatherPro", 25.0,
            "Torre Central"
        ));
        
        // 5. Dron de Riego
        agregarDispositivo(new DroneRiego(
            "DR-001", "Dron Riego Alpha", "DroneTech", 800.0,
            "Hangar Principal", 45.0, 120.0, 60.0, 50.0, 2.5
        ));
        
        // 6. Dron de Monitoreo
        agregarDispositivo(new DroneMonitoreo(
            "DM-001", "Dron Monitoreo Beta", "SkyVision", 600.0,
            "Hangar Principal", 60.0, 150.0, 70.0, "RGB+NIR", 24.0
        ));
        
        // 7. Dron Multiespectral
        agregarDispositivo(new DroneMultiespectral(
            "DMS-001", "Dron Multiespectral Gamma", "AgriDrone Pro", 1000.0,
            "Hangar Secundario", 40.0, 100.0, 50.0, 6
        ));
        
        // 8. Válvula de Riego
        agregarDispositivo(new ValvulaRiego(
            "VR-001", "Válvula Riego Sector 1", "IrrigationSys", 10.0,
            "Sector 1", 120.0
        ));
        
        // 9. Sistema de Riego
        agregarDispositivo(new SistemaRiego(
            "SR-001", "Sistema Riego Automatizado", "SmartIrrig", 150.0,
            "Central de Control", 12, 5000.0
        ));
        
        // 10. Cámara Multiespectral
        agregarDispositivo(new CamaraMultiespectral(
            "CM-001", "Cámara Multiespectral Fija", "VisionTech", 35.0,
            "Torre de Observación", 48, 90.0
        ));
        
        // 11. Sensor adicional de Suelo (para tener más de 10)
        agregarDispositivo(new SensorSuelo(
            "SS-002", "Sensor Suelo Parcela B", "AgriTech", 5.0,
            "Parcela B - Zona Sur", "%", "Franco", 0.4
        ));
    }
}
