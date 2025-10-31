# Sistema de Gestión de Dispositivos Agro-Tecnológicos
## Ejercicio 6 - Interfaces

### Descripción del Proyecto

Sistema de gestión para una cooperativa agro-tecnológica que opera fincas con sensores de suelo, estaciones meteorológicas y drones. El sistema conecta dispositivos de distintos fabricantes mediante interfaces estandarizadas: Medible, Accionable y Registrable.

### Estructura del Proyecto

```
Polimorfismo-v-a-interfaces/
── src/                          # Código fuente Java
   ├── Medible.java             # Interfaz para dispositivos que miden
   ├── Accionable.java          # Interfaz para dispositivos que actúan
   ├── Registrable.java         # Interfaz para dispositivos que registran
   ├── Dispositivo.java         # Clase abstracta base (implementa Comparable)
   ├── Sensor.java              # Clase abstracta para sensores
   ├── SensorSuelo.java         # Sensor de propiedades del suelo
   ├── SensorHumedad.java       # Sensor de humedad ambiental
   ├── SensorTemperatura.java   # Sensor de temperatura
   ├── Dron.java                # Clase abstracta para drones
   ├── DroneRiego.java          # Dron para riego de cultivos
   ├── DroneMonitoreo.java      # Dron para monitoreo visual
   ├── DroneMultiespectral.java # Dron con análisis multiespectral
   ├── EstacionMeteorologica.java # Estación meteorológica completa
   ├── ValvulaRiego.java        # Válvula de control de riego
   ├── SistemaRiego.java        # Sistema automatizado de riego
   ├── CamaraMultiespectral.java # Cámara fija multiespectral
   ├── Catalogo.java            # Modelo (MVC) - Gestión de dispositivos
   ├── Vista.java               # Vista (MVC) - Interfaz de usuario
   ├── Controlador.java         # Controlador (MVC) - Lógica de negocio
   └── Principal.java           # Driver program


```

### Características Implementadas

#### ✅ Requisitos Funcionales
- **Carga inicial**: 11 dispositivos diversos precargados en el catálogo
- **Menú interactivo** con las siguientes opciones:
  1. Listar todos los dispositivos con sus características
  2. Buscar dispositivo por ID
  3. Buscar dispositivo por nombre (parcial)
  4. Ordenar catálogo por consumo eléctrico
  5. Ver estadísticas del catálogo
  6. Filtrar dispositivos por capacidad (interfaz)
  7. Probar funcionalidades de un dispositivo
  0. Salir

#### ✅ Competencias Técnicas Implementadas

**1. Herencia y Polimorfismo**
- Jerarquía de clases con `Dispositivo` como clase base abstracta
- Clases intermedias abstractas: `Sensor` y `Dron`
- 10+ clases concretas especializadas
- Override de `toString()`, `equals()`, `hashCode()`

**2. Interfaces**
- `Medible`: Para dispositivos que toman mediciones
- `Accionable`: Para dispositivos que ejecutan acciones
- `Registrable`: Para dispositivos que almacenan historial
- Los dispositivos implementan 1, 2 o 3 interfaces según sus capacidades

**3. Patrón MVC**
- **Modelo**: Clase `Catalogo` con lista polimórfica única
- **Vista**: Clase `Vista` con toda la interacción de consola
- **Controlador**: Clase `Controlador` con la lógica de negocio

**4. Lista Polimórfica Única**
- `List<Dispositivo>` almacena todos los tipos de dispositivos
- Permite operaciones polimórficas sobre objetos heterogéneos

**5. Comparable**
- `Dispositivo` implementa `Comparable<Dispositivo>`
- Ordenamiento por consumo eléctrico usando `Collections.sort()`

**6. Overloading**
- `ejecutarAccion()` y `ejecutarAccion(String parametros)`
- `registrarDatos()` y `registrarDatos(String timestamp)`
- `buscarPorId()` y `buscarPorNombre()`

**7. Encapsulación**
- Atributos `private` o `protected` según necesidad
- Getters y setters apropiados
- Métodos abstractos para extensibilidad

### Compilación y Ejecución

#### Compilar el proyecto
```bash
cd src/
javac *.java
```

#### Ejecutar el programa
```bash
java Principal
```

### Visualizar el Diagrama UML
-----

### Dispositivos Incluidos en el Catálogo Inicial

1. **SensorSuelo** (SS-001) - Parcela A
2. **SensorHumedad** (SH-001) - Invernadero
3. **SensorTemperatura** (ST-001) - Exterior
4. **EstacionMeteorologica** (EM-001) - Torre Central
5. **DroneRiego** (DR-001) - Hangar Principal
6. **DroneMonitoreo** (DM-001) - Hangar Principal
7. **DroneMultiespectral** (DMS-001) - Hangar Secundario
8. **ValvulaRiego** (VR-001) - Sector 1
9. **SistemaRiego** (SR-001) - Central de Control
10. **CamaraMultiespectral** (CM-001) - Torre de Observación
11. **SensorSuelo** (SS-002) - Parcela B

### Ejemplo de Uso

```
╔════════════════════════════════════════════════════════════╗
║   SISTEMA DE GESTIÓN DE DISPOSITIVOS AGRO-TECNOLÓGICOS    ║
╚════════════════════════════════════════════════════════════╝

[1] Listar todos los dispositivos
[2] Buscar dispositivo por ID
[3] Buscar dispositivo por nombre
[4] Ordenar por consumo eléctrico
[5] Ver estadísticas del catálogo
[6] Ver dispositivos por capacidad
[7] Probar funcionalidades de un dispositivo
[0] Salir

Seleccione una opción: 1
```

### Aspectos Destacados del Diseño

#### Flexibilidad
- Nuevos dispositivos se agregan fácilmente extendiendo clases base
- No requiere cambios en el código de orquestación
- Interfaces permiten capacidades opcionales

#### Polimorfismo en Acción
```java
// Lista polimórfica única
List<Dispositivo> dispositivos = new ArrayList<>();

// Agregar diferentes tipos
dispositivos.add(new SensorSuelo(...));
dispositivos.add(new DroneRiego(...));
dispositivos.add(new EstacionMeteorologica(...));

// Usar polimórficamente
for (Dispositivo d : dispositivos) {
    System.out.println(d.toString());  // Polimórfico
    if (d instanceof Medible) {
        ((Medible) d).realizarMedicion();  // Capacidad opcional
    }
}
```

#### Cumplimiento de Restricciones
- ✅ Sin `while(true)` con `break`
- ✅ Sin `System.out.println` fuera de `Principal` y `Vista`
- ✅ Una sola lista polimórfica
- ✅ Implementación completa de Comparable
- ✅ Override de toString y equals

### Buenas Prácticas Aplicadas

1. **Comentarios Javadoc** en todas las clases y métodos públicos
2. **Encapsulación** mediante modificadores de acceso
3. **Nombres descriptivos** para variables, métodos y clases
4. **Separación de responsabilidades** con MVC
5. **Diseño extensible** mediante herencia e interfaces
6. **Código reutilizable** con jerarquía de clases bien diseñada

### Autor

** Clever Juarez --- 251435 **  
CC2008 - Programación Orientada a Objetos  
Ejercicio 6 - Interfaces  
Semestre II, 2025

### Licencia

Este proyecto es parte de un ejercicio académico.
