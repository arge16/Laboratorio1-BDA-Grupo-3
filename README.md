Manual de usuario.

-- Este documento proporciona las instrucciones necesarias para la instalación y el uso de las tecnologías requeridas para ejecutar la aplicación de la entrega 1 del laboratorio.

Requisitos del Sistema:

Para la base de datos, se debe instalar lo siguiente:

PostgreSQL (versión 11+)
pgAdmin 4
Para el backend (desarrollado como una API RESTful en Spring), se debe instalar lo siguiente:

JDK (Versión 17)
Postman
IntelliJ IDEA (para backend y frontend)
Para el frontend, se debe instalar lo siguiente:

Vue.js (versión 2.x)

Pasos para Hacer Funcionar la Aplicación:

1. Configuración de la Base de Datos:

1.1. Abrir pgAdmin4 y crear una nueva base de datos llamada "lab1TBD".
1.2. Abrir "query tools" y cargar el script "dbCreate.sql" para crear las tablas necesarias.
1.3. Luego, cargar el script "loadData.sql" para poblar las tablas con datos.

2. Ejecución del Backend:

2.1. Iniciar IntelliJ y ejecutar el backend para habilitar el servidor necesario.

3. Ejecución del Frontend:

3.1. Abrir IntelliJ y navegar a la carpeta "frontend" dentro de "tbdFrontEnd".
3.2. Abrir una terminal en esta ubicación.
3.3. Ejecutar los siguientes comandos:

npm install
npm run serve
Estos pasos permitirán ejecutar el frontend del código fuente.
en la carpeta, ademas de tener instalado
- nodejs
