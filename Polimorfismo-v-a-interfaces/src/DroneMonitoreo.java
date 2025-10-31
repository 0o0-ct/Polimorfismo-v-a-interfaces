
/**
 * Clase DroneMonitoreo
 * Dron especializado en monitoreo de cultivos.
 * Implementa Medible y Registrable.
 */
public class DroneMonitoreo extends Dron implements Medible, Registrable {
    private String tipoCamara;
    private double resolucionMegapixeles;
    
    public DroneMonitoreo(String id, String nombre, String fabricante, double consumoElectrico, 
                         String ubicacion, double autonomiaBateria, double alturaMaxima, 
                         double velocidadMaxima, String tipoCamara, double resolucionMegapixeles) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion, autonomiaBateria, alturaMaxima, velocidadMaxima);
        this.tipoCamara = tipoCamara;
        this.resolucionMegapixeles = resolucionMegapixeles;
    }
    
    @Override
    public String realizarMedicion() {
        // Simular captura de datos de monitoreo
        double coberturaSalud = 60 + (Math.random() * 35); // % de salud del cultivo
        String medicion = String.format("Monitoreo visual: Salud del cultivo %.1f%%, Resolución: %.1f MP",
                                       coberturaSalud, resolucionMegapixeles);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), medicion));
        return medicion;
    }
    
    @Override
    public String getTipoMedicion() {
        return "Monitoreo visual de cultivos con cámara " + tipoCamara;
    }
    
    @Override
    public String registrarDatos() {
        String registro = "Registro de vuelo de monitoreo: imágenes capturadas y analizadas";
        historial.append(String.format("[%s] Datos de monitoreo registrados\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("[%s] Registro de monitoreo: imágenes procesadas", timestamp);
        historial.append(String.format("[%s] Datos registrados\n", timestamp));
        return registro;
    }
    
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Dron de Monitoreo";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Cámara: %s | Resolución: %.1f MP", tipoCamara, resolucionMegapixeles);
    }
}
