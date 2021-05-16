CREATE TABLE IF NOT EXISTS cliente (
	id serial PRIMARY KEY,
	nome varchar(50),
	cpf varchar(11),
	telefone varchar(13),
	endereco varchar(100),
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(45),
	pagamento varchar(20)
);