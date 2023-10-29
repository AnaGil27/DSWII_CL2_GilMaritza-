CREATE DATABASE Control2BD;
USE Control2BD;

CREATE TABLE producto(
id int primary key auto_increment,
producto varchar(40),
descripcion varchar(40),
cantidad int,
fechavencimiento date 
);

INSERT INTO producto VALUES(1,'Leche', 'Natural',5, '2023-02-21');
INSERT INTO producto VALUES(2, 'Harina', 'Trigo',10, '2023-12-20');
INSERT INTO producto VALUES(3, 'Huevos', 'Corral',90, '2024-08-12');
INSERT INTO producto VALUES(4, 'Bicarbonato', 'Comestible',7, '2023-01-01');