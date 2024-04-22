# DEPENDENCIAS DEL PROYECTO

# Para la persistencia de datos
* JPA
 
         <dependency><groupId>org.springframework.boot</groupId><artifactId>spring-boot-starter-data-jpa</artifactId></dependency>
 

# Para el amacenamiento de datos 
* MySQL para entorno de desarrollo
  
       <dependency><groupId>com.mysql</groupId><artifactId>mysql-connector-j</artifactId><scope>runtime</scope></dependency>
  
  configuración en el archivo aplication.properties
  spring.datasource.url=jdbc:mysql://localhost:3306/inventario
  spring.datasource.username=root
  spring.datasource.password=

  spring.jpa.properties.dialect=org.hibernate.dialect.MySQLDialect
  spring.jpa.hibernate.ddl-auto=update


# Para la transferencia de datos entre entidad y dto
* MapStruct
  
   <!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct</artifactId>
            <version>1.5.5.Final</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct-processor -->
        <dependency>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>1.5.5.Final</version>
        </dependency>

# Para las validaciones
* validation
  
       <dependency><groupId>org.springframework.boot</groupId><artifactId>spring-boot-starter-validation</artifactId></dependency>
