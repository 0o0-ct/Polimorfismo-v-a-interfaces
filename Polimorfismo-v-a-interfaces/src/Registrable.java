
/**
 * Interfaz Registrable
 * Define el contrato para dispositivos que pueden registrar datos.
 * Competencia: Uso correcto de interfaces para proveer flexibilidad al diseño.
 */
public interface Registrable {
    /**
     * Registra datos en el sistema.
     * @return String con información del registro
     */
    String registrarDatos();
    
    /**
     * Registra datos con una marca de tiempo específica.
     * Ejemplo de overloading.
     * @param timestamp String con la marca de tiempo
     * @return String con información del registro
     */
    String registrarDatos(String timestamp);
    
    /**
     * Obtiene el historial de registros.
     * @return String con el historial
     */
    String obtenerHistorial();
}
