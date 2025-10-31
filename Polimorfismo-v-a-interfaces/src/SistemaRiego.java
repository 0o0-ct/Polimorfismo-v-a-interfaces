
/**
 * Clase SistemaRiego
 * Sistema completo de riego automatizado.
 * Implementa Accionable y Registrable.
 */
public class SistemaRiego extends Dispositivo implements Accionable, Registrable {
    private int numeroValvulas;
    private double caudalTotal; // litros por hora
    private StringBuilder historial;
    
    public SistemaRiego(String id, String nombre, String fabricante, double consumoElectrico, 
                       String ubicacion, int numeroValvulas, double caudalTotal) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.numeroValvulas = numeroValvulas;
        this.caudalTotal = caudalTotal;
        this.historial = new StringBuilder();
    }
    
    @Override
    public String ejecutarAccion() {
        String accion = String.format("Sistema de riego activado: %d válvulas, caudal total %.1f L/h",
                                     numeroValvulas, caudalTotal);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), accion));
        return accion;
    }
    
    @Override
    public String ejecutarAccion(String parametros) {
        String accion = String.format("Riego programado: %s - %d válvulas activas", parametros, numeroValvulas);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), accion));
        return accion;
    }
    
    @Override
    public String getTipoAccion() {
        return "Control de sistema de riego automatizado";
    }
    
    @Override
    public String registrarDatos() {
        String registro = String.format("Registro de riego: %.1f litros distribuidos", caudalTotal);
        historial.append(String.format("[%s] Datos de riego registrados\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("[%s] Registro de riego: sistema operativo", timestamp);
        historial.append(String.format("[%s] Datos registrados\n", timestamp));
        return registro;
    }
    
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Sistema de Riego";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Válvulas: %d | Caudal: %.1f L/h", numeroValvulas, caudalTotal);
    }
}
