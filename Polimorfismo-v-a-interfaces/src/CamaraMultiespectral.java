
/**
 * Clase CamaraMultiespectral
 * Cámara fija para análisis multiespectral de cultivos.
 * Implementa Medible y Registrable.
 */
public class CamaraMultiespectral extends Dispositivo implements Medible, Registrable {
    private int resolucion; // megapixeles
    private double campoVision; // grados
    private StringBuilder historial;
    
    public CamaraMultiespectral(String id, String nombre, String fabricante, double consumoElectrico, 
                               String ubicacion, int resolucion, double campoVision) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.resolucion = resolucion;
        this.campoVision = campoVision;
        this.historial = new StringBuilder();
    }
    
    @Override
    public String realizarMedicion() {
        // Simular análisis de imagen multiespectral
        double indiceSalud = 0.5 + (Math.random() * 0.4);
        double coberturaVegetacion = 60 + (Math.random() * 30);
        String medicion = String.format("Análisis de imagen: Índice salud=%.3f, Cobertura=%.1f%%",
                                       indiceSalud, coberturaVegetacion);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), medicion));
        return medicion;
    }
    
    @Override
    public String getTipoMedicion() {
        return "Captura y análisis de imagen multiespectral";
    }
    
    @Override
    public String registrarDatos() {
        String registro = String.format("Registro de imagen: %d MP, campo de visión %.1f°", 
                                       resolucion, campoVision);
        historial.append(String.format("[%s] Imagen registrada\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("[%s] Registro de imagen multiespectral", timestamp);
        historial.append(String.format("[%s] Datos registrados\n", timestamp));
        return registro;
    }
    
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Cámara Multiespectral";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Resolución: %d MP | Campo visión: %.1f°", resolucion, campoVision);
    }
}
