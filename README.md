# API-Rest
Este proyecto es una API REST para la creación de usuarios, que incluye validación de correo electrónico, generación de tokens JWT, y gestión de usuarios.

# Evaluación: JAVA.
- Desarrolle una aplicación que exponga una API RESTful de creación de usuarios.
- Todos los endpoints deben aceptar y retornar solamente JSON, inclusive al para los mensajes de error.
- Todos los mensajes deben seguir el formato:
```json
{"mensaje": "mensaje de error"}
```

# Registro.
- Ese endpoint deberá recibir un usuario con los campos "nombre", "correo", "contraseña", más un listado de objetos "teléfono", respetando el siguiente formato:

```json
{
   "name": "Juan Rodriguez",
   "email": "juan@rodriguez.org",
   "password": "hunter2",
   "phones": [
      {
         "number": "1234567",
         "citycode": "1",
         "contrycode": "57"
      }
   ]
}
```

* Responder el código de status HTTP adecuado.
* En caso de éxito, retorne el usuario y los siguientes campos:
  * id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID)
  * created: fecha de creación del usuario
  * modified: fecha de la última actualización de usuario
  * last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación)
  * token: token de acceso de la API (puede ser UUID o JWT)
  * isactive: Indica si el usuario sigue habilitado dentro del sistema.
* Si caso el correo conste en la base de datos, deberá retornar un error "El correo ya registrado".
* El correo debe seguir una expresión regular para validar que formato sea el correcto (aaaaaaa@dominio.cl). 
* La clave debe seguir una expresión regular para validar que formato sea el correcto. (El valor de la expresión regular debe ser configurable)
* El token deberá ser persistido junto con el usuario

# Requisitos
- Plazo: 3 días, si tienes algún inconveniente con el tiempo comunicate con nosotros.
- Banco de datos en memoria. Ejemplo: HSQLDB o H2.
- Proceso de build vía Gradle o Maven.
- Persistencia con JPA. Ejemplo: EclipseLink, Hibernate u OpenJPA.
- Framework SpringBoot.
- Java 8+
- Entrega en un repositorio público (github o bitbucket) con el código fuente y script de creación de BD.
- Readme explicando cómo probarlo.
- Diagrama de la solución.
- JWT como token
- Pruebas unitarias
- Swagger
- Se recomienda y se valorizará mucho la utilización de Patrones de Diseño y buenas practicas

# Solución.
Para revisar el proyecto, seguir los siguientes pasos:

1. Clonar el repositorio: git clone https://github.com/Gojeda84/API-Rest.git
2. Levantar proyecto con IDE preferido, en este caso es IntelliJ.
3. Compilar: mvn clean install
4. Ejecutar el proyecto: mvn spring-boot:run
5. Acceder a la consola de H2 para ver la BD en memoria.
   - URL: http://localhost:8080/h2-console
   - JDBC URL: jdbc:h2:mem:testdb
   - Usuario: sa
   - Contraseña: (dejar en blanco)
7. Para registrar un usuario ir al siguiente enlace: http://localhost:8080/users/register

## Autor
[**Gonzalo Ojeda**](https://github.com/Gojeda84)
