
/**
 * Clase EstacionMeteorologica
 * Estación completa que mide múltiples variables climáticas.
 * Implementa Medible y Registrable directamente.
 */
public class EstacionMeteorologica extends Dispositivo implements Medible, Registrable {
    private double temperatura;
    private double humedad;
    private double presionAtmosferica;
    private double velocidadViento;
    private StringBuilder historial;
    
    public EstacionMeteorologica(String id, String nombre, String fabricante, double consumoElectrico, String ubicacion) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.historial = new StringBuilder();
    }
    
    @Override
    public String realizarMedicion() {
        // Simular mediciones meteorológicas
        temperatura = 15 + (Math.random() * 20);
        humedad = 40 + (Math.random() * 40);
        presionAtmosferica = 980 + (Math.random() * 50);
        velocidadViento = Math.random() * 30;
        
        String medicion = String.format("Temp: %.1f°C, Humedad: %.1f%%, Presión: %.1f hPa, Viento: %.1f km/h",
                temperatura, humedad, presionAtmosferica, velocidadViento);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), medicion));
        return medicion;
    }
    
    @Override
    public String getTipoMedicion() {
        return "Mediciones meteorológicas completas (temperatura, humedad, presión, viento)";
    }
    
    @Override
    public String registrarDatos() {
        String registro = String.format("Registro meteorológico: T=%.1f°C, H=%.1f%%, P=%.1f hPa",
                temperatura, humedad, presionAtmosferica);
        historial.append(String.format("[%s] Datos meteorológicos registrados\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("[%s] Registro meteorológico: T=%.1f°C, H=%.1f%%, P=%.1f hPa",
                timestamp, temperatura, humedad, presionAtmosferica);
        historial.append(String.format("[%s] Datos registrados\n", timestamp));
        return registro;
    }
    
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Estación Meteorológica";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Última lectura: T=%.1f°C, H=%.1f%%", temperatura, humedad);
    }
}
