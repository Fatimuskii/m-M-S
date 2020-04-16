CREATE TABLE producto (
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL,
	precio FLOAT NOT NULL,
	stock INT NOT NULL,
	activo BIT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE cliente (
	idCliente INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	DNI VARCHAR(30) NOT NULL,
	telefono VARCHAR(30) NOT NULL,
	email VARCHAR(100) NOT NULL,
	activo BIT NOT NULL,
	PRIMARY KEY (idCliente)
);

CREATE TABLE juegoDeMesa (
	id INT NOT NULL,
	edadRecomendada INT NOT NULL,
	numJugadores INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE merchandising (
	id INT NOT NULL,
	tipo VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE venta (
	idVenta INT NOT NULL AUTO_INCREMENT,
	idCliente INT NOT NULL REFERENCES cliente(idCliente),
	fecha DATE NOT NULL,
	precioTotal FLOAT NOT NULL,
	activo BOOLEAN NOT NULL,
	PRIMARY KEY (idVenta)
);

CREATE TABLE lineaVenta (
	idVenta INT NOT NULL REFERENCES venta(idVenta),
	idProducto INT NOT NULL REFERENCES producto(id),
	cantidad INT NOT NULL,
	precioTotal_prod FLOAT NOT NULL,
	PRIMARY KEY (idVenta,idProducto)
);

ALTER TABLE juegoDeMesa ADD CONSTRAINT juegoDeMesa_FK FOREIGN KEY (id)
	REFERENCES producto (id)
	ON DELETE CASCADE;

ALTER TABLE merchandising ADD CONSTRAINT merchandising_FK FOREIGN KEY (id)
	REFERENCES producto (id)
	ON DELETE CASCADE;

ALTER TABLE venta ADD CONSTRAINT idCliente_FK FOREIGN KEY (idCliente)
	REFERENCES cliente (idCliente)
	ON DELETE CASCADE;

ALTER TABLE lineaVenta ADD CONSTRAINT idVenta_FK FOREIGN KEY (idVenta)
	REFERENCES venta (idVenta)
	ON DELETE CASCADE;
	
ALTER TABLE lineaVenta ADD CONSTRAINT idProd_FK FOREIGN KEY (idProducto)
	REFERENCES producto (id)
	ON DELETE CASCADE;