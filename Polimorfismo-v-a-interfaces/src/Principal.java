
/**
 * Clase Principal (Driver Program)
 * Punto de entrada de la aplicación.
 * 
 * Sistema de Gestión de Dispositivos Agro-Tecnológicos
 * Ejercicio 6 - Interfaces
 * 
 * Este programa demuestra:
 * - Uso correcto de herencia y polimorfismo
 * - Implementación de interfaces para flexibilidad
 * - Patrón de diseño MVC
 * - Lista polimórfica única para todos los dispositivos
 * - Implementación de Comparable para ordenamiento
 * - Overloading en múltiples métodos
 * - Buenas prácticas: toString, equals, encapsulación
 * 
 * Competencias desarrolladas:
 * ✓ Diseño con diagrama UML
 * ✓ Uso correcto de herencia
 * ✓ Uso correcto de interfaces
 * ✓ Polimorfismo vía herencia y overloading
 * ✓ Separación de responsabilidades con MVC
 * ✓ Buenas prácticas de programación
 * ✓ Implementación de Comparable
 * 
 * @author [Tu nombre]
 * @version 1.0
 * @since 2025-10-31
 */
public class Principal {
    
    /**
     * Método main - Punto de entrada de la aplicación.
     * Inicializa el patrón MVC y arranca el sistema.
     * 
     * NOTA: Esta es la única clase donde se permiten System.out.println
     * según las instrucciones del ejercicio.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Inicialización del patrón MVC
        Catalogo catalogo = new Catalogo();    // Modelo: maneja los datos
        Vista vista = new Vista();              // Vista: maneja la interfaz de usuario
        Controlador controlador = new Controlador(catalogo, vista); // Controlador: orquesta la lógica
        
        // Iniciar la aplicación
        controlador.iniciar();
    }
}
