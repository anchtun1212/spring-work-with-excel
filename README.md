# spring-work-with-excel
Export data from database to excel sheet

# First Create new Database and new user 
Create new Database and new user
sudo -u postgres psql

postgres=# create database springdb;

postgres=# create user springuser with encrypted password 'springpass';

postgres=# grant all privileges on database springdb to springuser;

# To see the result just run the application and call this endpoint:
`http://localhost:8094/finalResult/genarateAllExcel`