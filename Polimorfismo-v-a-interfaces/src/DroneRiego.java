
/**
 * Clase DroneRiego
 * Dron especializado en riego de cultivos.
 * Implementa Accionable y Registrable.
 */
public class DroneRiego extends Dron implements Accionable, Registrable {
    private double capacidadTanque; // en litros
    private double areaCoberturaHora; // hectáreas por hora
    
    public DroneRiego(String id, String nombre, String fabricante, double consumoElectrico, 
                     String ubicacion, double autonomiaBateria, double alturaMaxima, 
                     double velocidadMaxima, double capacidadTanque, double areaCoberturaHora) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion, autonomiaBateria, alturaMaxima, velocidadMaxima);
        this.capacidadTanque = capacidadTanque;
        this.areaCoberturaHora = areaCoberturaHora;
    }
    
    @Override
    public String ejecutarAccion() {
        String accion = String.format("Iniciando riego con capacidad de %.1f litros", capacidadTanque);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), accion));
        return accion;
    }
    
    @Override
    public String ejecutarAccion(String parametros) {
        String accion = String.format("Riego personalizado: %s - Capacidad: %.1f L", parametros, capacidadTanque);
        historial.append(String.format("[%s] %s\n", java.time.LocalDateTime.now(), accion));
        return accion;
    }
    
    @Override
    public String getTipoAccion() {
        return "Riego aéreo de cultivos";
    }
    
    @Override
    public String registrarDatos() {
        String registro = String.format("Registro de vuelo: Área regada aprox. %.2f ha", areaCoberturaHora);
        historial.append(String.format("[%s] Datos de riego registrados\n", java.time.LocalDateTime.now()));
        return registro;
    }
    
    @Override
    public String registrarDatos(String timestamp) {
        String registro = String.format("[%s] Registro de vuelo: Área regada aprox. %.2f ha", 
                                       timestamp, areaCoberturaHora);
        historial.append(String.format("[%s] Datos registrados\n", timestamp));
        return registro;
    }
    
    @Override
    public String obtenerHistorial() {
        return historial.length() > 0 ? historial.toString() : "Sin historial disponible";
    }
    
    @Override
    public String getTipo() {
        return "Dron de Riego";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Tanque: %.1f L | Cobertura: %.2f ha/h", capacidadTanque, areaCoberturaHora);
    }
}
