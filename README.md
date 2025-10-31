# Ejercicio 6: Interfaces

**CC2008 – Programación Orientada a Objetos**
**Semestre II, 2025**

## Competencias por desarrollar:
- Diseña los componentes de un programa que resuelvan la situación planteada usando un diagrama de clases en UML.
- Implementa un programa que corresponda al diseño elaborado y resuelva la situación planteada usando los principios de diseño estudiados.
- Hace un buen uso de la herencia, potenciando sus ventajas.
- Hace un buen uso de interfaces, aprovechando su flexibilidad.

## Situación por resolver:
La cooperativa agro-tecnológica opera fincas con sensores de suelo, estaciones meteorológicas y drones para riego y monitoreo. La dirección requiere un sistema que conecte dispositivos de distintos fabricantes y permita agregar nuevas capacidades sin rehacer el código cada semestre.

Algunos equipos solo miden y reportan; otros ejecutan acciones como abrir válvulas, rociar parcelas o capturar imágenes multiespectrales. Se estandariza el acceso mediante tres contratos: **medible, accionable y registrable**, y si un dispositivo no soporta cierta capacidad, el sistema debe seguir operando sin fallas.

Al iniciar, la aplicación ejecuta una carga inicial (`init`) que construye un catálogo en memoria con al menos **10 equipos de naturaleza diversa**. El personal interactúa mediante un menú de consola que permite:
- Listar todos los equipos con sus características.
- Buscar un equipo por ID o por nombre y mostrar toda su información.
- Ordenar el catálogo por consumo eléctrico para planificar mejor el uso de energía.

Toda la información mostrada debe corresponder al estado registrado en la carga inicial. El jefe de TI ha prometido que, cuando llegue el próximo dron, bastará con incorporarlo al catálogo para que aparezca en el menú y funcione bajo los mismos contratos, sin cambiar el código de orquestación en producción.

## Instrucciones
- Desarrolle un diagrama UML de su diseño. Asegúrese de aprovechar el uso de herencia y polimorfismo.
- No olvide emplear `overloading` donde lo necesite, ni de seguir los principios de diseño vistos en clase incluyendo la aplicación del patrón MVC.
- Implemente el prototipo incluyendo todas las funcionalidades requeridas. Su programa debe ser fiel a su diseño.
- El sistema debe tener solo una lista polimórfica que guarde todos los diversos ítems creados.

**Nota:** Sea creativo. Aquello que no esté explícitamente determinado en las instrucciones puede ser decidido por usted en su diseño. No tema hacer más uso de herencia que el obvio.

**Recuerde:** haga primero su diseño. Si durante la implementación identifica la necesidad de cambios, detenga la programación y rediseñe antes de continuar. Documente los cambios con comentarios explicativos en el código.

---

## Calificación

### Parte 1 - Análisis y diseño [50 pts.]
- **[10 pts.]** Uso correcto de una sola estructura polimórfica para almacenar los diversos objetos.
- **[05 pts.]** Correcto uso de herencia en las relaciones entre clases.
- **[05 pts.]** Correcto uso de interfaces en las relaciones entre clases.
- **[10 pts.]** Correcto uso de polimorfismo vía herencia en la especificación de parámetros para comportamientos de los componentes y las especificaciones de `overloading`.
- **[10 pts.]** Correcta separación de responsabilidades y aplicación de MVC y los principios de diseño para el cumplimiento de los requisitos funcionales.
- **[05 pts.]** Buenas prácticas de programación:
  - Override de `toString` (e `equals`, donde sirva).
  - Encapsulación mediante modificadores de visibilidad y getters/setters.
- **[05 pts.]** Correcta implementación de la interfaz `Comparable` para facilitar el ordenamiento de su lista polimórfica.

### Parte 2 - Programa que implemente su diseño [50 pts.]
- **[15 pts.]** Correcto uso de polimorfismo.
- **[20 pts.]** Cumplimiento de requisitos funcionales.
- **[10 pts.]** Usabilidad; interfaz amigable con el o los usuarios.
- **[05 pts.]** Comentarios y encabezados.

### Puntos Up (Hasta 20 puntos):
- **(+20 puntos)** Uso de interfaz gráfica.

### Puntos Down (Hasta 100 puntos):
- **(-30 puntos)** Por cada `While true` y su correspondiente `break`.
- **(-10 puntos)** Por cada mensaje que muestre al usuario (`System.out.println`) que haga fuera de la clase `Principal`.

---

## Entregables
- Archivo `.pdf` con el análisis y diseño.
- Enlace al repositorio con el código que implementa las clases y el `driver program` requerido.
