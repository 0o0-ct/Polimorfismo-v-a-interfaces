
/**
 * Clase DroneMultiespectral
 * Dron avanzado con capacidad de medición multiespectral y acciones.
 * Implementa las tres interfaces: Medible, Accionable y Registrable.
 * Ejemplo de dispositivo con múltiples capacidades.
 */
public class DroneMultiespectral extends Dron implements Medible, Accionable, Registrable {
    private int numeroBandas; // Bandas espectrales
    private String[] tiposBanda;
    
    public DroneMultiespectral(String id, String nombre, String fabricante, double consumoElectrico, 
                              String ubicacion, double autonomiaBateria, double alturaMaxima, 
                              double velocidadMaxima, int numeroBandas) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion, autonomiaBateria, alturaMaxima, velocidadMaxima);
        this.numeroBandas = numeroBandas;
        this.tiposBanda = new String[]{"RGB", "NIR", "Red Edge", "Térmica"};
    }
    
    @Override
    public String realizarMedicion() {
        // Simular captura multiespectral
        double ndvi = 0.3 + (Math.random() * 0.6); // NDVI entre 0.3 y 0.9
        double temperaturaVegetacion = 18 + (Math.random() * 10);
        String medicion = String.format("Análisis multiespectral: NDVI=%.3f, Temp. vegetación=%.1f°C, Bandas=%d",
                                       ndvi, temperaturaVegetacion, numeroBandas);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), medicion));
        return medicion;
    }
    
    @Override
    public String getTipoMedicion() {
        return String.format("Captura multiespectral en %d bandas", numeroBandas);
    }
    
    @Override
    public String ejecutarAccion() {
        String accion = "Iniciando vuelo de escaneo multiespectral de la parcela";
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), accion));
        return accion;
    }
    
    @Override
    public String ejecutarAccion(String parametros) {
        String accion = String.format("Escaneo multiespectral personalizado: %s", parametros);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), accion));
        return accion;
    }
    
    @Override
    public String getTipoAccion() {
        return "Escaneo multiespectral y análisis de vegetación";
    }
    
    @Override
    public String registrarDatos() {
        String registro = String.format("Registro multiespectral: %d bandas capturadas y procesadas", numeroBandas);
        historial.append(String.format("[%s] Datos multiespectrales registrados\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("[%s] Registro multiespectral: análisis NDVI completado", timestamp);
        historial.append(String.format("[%s] Datos registrados\n", timestamp));
        return registro;
    }
    
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Dron Multiespectral";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Bandas espectrales: %d | Capacidades: Medición + Acción", numeroBandas);
    }
}
