# POC microservicio Calculadora
### Autor: Alberto Castillo Mancera


El proyecto se ha desarrollado con Maven + SpringBoot. Se requiere jdk 8 y se ha utilizado apache-maven-3.2.3.



 

Para construir el ejecutable hay que seguir los siguientes pasos:



En la carpeta \libs se encuentra la libería tracer que es necesario añadirla manualmente a nuestro repositorio maven:

`mvn install:install-file -Dfile=<PATH_FILE>\tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar`


Una vez instalada la librería en nuestro repositorio, podemos construir el ejecutable con maven o Maven-Wrapper posicionándonos en el directorio raíz del proyecto donde se encuentra el fichero pom.xml:

`mvn clean install`

`mvnw clean install` 

Los anteriores comandos compilan el proyecto en la carpeta target, ejecutan los test e instalan el jar resultante en nuestro repositorio Maven.

Para levantar el microservicio en una instancia de Tomcat ejecutamos:

`java -jar calculadora-0.0.1.jar`


El microservicio se ha implementado con un endpoint genérico que recibe como parámetros la operación y la lista de operandos.
 

Para usar el microservicio podemos hacerlo desde un navegador web o con herramientas como Postman:

Ejemplo de operación suma:

`http://127.0.0.1:8080/v1/rest/calculadora?operacion=suma&operandos=2.3,-5.3`

Ejemplo de operación resta:

`http://127.0.0.1:8080/v1/rest/calculadora?operacion=suma&operandos=2.3,-5.3`

Ejemplo de operación no soportada:

`http://127.0.0.1:8080/v1/rest/calculadora?operacion=division&operandos=2.3,-5.3`

Ejemplo de operación con operandos incorrectos (más de 2 operandos para la suma)

`http://127.0.0.1:8080/v1/rest/calculadora?operacion=suma&operandos=2.3,-5.3,8`

Ejemplo de operación con operandos incorrectos (1 único operando para la suma)

`http://127.0.0.1:8080/v1/rest/calculadora?operacion=suma&operandos=2.3`






 



 