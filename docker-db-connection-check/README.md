This is to check connection is available to DB or not. <br>

<Pre>

Docker build command :

docker build -t dbconcheck:1.1.1 -f dockerFile .

Docker Run command :

docker run -d --restart=always -p 7070:7070 dbconcheck:1.1.1





  Supporting now for Mysql,Oracle , Postgres.
  Develop to check on docker 

  Postman collection attached with this repo to check connection.

  Demo request as below :

 POST :  localhost:7070/api/database/check

  {
    "url": "jdbc:mysql://localhost:3306/world?allowPublicKeyRetrieval=true&useSSL=false",
    "username": "root",
    "password": "admin",
    "driverClassName": "org.hibernate.dialect.MySQLDialect"
}
  
</Pre>

