
/**
 * Interfaz Medible
 * Define el contrato para dispositivos que pueden tomar mediciones.
 * Competencia: Uso correcto de interfaces para proveer flexibilidad al diseño.
 */
public interface Medible {
    /**
     * Realiza una medición con el dispositivo.
     * @return String con el resultado de la medición
     */
    String realizarMedicion();
    
    /**
     * Obtiene el tipo de medición que realiza el dispositivo.
     * @return String describiendo el tipo de medición
     */
    String getTipoMedicion();
}
