CREATE DATABASE staffgym;
use staffgym;

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



CREATE TABLE `entrenadores` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `entrenadores` VALUES (1,'Marc'),(2,'Isaac'),(3,'Ana');

CREATE TABLE `contactarlos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombreU` varchar(45) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  `mensaje` varchar(500) NOT NULL,
  `entrenadores_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_contactarlos_entrenadores_idx` (`entrenadores_id`),  
  CONSTRAINT `fk_contactarlos_entrenadores` FOREIGN KEY (`entrenadores_id`) REFERENCES `entrenadores` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
);


INSERT INTO `contactarlos` (`nombreU`, `email`, `mensaje`, `entrenadores_id`) 
VALUES ('Juan Mora', 'juan@gmail.com', 'Hola, quisiera solicitar información sobre los servicios ofrecidos', 1),
       ('Pedro Sanchez', 'pedro@yahoo.com', 'Hola, quisiera agendar una cita con el entrenador Isaac', 2),
       ('Maria Bermudez', 'maria@hotmail.com', 'Me interesa saber sobre el plan de entrenamiento para principiantes', 3);


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


CREATE TABLE `anuncios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `mensaje` varchar(500) NOT NULL,
  `imagen` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `anuncios` VALUES (1, '¡Aún tienes Tiempo!', '10/03/2023', 'Disfruta de nuestras nuevas Membresías y se parte de Staff Gym', 'https://images.unsplash.com/photo-1629339837617-7069ce9e7f6b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=725&q=80');
INSERT INTO `anuncios` VALUES (2, 'Conoce nuestras Instalaciones', '10/03/2023', 'No tienes que Pagar nada, ven a conocer nuestras Instalaciones', 'https://images.unsplash.com/photo-1603665409265-bdc00027c217?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1yZWxhdGVkfDE0fHx8ZW58MHx8fHw%3D&auto=format&fit=crop&w=500&q=60');


CREATE TABLE `ejercicios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `tiempo` varchar(10) NOT NULL,
  `instrucciones` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `ejercicios` VALUES (1, 'Correr', 'Cardio', '45', 'Realiza 3 intervalos de 10 minutos corriendo y 5 minutos de descanso entre cada intervalo nivelando tu capacidad para conseguirlo');
INSERT INTO `ejercicios` VALUES (2, 'Burpees', 'Resistencia', '10', 'Realiza 50 repeticiones con intervalos de 5 Burpees por Minuto');
INSERT INTO `ejercicios` VALUES (3, 'Push-Ups', 'Fuerza', '10', 'Realiza 30 repeticiones con intervalos de 3 Push-Ups por Minuto');


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
  `apellidos` varchar(45) NOT NULL,
  `cedula` varchar(11) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  `telefono` varchar(9) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `reservacion` VALUES (1,'Luis','Guerrero Mora','1-9880-7590','luisgm98@gmail.com','8989-9090', '10/03/2023');
INSERT INTO `reservacion` VALUES (2,'Saul','Mora Quesada','3-0309-780','aaron1@gmail.com','7478-5678', '14/03/2023');
INSERT INTO `reservacion` VALUES (3,'Marlene','Molina Rodriguez','3-0306-815','marmolina@gmail.com','8698-5728', '02/03/2023');



CREATE TABLE `foro` (
`id` int(20) NOT NULL AUTO_INCREMENT,
`autor` varchar(50) NOT NULL,
`titulo` varchar(100) NOT NULL,
`mensaje` varchar (500) NOT NULL,
PRIMARY KEY (`id`)
);





