archetype-web: Archetype de un sistema web que usa Java EE 7 e integra autenticación con Llave CDMX
==============================================================================================
Autor: Raúl Soto García

Tecnologías: JSF, CDI, EJB, REST, EAR, Maven.

Lenguaje: Java EE 7, Java SE 8.

Despliegue: JBoss WildFly 17.


Objetivo del Proyecto
-----------
Contar con un template de un sistema web para la ADIP.


Requerimientos del Sistema
-------------------

Para la construcción del proyecto se requiere Java 8.0 (Java SDK 1.8) y Maven 3.1.

La aplicación que produce este proyecto está diseñada para correr en JBoss WildFly 17.

En la configuración de WildFly se debe agregar:

a) Datasource para la Base de Datos PostgreSQL del proyecto covid-web.

 
Construir y desplegar la aplicación
-------------------------

NOTA: Los siguientes comandos asumen que se ha configurado Maven correctamente.

1. Asegurarse que se cuenta con Java 1.8 instalado y la variable JAVA_HOME asignada.

2. Abrir una línea de comandos y navegar al directorio raíz de este proyecto.

3. Ejecutar el siguiente comando para compilar y construir el proyecto:

    mvn clean install
    
4. Copiar el archivo que se genera: target/archetype-web.ear dentro de la carpeta "deployment" de wildfly.



Configurar JBoss WildFly
---------------------


a) Configurar Datasource

El Datasource se conectará a la BD Postgres, por lo cual primero se debe configurar el Driver (JDBC) como un módulo de Jboss Wildfly y luego configurar la conexión. 

Para configurar el driver como un Módulo se deben realizar las siguientes acciones:

1. Primero, se descarga el JDBC de Postgres en su versión 42.2.6 desde el sitio oficial.
2. En la carpeta de instalación de Wildfly 17, en la sub-carpeta modules/system/layers/base/org se crean las carpetas /postgresql/main
3. Dentro de la carpeta /postgresql/main se copia el JAR del JDBC.
4. Dentro de la carpeta /postgresql/main se crea el archivo module.xml con el siguiente contenido:

	<?xml version="1.0" encoding="UTF-8"?>
	<module name="org.postgresql" xmlns="urn:jboss:module:1.5">
	    <resources>
	        <resource-root path="postgresql-42.2.6.jar"/>
	    </resources>
	    <dependencies>
	        <module name="javax.api"/>
	        <module name="javax.transaction.api"/>
	    </dependencies>
	</module>

Luego, para configurar el datasource utilizando el driver, se realizan las siguientes acciones:

1. Se abre el archivo /standalone/configuration/standalone.xml
2. Se busca el subsistema <subsystem xmlns="urn:jboss:domain:datasources:5.0">
3. Dentro de dicho subsistema, existe un elemento <drivers> con la configuración por defecto con el Driver de la base de datos H2, por lo cual falta agregar la configuración del driver para Postgres, por lo tanto se agrega el driver de la siguiente manera:

	<drivers>
        <driver name="h2" module="com.h2database.h2">
            <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
        </driver>
        <driver name="postgresql" module="org.postgresql">
            <driver-class>org.postgresql.Driver</driver-class>
        </driver>
    </drivers>
4. Luego, dentro del mismo subsistema, se agrega el datasource de la siguiente manera:

	<datasource jndi-name="java:jboss/datasources/archetypeDS" pool-name="archetypeDS" enabled="true" use-java-context="true" statistics-enabled="${wildfly.datasources.statistics-enabled:${wildfly.statistics-enabled:false}}">
        <!-- Modificar valores -->
        <connection-url>jdbc:postgresql://DOMINIO_O_IP:5432/MIBD</connection-url>
        
        <connection-property name="defaultRowPrefetch">20</connection-property>
        <driver>postgresql</driver>
        <pool>
        	   <!-- Para produccion, modificar valores -->
            <min-pool-size>1</min-pool-size>
            <max-pool-size>1</max-pool-size>
            <prefill>true</prefill>
        </pool>
        
        <!-- Modificar valores -->
        <security>
            <user-name>USUARIO_DE_BD</user-name>
            <password>PASSWORD_DE_BD</password>
        </security>
        <validation>
            <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLValidConnectionChecker"/>
            <validate-on-match>false</validate-on-match>
            <background-validation>true</background-validation>
            <background-validation-millis>300000</background-validation-millis>
            <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.postgres.PostgreSQLExceptionSorter"/>
        </validation>
        <timeout>
            <blocking-timeout-millis>30000</blocking-timeout-millis>
            <idle-timeout-minutes>15</idle-timeout-minutes>
            <query-timeout>120</query-timeout>
            <allocation-retry>3</allocation-retry>
            <allocation-retry-wait-millis>10000</allocation-retry-wait-millis>
        </timeout>
    </datasource>


Iniciar JBoss WildFly con un perfil Web
---------------------

Después de compilar el proyecto con Java 1.8 y haber copiado el .EAR a la carpeta "deployment" de WildFly, se debe abrir una línea de comandos y ejecutar desde la carpeta /bin:


        Para Linux y MacOs:   JBOSS_HOME/bin/standalone.sh 
        Para Windows: JBOSS_HOME\bin\standalone.bat


Ingresar a la aplicación y hacer uso de sus servicios
---------------------

La aplicación estará ejecutándose en la siguiente URL: http://localhost:8080/archetype.

