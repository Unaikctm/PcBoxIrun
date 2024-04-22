DROP TABLE IF EXISTS lineapedido;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS reparacion;
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    DNI VARCHAR(9) NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Apellido VARCHAR(30) NOT NULL,
    Direccion VARCHAR(50) NOT NULL,
    CodigoPostal INT NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Telefono INT NOT NULL
);

CREATE TABLE reparacion (
    ID INT NOT NULL,
    Tipo VARCHAR(20) NOT NULL,
    Descripcion VARCHAR(90) NOT NULL,
    Horas INT NOT NULL,
    Precio DECIMAL(5,2) NOT NULL,
    DNI_CLIENTE VARCHAR(9) NOT NULL
);

CREATE TABLE pedido (
    ID INT NOT NULL,
    Fecha DATE NOT NULL,
    DNI_Cliente VARCHAR(9) NOT NULL
);

CREATE TABLE producto (
    ID INT NOT NULL,
    Nombre VARCHAR(50) NOT NULL,
    Tipo VARCHAR(50) NOT NULL,
    Marca VARCHAR(15) NOT NULL,
    Precio DECIMAL(6,2) NOT NULL,
    Stock INT NOT NULL
);

CREATE TABLE lineapedido (
    ID_Pedido INT NOT NULL,
    ID_Producto INT NOT NULL,
    Cantidad INT NOT NULL
);

CREATE TABLE factura (
    ID INT NOT NULL,
    Fecha DATE NOT NULL,
    Total DECIMAL(5,2) NOT NULL,
    Pagado CHAR(2) NOT NULL,
    Tipo_Factura VARCHAR(20) NOT NULL
);

-- Primary Keys
ALTER TABLE cliente ADD PRIMARY KEY (DNI);
ALTER TABLE reparacion ADD PRIMARY KEY (ID);
ALTER TABLE pedido ADD PRIMARY KEY (ID);
ALTER TABLE producto ADD PRIMARY KEY (ID);
ALTER TABLE lineapedido ADD PRIMARY KEY (ID_Pedido, ID_Producto);
ALTER TABLE factura ADD PRIMARY KEY (ID, Tipo_Factura);

-- Auto-increments
ALTER TABLE producto MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE pedido MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE reparacion MODIFY ID INT AUTO_INCREMENT;
ALTER TABLE factura MODIFY ID INT AUTO_INCREMENT;

-- Foreign Keys
ALTER TABLE reparacion ADD CONSTRAINT FK_Reparacion FOREIGN KEY (DNI_CLIENTE)
    REFERENCES cliente(DNI);
ALTER TABLE pedido ADD CONSTRAINT FK_Pedido FOREIGN KEY (DNI_Cliente)
    REFERENCES cliente(DNI);
ALTER TABLE lineapedido ADD CONSTRAINT FK_LineaPedido FOREIGN KEY (ID_Pedido)
    REFERENCES pedido(ID);
ALTER TABLE lineapedido ADD CONSTRAINT FK_LineaPedido1 FOREIGN KEY (ID_Producto)
    REFERENCES producto(ID);
ALTER TABLE factura ADD CONSTRAINT FK_Factura FOREIGN KEY (ID)
    REFERENCES pedido(ID);
ALTER TABLE factura ADD CONSTRAINT FK_Factura2 FOREIGN KEY (ID)
    REFERENCES reparacion(ID);

-- Checks
ALTER TABLE factura ADD CHECK (Pagado IN ('Si', 'No'));
ALTER TABLE factura ADD CHECK (Tipo_Factura IN ('Pedido', 'Reparacion'));

-- Procedures
DELIMITER //

DROP PROCEDURE IF EXISTS Insertar_Pedido //
DROP PROCEDURE IF EXISTS Insertar_Reparacion //

CREATE PROCEDURE Insertar_Pedido (
    p_ID_Pedido INT,
    p_Fecha DATE,
    f_Total DECIMAL(5,2),
    p_DNI_Cliente VARCHAR(9)
)
BEGIN
    -- Insertar el pedido
    INSERT INTO pedido(ID, Fecha, DNI_Cliente)
    VALUES (p_ID_Pedido, p_Fecha, p_DNI_Cliente);
    
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (p_ID_Pedido, p_Fecha, f_Total, 'No', 'Pedido');

    COMMIT;
    SELECT CONCAT('Factura creada correctamente para el pedido ', p_ID_Pedido, ' de tipo pedido.') AS Message;
END//

CREATE PROCEDURE Insertar_Reparacion (
    r_ID_Reparacion INT,
    r_Tipo VARCHAR(20),
    r_Descripcion VARCHAR(90),
    r_Horas INT,
    r_Precio DECIMAL(5,2),
    f_total DECIMAL(5,2),
    f_Fecha DATE,
    r_DNI_Cliente VARCHAR(9)
)
BEGIN
    -- Insertar la reparacion
    INSERT INTO reparacion(ID, Tipo, Descripcion, Horas, Precio, DNI_Cliente)
    VALUES (r_ID_Reparacion, r_Tipo, r_Descripcion, r_Horas, r_Precio, r_DNI_Cliente);
    
    -- Insertar la factura
    INSERT INTO factura(ID, Fecha, Total, Pagado, Tipo_Factura)
    VALUES (r_ID_Reparacion, f_Fecha, f_Total, 'No', 'Reparacion');

    COMMIT;
    SELECT CONCAT('Factura creada correctamente para la reparacion ', r_ID_Reparacion, ' de tipo reparacion.') AS Message;
END//

DELIMITER ;

INSERT INTO `cliente` (`DNI`, `Nombre`, `Apellido`, `Direccion`, `CodigoPostal`, `Email`, `Telefono`) VALUES
('21376754C', 'Asier', 'Manterola', 'Arbes Kalea, 18', 20304, 'mantequilla@gmail.com', 612095941),
('44577788E', 'Iñigo', 'Vicente', 'Av. Navarra, 15', 20035, 'hastalaproxima@gmail.com', 654421129),
('54647912K', 'Juan', 'Antero Asumu Azeme Efiri', 'Tolosa kalea, 2', 20302, 'naafiri@gmail.com', 602335837),
('76343784D', 'Beñat', 'Merino', 'Dario de Reboyos, 5', 20229, 'lujazo@gmail.com', 676676776),
('89211425L', 'Jagoba', 'Peruarena', 'Amute Kalea, 17', 20303, 'jperuvian@gmail.com', 634607848),
('90987654G', 'Xabier', 'Vacas', 'Av. Gipuzkoa, 5', 20300, 'ponytail32@gmail.com', 643326766);

INSERT INTO `producto`(`Nombre`, `Tipo`, `Marca`, `Precio`, `Stock`) VALUES
('GeForce RTX 4060 Ti OC 8GB GDD','Tarjeta gráfica','Asus',275.00,80),
('B760 GAMING PLUS WIFI','Placa base','MSI',154.99,150),
('Vengance RGB 8GB','Memoria RAM','Corsair',30.99,500),
('Ryzen 7 5800X 3.8GHz','Procesador','AMD',219.00,120),
('EXCERIA PLUS G3 2TB SSD M.2','Disco Duro SSD','Kioxia',105.99,340),
('Liquid Cooler 360 ARGB 360mm','Refrigeración Líquida','Tempest',134.99,175);