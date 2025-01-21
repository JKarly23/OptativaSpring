# Proyecto Spring - Optativa Project

Este es un proyecto de ejemplo basado en Spring Boot, utilizando H2 como base de datos y con entidades `CategoryEntity` y `ProductsEntity`. El proyecto incluye un endpoint de **seed** para poblar la base de datos al iniciar la aplicación o manualmente.

## Requisitos previos

1. **Java 17 o superior**  
   Este proyecto está configurado para usar Java 17 o una versión superior. Asegúrate de tener Java instalado en tu sistema.

   Para verificar la versión de Java:
   ```bash
   java -version
Maven
Este proyecto utiliza Maven como herramienta de construcción. Asegúrate de tener Maven instalado.

Para verificar si Maven está instalado:
mvn -v

IDE (opcional)
Se recomienda usar un IDE como IntelliJ IDEA, Eclipse o VS Code para desarrollar con Spring Boot, aunque no es obligatorio.

Postman o cURL (opcional)
Para probar los endpoints, puedes usar Postman o cURL.

## Pasos para levantar el proyecto
1. Clonar el repositorio
   Clona este repositorio a tu máquina local:

git clone https://github.com/JKarly23/OptativaSpring.git
cd optativa-project
2. Instalar dependencias
   Este proyecto usa Maven, por lo que las dependencias necesarias se manejarán a través del archivo pom.xml.

Si ya tienes Maven instalado, puedes usar el siguiente comando para instalar las dependencias:

bash
Copiar
Editar
mvn install
3. Configuración del archivo application.properties
   Asegúrate de que tu archivo src/main/resources/application.properties esté configurado correctamente para usar la base de datos H2 en memoria.

properties
Copiar
Editar
# Configuración de la base de datos H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Habilitar consola H2 para ver los datos en memoria
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
4. Ejecutar la aplicación
   Para iniciar la aplicación, simplemente ejecuta el siguiente comando en la raíz del proyecto: mvn spring-boot:run
Esto iniciará el servidor en el puerto 8080. Puedes acceder a la consola de H2 en http://localhost:8080/h2-console si deseas ver la base de datos en memoria.

5. Acceder a los endpoints
   Una vez que la aplicación esté en ejecución, puedes acceder a los siguientes endpoints:

GET /categories: Lista todas las categorías.
POST /categories/seed: Pone datos de ejemplo en la base de datos (puede ejecutarse manualmente).
GET /products: Lista todos los productos.
GET /products/category/{categoryId}: Lista los productos de una categoría específica.
### Ejemplo de cómo probar los endpoints:
Usando Postman o cURL, puedes probar los siguientes comandos:

*Obtener todas las categorías*: GET http://localhost:8080/categories

*Obtener productos por categoría*:  GET http://localhost:8080/products/category/1

*Sembrar la base de datos (seed)*: POST http://localhost:8080/categories/seed

# Estructura del proyecto
src/main/java: Contiene los archivos de código fuente de la aplicación.

controller: Contiene los controladores de Spring Boot para manejar las solicitudes HTTP.

entities: Contiene las entidades CategoryEntity y ProductsEntity.

repository: Contiene las interfaces de repositorio para interactuar con la base de datos.

service: Contiene la lógica de negocio y los servicios relacionados con las entidades.

seeder: Contiene la clase DataSeeder que se ejecuta para sembrar la base de datos.

src/main/resources/application.properties: Archivo de configuración de la base de datos y otros ajustes de Spring Boot.

pom.xml: Archivo de configuración de Maven que define las dependencias del proyecto.