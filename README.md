Creador de Usuarios

Este controlador maneja las solicitudes relacionadas con la creacion de usuarios en la aplicación, siguiendo la arquitectura hexagonal.

Desarrollo realizado con 
Java 17 
FrameWork SpringBoot 
Architecture Hexagonal 
Persistencia De Datos JPA 
BAse de Datos H2 

Endpoints:

    POST /rest/users/create: Crea un nuevo usuario en el sistema.
        Parámetros de Entrada: Se espera un cuerpo de solicitud JSON.
        Los campos obligatorios son:
            name: El nombre del usuario. No puede estar vacío.
            email: La dirección de correo electrónico del usuario. Debe ser una dirección de correo electrónico válida.
            password: La contraseña del usuario. No puede estar vacía.
            phones: Una lista de objetos JSON que representan los números de teléfono del usuario. Cada objeto debe contener los siguientes campos:
                number: El número de teléfono.
                citycode: El código de ciudad.
                countrycode: El código de país.
        Respuesta Exitosa: Devuelve un objeto JSON con los detalles del usuario creado, se devuelve estado de respuesta 200 Success
        Errores Posibles: Si hay errores de validación en los datos de entrada, se devuelve una respuesta de estado 409 Conflict con detalles sobre los campos incorrectos.
        Excepciones: Si ocurre un error durante la creación del usuario, se devuelve una respuesta de estado 409 Conflict con un mensaje de error detallado.

Uso

para realizar peticiones realiza una solicitud POST al endpoint /rest/users/create con un cuerpo JSON el cual debe contener los detalles del usuario que deseas crear. Tener presente los campos requeridos mencionados anteriormente.

Ejemplo utilizando cURL:

bash

curl -X POST \
  http://localhost:8080/rest/users/create \
  -H 'Content-Type: application/json' \
  -d '{
    "name": "Ejemplo Usuario",
    "email": "usuario@example.com",
    "password": "secreto123",
    "phones": [
      {
        "number": "123456789",
        "citycode": "1",
        "countrycode": "22"
      }
    ]
}'

Base de Datos

Este proyecto utiliza JPA (Java Persistence API) Utiliza una base de datos embebida H2, por lo que no es necesario ningún script para inicializarla. 
se puede acceder a la consola de H2 para administrar la base de datos utilizando la siguiente información de conexión:

Datos de Conexion 

    URL: jdbc:h2:mem:UsersDataBase
    Nombre de Usuario: admin
    Contraseña: admin

La consola de H2 está habilitada y puedes acceder a ella a través de la ruta /h2-console en el navegador web.

**Arquitectura Hexagonal**

Este proyecto sigue los principios de la arquitectura hexagonal, también conocida como arquitectura de puertos y adaptadores. En esta arquitectura, el núcleo de la aplicación está aislado de los detalles de implementación externos, como la interfaz de usuario y la persistencia de datos. Esto permite una mayor modularidad ,Adaptavidad, Escalamiento y flexibilidad en el desarrollo de la aplicación.



Contacto

Raul Medina Herrera Raulmh2011@gmail.com
