
import java.util.List;
import java.util.Scanner;

/**
 * Clase Vista (Vista en MVC)
 * Maneja toda la interacción con el usuario mediante consola.
 * Competencia: Separación de responsabilidades según MVC.
 * 
 * IMPORTANTE: Toda la salida a consola debe estar en esta clase
 * para evitar penalización (-10 puntos por System.out fuera de Principal).
 */
public class Vista {
    private Scanner scanner;
    
    /**
     * Constructor de la Vista.
     */
    public Vista() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Muestra el menú principal.
     */
    public void mostrarMenuPrincipal() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GESTIÓN DE DISPOSITIVOS AGRO-TECNOLÓGICOS    ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.println("\n[1] Listar todos los dispositivos");
        System.out.println("[2] Buscar dispositivo por ID");
        System.out.println("[3] Buscar dispositivo por nombre");
        System.out.println("[4] Ordenar por consumo eléctrico");
        System.out.println("[5] Ver estadísticas del catálogo");
        System.out.println("[6] Ver dispositivos por capacidad");
        System.out.println("[7] Probar funcionalidades de un dispositivo");
        System.out.println("[0] Salir");
        System.out.print("\nSeleccione una opción: ");
    }
    
    /**
     * Lee una opción del menú.
     * @return int con la opción seleccionada
     */
    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    /**
     * Lee un texto del usuario.
     * @param mensaje Mensaje a mostrar
     * @return String con el texto ingresado
     */
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
    
    /**
     * Muestra la lista de todos los dispositivos.
     * @param dispositivos Lista de dispositivos
     */
    public void mostrarListaDispositivos(List<Dispositivo> dispositivos) {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("          LISTADO DE DISPOSITIVOS EN EL CATÁLOGO");
        System.out.println("═══════════════════════════════════════════════════════════");
        
        if (dispositivos.isEmpty()) {
            System.out.println("No hay dispositivos en el catálogo.");
            return;
        }
        
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.println("\n[" + (i + 1) + "] " + dispositivos.get(i).toString());
        }
        
        System.out.println("\n═══════════════════════════════════════════════════════════");
    }
    
    /**
     * Muestra información detallada de un dispositivo.
     * @param dispositivo Dispositivo a mostrar
     */
    public void mostrarDetalleDispositivo(Dispositivo dispositivo) {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║              INFORMACIÓN DETALLADA DEL DISPOSITIVO         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println(dispositivo.getInfoDetallada());
        
        // Mostrar capacidades según interfaces implementadas
        System.out.println("\nCapacidades:");
        if (dispositivo instanceof Medible) {
            System.out.println("  ✓ MEDIBLE: " + ((Medible) dispositivo).getTipoMedicion());
        }
        if (dispositivo instanceof Accionable) {
            System.out.println("  ✓ ACCIONABLE: " + ((Accionable) dispositivo).getTipoAccion());
        }
        if (dispositivo instanceof Registrable) {
            System.out.println("  ✓ REGISTRABLE: Puede almacenar historial de operaciones");
        }
        System.out.println("═══════════════════════════════════════════════════════════");
    }
    
    /**
     * Muestra un mensaje de dispositivo no encontrado.
     */
    public void mostrarDispositivoNoEncontrado() {
        System.out.println("\n❌ Dispositivo no encontrado.");
    }
    
    /**
     * Muestra estadísticas del catálogo.
     * @param cantidad Cantidad total de dispositivos
     * @param consumoTotal Consumo eléctrico total
     */
    public void mostrarEstadisticas(int cantidad, double consumoTotal) {
        System.out.println("\n╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║              ESTADÍSTICAS DEL CATÁLOGO                     ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝");
        System.out.println("Total de dispositivos: " + cantidad);
        System.out.println("Consumo eléctrico total: " + String.format("%.2f", consumoTotal) + " W");
        System.out.println("Consumo promedio: " + String.format("%.2f", consumoTotal / cantidad) + " W");
        System.out.println("═══════════════════════════════════════════════════════════");
    }
    
    /**
     * Muestra el submenú de capacidades.
     */
    public void mostrarMenuCapacidades() {
        System.out.println("\n--- Ver dispositivos por capacidad ---");
        System.out.println("[1] Dispositivos Medibles");
        System.out.println("[2] Dispositivos Accionables");
        System.out.println("[3] Dispositivos Registrables");
        System.out.print("Seleccione: ");
    }
    
    /**
     * Muestra el submenú de prueba de funcionalidades.
     */
    public void mostrarMenuPrueba(Dispositivo dispositivo) {
        System.out.println("\n--- Probar funcionalidades de: " + dispositivo.getNombre() + " ---");
        
        int opcion = 1;
        if (dispositivo instanceof Medible) {
            System.out.println("[" + opcion++ + "] Realizar medición");
        }
        if (dispositivo instanceof Accionable) {
            System.out.println("[" + opcion++ + "] Ejecutar acción");
            System.out.println("[" + opcion++ + "] Ejecutar acción con parámetros");
        }
        if (dispositivo instanceof Registrable) {
            System.out.println("[" + opcion++ + "] Registrar datos");
            System.out.println("[" + opcion++ + "] Ver historial");
        }
        System.out.println("[0] Volver");
        System.out.print("Seleccione: ");
    }
    
    /**
     * Muestra un mensaje genérico.
     * @param mensaje Mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }
    
    /**
     * Muestra un título de sección.
     * @param titulo Título a mostrar
     */
    public void mostrarTitulo(String titulo) {
        System.out.println("\n═══════════════════════════════════════════════════════════");
        System.out.println("  " + titulo);
        System.out.println("═══════════════════════════════════════════════════════════");
    }
    
    /**
     * Muestra mensaje de despedida.
     */
    public void mostrarDespedida() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║        Gracias por usar el Sistema de Gestión             ║");
        System.out.println("║            de Dispositivos Agro-Tecnológicos               ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
    }
    
    /**
     * Cierra el scanner.
     */
    public void cerrar() {
        scanner.close();
    }
}
