
/**
 * Clase SensorHumedad
 * Sensor especializado en medir humedad ambiental.
 */
public class SensorHumedad extends Sensor {
    private double rangoMin;
    private double rangoMax;
    
    public SensorHumedad(String id, String nombre, String fabricante, double consumoElectrico, 
                        String ubicacion, String unidadMedida, double rangoMin, double rangoMax) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion, unidadMedida);
        this.rangoMin = rangoMin;
        this.rangoMax = rangoMax;
    }
    
    @Override
    protected double generarValorMedicion() {
        // Simular lectura de humedad ambiental
        return rangoMin + (Math.random() * (rangoMax - rangoMin));
    }
    
    @Override
    public String getTipoMedicion() {
        return "Humedad ambiental";
    }
    
    @Override
    public String getTipo() {
        return "Sensor de Humedad";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Rango: %.1f-%.1f %s", rangoMin, rangoMax, unidadMedida);
    }
}
