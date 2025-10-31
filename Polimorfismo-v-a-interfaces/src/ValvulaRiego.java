
/**
 * Clase ValvulaRiego
 * Dispositivo simple para control de riego.
 * Implementa solo Accionable (no registra datos).
 * Ejemplo de dispositivo con capacidad limitada.
 */
public class ValvulaRiego extends Dispositivo implements Accionable {
    private double flujoMaximo; // litros por minuto
    private String estadoActual; // "Abierta" o "Cerrada"
    
    public ValvulaRiego(String id, String nombre, String fabricante, double consumoElectrico, 
                       String ubicacion, double flujoMaximo) {
        super(id, nombre, fabricante, consumoElectrico, ubicacion);
        this.flujoMaximo = flujoMaximo;
        this.estadoActual = "Cerrada";
    }
    
    @Override
    public String ejecutarAccion() {
        estadoActual = estadoActual.equals("Cerrada") ? "Abierta" : "Cerrada";
        return String.format("Válvula %s. Flujo: %.1f L/min", estadoActual, 
                           estadoActual.equals("Abierta") ? flujoMaximo : 0.0);
    }
    
    @Override
    public String ejecutarAccion(String parametros) {
        // Permitir control parcial del flujo
        try {
            double porcentaje = Double.parseDouble(parametros);
            if (porcentaje > 0) {
                estadoActual = "Abierta";
                return String.format("Válvula abierta al %.0f%%. Flujo: %.1f L/min", 
                                   porcentaje, flujoMaximo * porcentaje / 100);
            } else {
                estadoActual = "Cerrada";
                return "Válvula cerrada";
            }
        } catch (NumberFormatException e) {
            return ejecutarAccion(); // Fallback al método simple
        }
    }
    
    @Override
    public String getTipoAccion() {
        return "Control de válvula de riego (abrir/cerrar)";
    }
    
    @Override
    public String getTipo() {
        return "Válvula de Riego";
    }
    
    @Override
    public String getInfoDetallada() {
        return super.getInfoDetallada() + 
               String.format(" | Flujo máximo: %.1f L/min | Estado: %s", flujoMaximo, estadoActual);
    }
}
