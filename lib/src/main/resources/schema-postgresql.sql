CREATE TABLE IF NOT EXISTS cliente (
	idCliente serial PRIMARY KEY,
	nome varchar(50),
	cpf varchar(11),
	telefone varchar(13),
	endereco varchar(100),
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(45)
);

CREATE TABLE IF NOT EXISTS produto (
	idProduto serial PRIMARY KEY,
	imgProduto varchar(200),
	nomeProduto varchar(50),
	descProduto varchar(100),
	valor decimal(7,2)
);

CREATE TABLE IF NOT EXISTS pedido (
	idPedido serial,
	idCliente serial,
	data date,
	hora time,
	pagamento varchar(20)
);

CREATE TABLE IF NOT EXISTS pedidoProduto (
	idPedido serial,
	idProduto serial,
	quantidade int
);

CREATE TABLE IF NOT EXISTS cliente (
	idCliente serial,
	nome varchar(50),
	cpf varchar(11),
	telefone varchar(13),
	endereco varchar(100),
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(45)
);

CREATE TABLE IF NOT EXISTS produto (
	idProduto serial,
	imgProduto varchar(200),
	nomeProduto varchar(50),
	descProduto varchar(100),
	valor decimal(7,2)
);

CREATE TABLE IF NOT EXISTS pedido (
	idPedido serial PRIMARY KEY,
	idCliente serial,
	data date,
	hora time,
	pagamento varchar(20),
	FOREIGN KEY (idCliente) REFERENCES cliente(idCliente)
);

CREATE TABLE IF NOT EXISTS pedidoProduto (
	idPedido serial,
	idProduto serial,
	quantidade int,
	FOREIGN KEY(idPedido) REFERENCES pedido(idPedido),
	FOREIGN KEY(idProduto) REFERENCES produto(idProduto)
);


ALTER TABLE produto
ALTER COLUMN valor TYPE numeric(4,2);

ALTER TABLE pedido
ALTER COLUMN idCliente TYPE int;