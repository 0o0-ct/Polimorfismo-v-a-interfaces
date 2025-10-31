
/**
 * Clase SensorTemperatura
 * Sensor especializado en medir temperatura.
 */
public class SensorTemperatura extends Sensor {
    private double umbralAlerta;
    
    public SensorTemperatura(String id, String nombre, String fabricante, double consumoElectrico, 
                            String ubicacion, String unidadMedida, double umbralAlerta) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion, unidadMedida);
        this.umbralAlerta = umbralAlerta;
    }
    
    @Override
    protected double generarValorMedicion() {
        // Simular lectura de temperatura (15-35°C)
        return 15 + (Math.random() * 20);
    }
    
    @Override
    public String getTipoMedicion() {
        return "Temperatura ambiental";
    }
    
    @Override
    public String getTipo() {
        return "Sensor de Temperatura";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Umbral Alerta: %.1f%s", umbralAlerta, unidadMedida);
    }
    
    public boolean verificarAlerta() {
        return valorActual > umbralAlerta;
    }
}
