# Proyecto Empresa

## Descripción

Aplicación desarrollada en **Java 21** que simula la gestión básica de una empresa.
El sistema permite trabajar con **empleados**, **departamentos** y **empresas**, además de manejar errores mediante **excepciones personalizadas** y registrar información mediante **logs**. Este proyecto utiliza **Apache Maven** para la gestión de dependencias y construcción del proyecto.

---

# Tecnologías utilizadas

* Java 21
* Apache Maven
* Project Lombok
* SLF4J
* Apache Log4j

---

# Estructura del proyecto

```
src/main/java/org/ies/interno/company
│
├── apps
│   └── CompanyApp
│
├── exceptions
│   ├── DepartmentNotFoundException
│   └── EmployeeNotFoundException
│
├── model
│   ├── Company
│   ├── Department
│   └── Employee
│
├── reader
│   ├── CompanyReader
│   ├── DepartmentReader
│   ├── EmployeeReader
│   └── Reader
│
└── Main
```

### Descripción de los paquetes

**model**
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
