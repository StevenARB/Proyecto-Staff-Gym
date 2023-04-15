CREATE DATABASE staffgym;
use staffgym;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `email` varchar(75) NOT NULL,
  `password` varchar(255) NOT NULL,
  `permissions` varchar(45) NOT NULL,
  `roles` varchar(45) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `active` INT NOT NULL,
  `clientes_id` INT(11),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_personas_clientes` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);

INSERT INTO `usuarios` VALUES (1,'Luis','luisgm98@gmail.com','$2a$12$yPcO1JXl.hyWWcx7lbLkjOjnFdYJrvupKczw2Lyj7G1jn5nCTo1Xe','ADMIN','ADMIN', '10/03/2023', 1, null);
INSERT INTO `usuarios` VALUES (2,'Bryan', 'brmoque123@gmail.com', '$2a$12$r5B.uvQsc15.aT/7lXmC0OPNB2SyxXa1a0SQSWHagBj8IJFkotfyO','USER','USER','10/03/2023', 1, null);
INSERT INTO `usuarios` VALUES (3,'María','marflomi32@gmail.com', '$2a$12$5d99ilZwUsDxKcLzaNBbLuN11PG/PdaJLhqHOD6HgxeaMo5FfY9wS','ADMIN','ADMIN', '10/03/2023', 1, null);


CREATE TABLE `clientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `cedula` varchar(11) NOT NULL,
  `email` varchar(75) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `clientes` VALUES (1,'Luis','Guerrero','Mora','1-9880-7590','luisgm98@gmail.com','8989-9090', '10/03/2023');
INSERT INTO `clientes` VALUES (2,'Bryan','Mora','Quesada','1-6425-3637','brmoque123@gmail.com','7478-5678', '10/03/2023');
INSERT INTO `clientes` VALUES (3,'María','Flores','Miranda','1-8612-8852','marflomi32@gmail.com','2565-0925', '10/03/2023');


CREATE TABLE `anuncios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `mensaje` varchar(500) NOT NULL,
  `imagen` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `contacto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `contacto` VALUES (1,'Luis','Guerrero Mora','San Jose','Del barrio chino sube ','8989-9090','luisgm98@gmail.com');
INSERT INTO `contacto` VALUES (2,'Jorge','Mora Artavia','Cartago', 'De la esquina subiendo','7478-5678','brmoque123@gmail.com');
INSERT INTO `contacto` VALUES (3,'María','Flores Miranda','Heredia','De la esquina bajando','2565-0925','marflomi32@gmail.com');


CREATE TABLE `reservacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidoPaterno` varchar(45) NOT NULL,
  `apellidoMaterno` varchar(45) NOT NULL,
  `cedula` varchar(11) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  `telefono` varchar(9) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `reservacion` VALUES (1,'Luis','Guerrero','Mora','1-9880-7590','luisgm98@gmail.com','8989-9090', '10/03/2023');
INSERT INTO `reservacion` VALUES (2,'Saul','Mora','Quesada','3-0309-780','aaron1@gmail.com','7478-5678', '14/03/2023');
INSERT INTO `reservacion` VALUES (3,'Marlene','Molina','Rodriguez','3-0306-815','marmolina@gmail.com','8698-5728', '02/03/2023');


CREATE TABLE `foro` (
`id` int(20) NOT NULL AUTO_INCREMENT,
`autor` varchar(50) NOT NULL,
`titulo` varchar(100) NOT NULL,
`mensaje` varchar (500) NOT NULL,
PRIMARY KEY (`id`)
);


 CREATE TABLE `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `precio` int(45) NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `productos` VALUES (1,'Proteina Whey','Sabor Cookies & Cream de Foodspring', 19000);
INSERT INTO `productos` VALUES (2,'Batido de proteinas','Sabor Milkshake de Barebells', 17.138);
INSERT INTO `productos` VALUES (3,'Mezcla de Proteina','Whey Protein chocolate blanco de Scitec Nutritio', 24.138);
INSERT INTO `productos` VALUES (4,'Concentrado de proteína','Serious Mass de Optimum Nutrition', 35.138);
INSERT INTO `productos` VALUES (5,'Batido de proteinas','suero Evowhey 2.0 de HSN', 35.000);
INSERT INTO `productos` VALUES (6,'Concentrado de proteínas','Gold Standard 100% Whey de Optimum Nutrition', 37.138);
INSERT INTO `productos` VALUES (7,'Batido de proteinas','Fit Body Plus', 21.130);
INSERT INTO `productos` VALUES (8,'Batido de proteinas','Protein 3K de NU3', 20.138);
INSERT INTO `productos` VALUES (9,'Batido de proteinas','Bajo en carbohidratos de Body Attack', 20.000);
INSERT INTO `productos` VALUES (10,'Weider Proteína 100% vegetals','Guisantes y arroz', 16.000);
INSERT INTO `productos` VALUES (11,'Bimanán Befit Batido de proteínas','Sabor Chocolate', 16.000);
INSERT INTO `productos` VALUES (12,'SOTYA-SOTYA Proteína Soja 90%','Sabor Fresa 500 gr', 8.000);
INSERT INTO `productos` VALUES (13,'Batido sustitutivo de comidas','Active Shake de XLS', 29.000);
INSERT INTO `productos` VALUES (14,'Botella de agua medio galón/64 oz','Con marcador motivacional y tiempo y pajita, botella de tritan, para entrenamiento gimnasio', 19.000);
INSERT INTO `productos` VALUES (15,'MEITAGIE','Botella de agua motivacional de 32 oz con marcador de tiempo y colador de frutas', 8.000);
INSERT INTO `productos` VALUES (16,'Fimibuke Botella de agua de medio galón con funda','Botella de agua de 64 oz con pajita y marcador de tiempo a prueba de fugas', 14.000);
INSERT INTO `productos` VALUES (17,'YOUCAN PLATO','Botella de agua de medio galón de 64 onzas con funda', 14.000);
INSERT INTO `productos` VALUES (18,'Botella de agua de cristal de 2.1 lbs','Con tapa de silicona a prueba de fugas', 10.000);
INSERT INTO `productos` VALUES (19,'VOLTRX Botella eléctrica','Botella  mezclar batidos con proteínas', 15.000);
INSERT INTO `productos` VALUES (20,'10 botellas de agua de aluminio de 20 onzas','Botellas reutilizables de aluminio, ligeras, con tapa a presión', 21.000);
INSERT INTO `productos` VALUES (21,'Gymletics Paquete de 7','Almohadillas de sentadillas', 16.700);
INSERT INTO `productos` VALUES (22,'Gymreapers Rodilleras','con correa para sentadillas, levantamiento de pesas', 10.700);
INSERT INTO `productos` VALUES (23,'Gymreapers Rodilleras','con correa para sentadillas, levantamiento de pesas', 10.700);
INSERT INTO `productos` VALUES (24,'Bolsa de viaje para gimnasio','Bolsa de viaje para gimnasio', 20.700);
INSERT INTO `productos` VALUES (25,'Bolsa deportiva de gimnasio para mujer','Bolsa deportiva de gimnasio para mujer', 15.700);
INSERT INTO `productos` VALUES (26,'PUMA Evercat Contender 3.0','Bolsa deportiva de gimnasio', 15.700);
INSERT INTO `productos` VALUES (27,'INZCOU','Tenis de correr livianos, antideslizantes, para gimnasio, entrenamiento, malla transpirable, para caminar', 15.700);
INSERT INTO `productos` VALUES (28,'Reebok','Tenis deportivos Workout Plus para hombre', 15.700);
INSERT INTO `productos` VALUES (29,'Hello MrLin','Tenis deportivos antideslizantes para correr o caminar; tenis con suela tipo blade estilo hip hop para hombre', 15.700);
INSERT INTO `productos` VALUES (30,'MARSVOVO ','Tenis de correr para hombre, antideslizantes, para caminar, entrenamiento', 15.700);
INSERT INTO `productos` VALUES (31,'PUMA','Zapatos deportivos Riaze Prowl para mujer', 15.700);
INSERT INTO `productos` VALUES (32,'Whitin','Tenis para correr, zapatos minimalistas, suela de grosor mínimo, punta ancha', 14.700);
INSERT INTO `productos` VALUES (33,'DUDHUH Zapatos deportivos',' Zapatos deportivos para correr para mujer', 14.700);
INSERT INTO `productos` VALUES (34,'GOFAYA','Zapatos ligeros para caminar para mujer, atléticos, antideslizantes, transpirables, informales, de malla, para entrenamiento', 14.700);
INSERT INTO `productos` VALUES (35,'Tenis de caña alta','Tenis de caña alta para mujer, zapatos deportivos clásicos de lona, tenis casuales para caminar', 14.700);


