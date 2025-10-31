
/**
 * Interfaz Accionable
 * Define el contrato para dispositivos que pueden ejecutar acciones.
 * Competencia: Uso correcto de interfaces para proveer flexibilidad al diseño.
 */
public interface Accionable {
    /**
     * Ejecuta una acción específica del dispositivo.
     * @return String describiendo la acción ejecutada
     */
    String ejecutarAccion();
    
    /**
     * Ejecuta una acción con parámetros específicos.
     * Ejemplo de overloading para mayor flexibilidad.
     * @param parametros String con parámetros de la acción
     * @return String describiendo la acción ejecutada
     */
    String ejecutarAccion(String parametros);
    
    /**
     * Obtiene el tipo de acción que puede realizar el dispositivo.
     * @return String describiendo el tipo de acción
     */
    String getTipoAccion();
}
