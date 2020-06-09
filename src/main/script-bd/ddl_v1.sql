-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE categoria (
id_categoria int auto_increment PRIMARY KEY,
nm_categoria varchar(60)
);

CREATE TABLE produto (
id_produto int auto_increment PRIMARY KEY,
id_categoria_fk int,
nm_produto varchar(100),
vl_produto float(5,2),
FOREIGN KEY(id_categoria_fk) REFERENCES categoria (id_categoria)
);

CREATE TABLE lista_produto (
id_produto int,
id_pedido int,
qtd_produto int,
vl_subtotal float(5,2),
PRIMARY KEY(id_produto,id_pedido),
FOREIGN KEY(id_produto) REFERENCES produto (id_produto)
);

CREATE TABLE pedido (
id_pedido int auto_increment PRIMARY KEY,
dt_pedido date,
dt_entrega date,
id_cliente_fk int
);

CREATE TABLE cliente (
id_cliente int auto_increment PRIMARY KEY,
nm_cliente varchar(100),
end_cliente varchar(200),
telefone varchar(14)
);

ALTER TABLE lista_produto ADD FOREIGN KEY(id_pedido) REFERENCES pedido (id_pedido);
ALTER TABLE pedido ADD FOREIGN KEY(id_cliente_fk) REFERENCES cliente (id_cliente);
