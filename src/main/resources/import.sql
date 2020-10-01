INSERT INTO empresa (id, nombre, endpoint, estado, code) VALUES (1, 'Universidad Francisco de Paula Santander', 'http://siaweb.ufps.edu.co/prueba.php', 1, 'ufps');
INSERT INTO empresa (id, nombre, endpoint, estado, code) VALUES (2, 'Universidad Simon Bolivar', 'http://siaweb.ufps.edu.co/unisimon.php', 1, 'unisimon');

INSERT INTO tipo (id, descripcion, empresa) VALUES (1, 'Docente', 1);
INSERT INTO tipo (id, descripcion, empresa) VALUES(2, 'Estudiante', 1);
INSERT INTO tipo (id, descripcion, empresa) VALUES(3, 'Administrativo', 1);
INSERT INTO tipo (id, descripcion, empresa) VALUES(4, 'Contratista', 1);
INSERT INTO tipo (id, descripcion, empresa) VALUES(5, 'Profesor', 2);
INSERT INTO tipo (id, descripcion, empresa) VALUES(6, 'Estudiante', 2);
INSERT INTO tipo (id, descripcion, empresa) VALUES(7, 'Adminsitrativo', 2);

INSERT INTO rol (id, descripcion) VALUES(1, 'Administrador');
INSERT INTO rol (id, descripcion) VALUES(2, 'Usuario');