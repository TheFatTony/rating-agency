# rating-agency
Project created to support all around crypto rating agency activities.
Has initial integration, and newsletter support.

To install Client run: npm install

To run project: mnv resources:resources jetty:run 

To run liquibase: mnv resources:resources liquibase:update

To package: mvn clean package

Default url: http://localhost:8080/

admin UI: http://localhost:8080/login
user: admin
password: admin


To run mysql in docker container use  docker run --detach --name=test-mysql --env="MYSQL_ROOT_PASSWORD=Orion123" -p 3308:3306 mysql 