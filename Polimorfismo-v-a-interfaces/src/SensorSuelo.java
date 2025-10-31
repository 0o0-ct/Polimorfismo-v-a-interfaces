
/**
 * Clase SensorSuelo
 * Sensor especializado en medir propiedades del suelo (humedad, pH, nutrientes).
 * Hereda de Sensor e implementa Medible y Registrable a través de la herencia.
 */
public class SensorSuelo extends Sensor {
    private String tipoSuelo;
    private double profundidad; // en metros
    
    /**
     * Constructor de SensorSuelo.
     */
    public SensorSuelo(String id, String nombre, String fabricante, double consumoElectrico, 
                       String ubicacion, String unidadMedida, String tipoSuelo, double profundidad) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion, unidadMedida);
        this.tipoSuelo = tipoSuelo;
        this.profundidad = profundidad;
    }
    
    @Override
    protected double generarValorMedicion() {
        // Simular lectura de humedad del suelo (0-100%)
        return 20 + (Math.random() * 60);
    }
    
    @Override
    public String getTipoMedicion() {
        return "Humedad y propiedades del suelo";
    }
    
    @Override
    public String getTipo() {
        return "Sensor de Suelo";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Tipo Suelo: %s | Profundidad: %.2fm", tipoSuelo, profundidad);
    }
    
    public String getTipoSuelo() {
        return tipoSuelo;
    }
    
    public double getProfundidad() {
        return profundidad;
    }
}
