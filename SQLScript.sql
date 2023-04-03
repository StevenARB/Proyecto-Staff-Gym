CREATE DATABASE staffgym;
use staffgym;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido1` varchar(45) NOT NULL,
  `apellido2` varchar(45) NOT NULL,
  `cedula` varchar(11) NOT NULL,
  `email` varchar(75) DEFAULT NULL,
  `telefono` varchar(9) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ;

INSERT INTO `usuarios` VALUES (1,'Luis','Guerrero','Mora','1-9880-7590','luisgm98@gmail.com','8989-9090', '10/03/2023');
INSERT INTO `usuarios` VALUES (2,'Bryan','Mora','Quesada','1-6425-3637','brmoque123@gmail.com','7478-5678', '10/03/2023');
INSERT INTO `usuarios` VALUES (3,'María','Flores','Miranda','1-8612-8852','marflomi32@gmail.com','2565-0925', '10/03/2023');

ALTER TABLE `usuarios`(
  `password` varchar(255) NOT NULL,
  `permissions` varchar(45) NOT NULL,
  `roles` varchar(45) NOT NULL,
  `active` INT NOT NULL,
  );
