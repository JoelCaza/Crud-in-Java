create database Empleados;
use Empleados;


CREATE TABLE Clientes (
	id INT UNIQUE auto_increment,
    cedula VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    direccion VARCHAR(200),
    telefono VARCHAR(20),
    email VARCHAR(100)
);
