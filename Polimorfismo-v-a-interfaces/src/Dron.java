
/**
 * Clase abstracta Dron
 * Clase base para todos los drones del sistema.
 * Los drones tienen capacidades de vuelo y batería.
 */
public abstract class Dron extends Dispositivo {
    protected double autonomiaBateria; // en minutos
    protected double alturaMaxima; // en metros
    protected double velocidadMaxima; // en km/h
    protected StringBuilder historial;
    
    public Dron(String id, String nombre, String fabricante, double consumoElectrico, 
                String ubicacion, double autonomiaBateria, double alturaMaxima, double velocidadMaxima) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.autonomiaBateria = autonomiaBateria;
        this.alturaMaxima = alturaMaxima;
        this.velocidadMaxima = velocidadMaxima;
        this.historial = new StringBuilder();
    }
    
    public double getAutonomiaBateria() {
        return autonomiaBateria;
    }
    
    public double getAlturaMaxima() {
        return alturaMaxima;
    }
    
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
    
    @Override
    public String getTipo() {
        return "Dron";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Autonomía: %.0f min | Altura máx: %.0f m | Velocidad máx: %.0f km/h",
                             autonomiaBateria, alturaMaxima, velocidadMaxima);
    }
}
