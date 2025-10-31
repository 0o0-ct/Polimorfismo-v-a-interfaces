
/**
 * Clase abstracta Dispositivo
 * Clase base para todos los dispositivos del sistema agro-tecnológico.
 * Implementa Comparable para permitir ordenamiento por consumo eléctrico.
 * Competencia: Uso correcto de herencia y polimorfismo.
 */
public abstract class Dispositivo implements Comparable<Dispositivo> {
    // Atributos protegidos para acceso desde clases derivadas
    protected String id;
    protected String nombre;
    protected String fabricante;
    protected double consumoElectrico; // En watts
    protected boolean activo;
    protected String ubicacion;
    
    /**
     * Constructor con parámetros.
     * @param id Identificador único del dispositivo
     * @param nombre Nombre descriptivo del dispositivo
     * @param fabricante Fabricante del dispositivo
     * @param consumoElectrico Consumo eléctrico en watts
     * @param ubicacion Ubicación física del dispositivo
     */
    public Dispositivo(String id, String nombre, String fabricante, double consumoElectrico, String ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.consumoElectrico = consumoElectrico;
        this.activo = true;
        this.ubicacion = ubicacion;
    }
    
    // Getters y Setters (Encapsulación)
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    
    public double getConsumoElectrico() {
        return consumoElectrico;
    }
    
    public void setConsumoElectrico(double consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    /**
     * Método abstracto para obtener el tipo de dispositivo.
     * Debe ser implementado por las clases derivadas.
     * @return String con el tipo de dispositivo
     */
    public abstract String getTipo();
    
    /**
     * Obtiene información detallada del dispositivo.
     * Puede ser sobrescrito por clases derivadas.
     * @return String con información detallada
     */
    public String getInfoDetallada() {
        return String.format("ID: %s | Nombre: %s | Fabricante: %s | Consumo: %.2f W | Ubicación: %s | Estado: %s",
                id, nombre, fabricante, consumoElectrico, ubicacion, (activo ? "Activo" : "Inactivo"));
    }
    
    /**
     * Implementación de compareTo para ordenar por consumo eléctrico.
     * Requerimiento: Implementación correcta de Comparable.
     * @param otro Dispositivo a comparar
     * @return int negativo, cero o positivo
     */
    @Override
    public int compareTo(Dispositivo otro) {
        return Double.compare(this.consumoElectrico, otro.consumoElectrico);
    }
    
    /**
     * Override de toString para representación legible.
     * Buena práctica de programación.
     * @return String representando el dispositivo
     */
    @Override
    public String toString() {
        return String.format("%s [%s] - %s (%.2f W)", getTipo(), id, nombre, consumoElectrico);
    }
    
    /**
     * Override de equals para comparación de dispositivos.
     * Buena práctica de programación.
     * @param obj Objeto a comparar
     * @return boolean indicando si son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Dispositivo otro = (Dispositivo) obj;
        return id.equals(otro.id);
    }
    
    /**
     * Override de hashCode para consistencia con equals.
     * @return int hash code del dispositivo
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
