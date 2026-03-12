# PROMPT – Generar proyecto Java

## Descripción

Hola ChatGPT. Voy a darte un enunciado de un ejercicio de programación en Java. Quiero que generes 
todo el código necesario para resolverlo, siguiendo una arquitectura concreta de proyecto. 
Estoy estudiando 1º de DAM (Desarrollo de Aplicaciones Multiplataforma), así que el código debe ser:

* claro
* sencillo
* fácil de entender
* bien organizado
* No lo hagas demasiado avanzado ni con arquitecturas complicadas

---

# Requisitos del código

1. El código debe:
   * Estar escrito en Java 21
   * Usar Programación Orientada a Objetos (POO)
   * Seguir una arquitectura organizada por paquetes
   * Usar excepciones personalizadas
   * Usar logs con SLF4J y Log4j 
   * Usar Lombok con @Data y @AllArgsConstructor

   <br>
   
2. Reglas sobre Lombok:
   * Usar solo @Data y @AllArgsConstructor
   * No generes getters ni setters manualmente
   * No uses @Getter ni @Setter
   * Solo añade métodos extra si son necesarios para la lógica del ejercicio


```
// Ejemplo de clase del modelo:

@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private int age;
}
```

---

# Importante

* NO generes estos archivos:
    * pom.xml
    * configuración de Log4j 
    * archivos de configuración de logs 
    * Solo quiero que uses logs dentro del código, porque yo ya tengo esos archivos en mi proyecto y los copiaré.

---

# Estructura obligatoria del proyecto

Debes organizar el código exactamente así:
- No cambies esta estructura. 
- No añadas paquetes extra salvo que sea absolutamente necesario. 
- Descripción de cada paquete model 
- Aquí van las clases del dominio del ejercicio.

```
src/main/java/org/ies/interno/company
│
├── apps
│   └── CompanyApp
│
├── exceptions
│   └── CustomException
│ 
├── model
│   ├── EntidadPrincipal
│   └── EntidadSecundaria  
│
├── reader
│   ├── EntidadReader
│   └── Reader
│
└── Main
```

Ejemplos:

**model**:
`Employee` `Department` `Company` `Product` `Order`

Las clases deben tener:
- atributos privados 
- Lombok (@Data y @AllArgsConstructor)
- métodos de lógica si son necesarios

```
// Ejemplo:
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private double price;
}
```

**reader**: `EmployeeReader` `DepartmentReader` `CompanyReader`
(Este paquete contiene clases que leen datos o crean objetos)

---

### Responsabilidades:




---

### Descripción de los paquetes


Contiene las clases que representan las entidades principales del sistema:

* Company
* Department
* Employee

**reader**
Clases encargadas de leer datos y procesarlos.

**exceptions**
Excepciones personalizadas para manejar errores específicos del sistema.

**apps**
Contiene la lógica principal de ejecución de la aplicación.

---

# Sistema de logs

El proyecto utiliza **SLF4J** junto con **Apache Log4j** para registrar información del sistema.

Los logs permiten:

* Registrar errores
* Depurar el funcionamiento del programa
* Seguir el flujo de ejecución

La configuración de logs se encuentra en:

```
src/main/resources/log4j.xml
```

---

# Ejecución del proyecto

Para ejecutar el proyecto:

1. Abrir el proyecto en **IntelliJ IDEA**
2. Compilar el proyecto con Maven
3. Ejecutar la clase:

```
Main
```

---

# Manejo de excepciones

El proyecto incluye excepciones personalizadas como:

* `EmployeeNotFoundException`
* `DepartmentNotFoundException`

Estas excepciones permiten controlar errores específicos del dominio de la aplicación.

---

# Autor

Proyecto desarrollado como práctica académica para aprendizaje de:

* Manejo de excepciones en Java
* Organización de proyectos
* Implementación de logs
* Uso de Maven

# Enunciado del ejercicio

Aquí te daré el ejercicio que quiero que resuelvas:

    [PEGAR EL ENUNCIADO]























<br><br><br>
crear objetos

leer datos

validar información

lanzar excepciones si hay errores

exceptions

Aquí se crean excepciones personalizadas del ejercicio.

Ejemplos:

EmployeeNotFoundException

InvalidProductException

Las excepciones deben extender de:

Exception

o

RuntimeException

Incluye constructores con mensajes de error claros.

apps

Aquí va la lógica principal del programa.

Ejemplo:

CompanyApp

Esta clase debe:

usar clases del model

usar clases del reader

manejar excepciones

ejecutar la lógica principal del ejercicio

Main

Debe existir una clase llamada:

Main

Con el método:

public static void main(String[] args)

Desde aquí se debe iniciar la aplicación, normalmente llamando a CompanyApp.

Uso de logs

Debes usar SLF4J con Log4j.

Ejemplo:

private static final Logger log = LoggerFactory.getLogger(ClassName.class);

Ejemplos de logs:

log.info("Inicio del programa");
log.warn("Dato incorrecto detectado");
log.error("Error al procesar los datos");

Usa logs en:

inicio del programa

creación de objetos

validaciones importantes

manejo de errores

⚠️ No generes archivos de configuración de logs. Solo usa los logs dentro del código.

Reglas importantes al generar el código

Cuando te dé el ejercicio debes:

Crear todas las clases necesarias

Seguir exactamente la estructura de paquetes

Usar POO correctamente

Usar excepciones personalizadas

Usar logs en puntos importantes

Hacer código claro y fácil de entender

Pensar que el código lo va a leer un estudiante de primero de DAM

No hagas:

código demasiado complejo

patrones de diseño avanzados innecesarios

arquitecturas complicadas

Cómo quiero que me entregues el resultado

Muéstrame el código separado por archivos, por ejemplo:

model/Employee.java

(código)

reader/EmployeeReader.java

(código)

apps/CompanyApp.java

(código)

Main.java

(código)

Regla importante si falta información

Si el enunciado no especifica algún detalle, debes tomar una decisión lógica y continuar con la implementación.

No te detengas ni preguntes.

