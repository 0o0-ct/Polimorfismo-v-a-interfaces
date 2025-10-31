
/**
 * Clase abstracta Sensor
 * Clase base para todos los sensores del sistema.
 * Implementa las interfaces Medible y Registrable.
 * Competencia: Uso correcto de herencia múltiple mediante interfaces.
 */
public abstract class Sensor extends Dispositivo implements Medible, Registrable {
    protected String unidadMedida;
    protected double valorActual;
    protected StringBuilder historial;
    
    /**
     * Constructor de Sensor.
     * @param id Identificador único
     * @param nombre Nombre del sensor
     * @param fabricante Fabricante
     * @param consumoElectrico Consumo en watts
     * @param ubicacion Ubicación física
     * @param unidadMedida Unidad de medida del sensor
     */
    public Sensor(String id, String nombre, String fabricante, double consumoElectrico, 
                  String ubicacion, String unidadMedida) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.unidadMedida = unidadMedida;
        this.valorActual = 0.0;
        this.historial = new StringBuilder();
    }
    
    public String getUnidadMedida() {
        return unidadMedida;
    }
    
    public double getValorActual() {
        return valorActual;
    }
    
    protected void setValorActual(double valor) {
        this.valorActual = valor;
    }
    
    /**
     * Implementación de realizarMedicion de la interfaz Medible.
     * Genera una medición simulada.
     * @return String con el resultado de la medición
     */
    @Override
    public String realizarMedicion() {
        // Simular una medición
        this.valorActual = generarValorMedicion();
        String medicion = String.format("Medición: %.2f %s", valorActual, unidadMedida);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), medicion));
        return medicion;
    }
    
    /**
     * Método abstracto para generar valores de medición específicos del sensor.
     * @return double con el valor medido
     */
    protected abstract double generarValorMedicion();
    
    /**
     * Implementación de registrarDatos de la interfaz Registrable.
     * @return String con información del registro
     */
    @Override
    public String registrarDatos() {
        String registro = String.format("Registro: %s - %.2f %s", nombre, valorActual, unidadMedida);
        historial.append(String.format("[%s] Datos registrados\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    /**
     * Sobrecarga de registrarDatos con timestamp.
     * Ejemplo de overloading requerido.
     * @param timestamp Marca de tiempo específica
     * @return String con información del registro
     */
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("Registro [%s]: %s - %.2f %s", timestamp, nombre, valorActual, unidadMedida);
        historial.append(String.format("[%s] Datos registrados con timestamp\n", timestamp));
        return registro;
    }
    
    /**
     * Implementación de obtenerHistorial de la interfaz Registrable.
     * @return String con el historial de mediciones
     */
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Sensor";
    }
}
