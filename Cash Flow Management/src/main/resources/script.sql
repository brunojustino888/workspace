CREATE TABLE `employee` (                                
`id` int(11) NOT NULL AUTO_INCREMENT,                  
`emp_name` varchar(100) DEFAULT NULL,                  
`emp_address` varchar(500) DEFAULT NULL,               
`emp_mobile_nos` varchar(100) DEFAULT NULL,            
PRIMARY KEY (`id`)                                     
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/* CASH FLOW MANAGEMENT - SCRIPT SQL */

CREATE SCHEMA `cashflowmanagementdb` ;
SET @@global.time_zone = '+3:00';
SET time_zone='America/Sao_Paulo';
/* Tabela CLIENTE */
DROP TABLE CLIENTE;
CREATE TABLE CLIENTE 
(
	COD							bigint auto_increment not null primary key,
	NOME   						varchar(100) not null, 
	DOCUMENTO 					varchar(30),
	TELEFONE					varchar(30),
	EMAIL 						varchar(100),
	RAMO_ATIVIDADE  			varchar(50),
	ULTIMA_ATUALIZACAO   		date not null,
	USUARIO_ULTIMA_ATUALIZACAO  varchar(100) not null,
	USUARIO_CRIACAO      		varchar(100),
	DATA_CRIACAO         		date
);
INSERT INTO CLIENTE (NOME, DOCUMENTO, TELEFONE, EMAIL, RAMO_ATIVIDADE, ULTIMA_ATUALIZACAO, USUARIO_ULTIMA_ATUALIZACAO, USUARIO_CRIACAO, DATA_CRIACAO) VALUES ("Bruno Alves Justino", "CPF: 374.608.248-01", "+55 (11) 4376-0362", "brunojustino888@gmail.com", "Programador", CURDATE(), "brunojustino888", "brunojustino888", CURDATE());
SELECT * FROM CLIENTE;

/* Tabela ENDERECO */
CREATE TABLE ENDERECO 
(
   COD                  		bigint auto_increment not null primary key,
   CLIENTE_COD         		 	bigint not null,
   LOGRADOURO          			varchar(1024) not null,
   NUMERO              			int not null,
   CEP	                 		varchar(10) not null,
   ENDERECO_PRINCIPAL      		bool not null,
   BAIRRO		           		varchar(20) not null,
   CIDADE		           		varchar(20) not null,
   ESTADO						varchar(10) not null,
   PAIS							varchar(10) not null,
   REFERENCIA	           		varchar(1024) not null,
   ULTIMA_ATUALIZACAO   		date not null,
   USUARIO_ULTIMA_ATUALIZACAO   varchar(100) not null,
   USUARIO_CRIACAO      		varchar(100),
   DATA_CRIACAO         		date,
   FOREIGN KEY (CLIENTE_COD) REFERENCES CLIENTE(COD)
);
INSERT INTO ENDERECO (CLIENTE_COD, LOGRADOURO, NUMERO, CEP, ENDERECO_PRINCIPAL, BAIRRO, CIDADE, ESTADO, PAIS, REFERENCIA, ULTIMA_ATUALIZACAO, USUARIO_ULTIMA_ATUALIZACAO, USUARIO_CRIACAO, DATA_CRIACAO) VALUES (1, "Rua Sāo Luiz","200","06226-210", TRUE, "Rochdale", "Osasco", "SP", "Brasil", "Travessa da avenida Cruziro do Sul", CURDATE(), "brunojustino888", "brunojustino888", CURDATE());
SELECT * FROM ENDERECO;

/* Tabela LANCAMENTO */
DROP TABLE LANCAMENTO;
CREATE TABLE LANCAMENTO 
(
   COD                  		bigint auto_increment not null primary key,
   CLIENTE_COD         		 	bigint not null,
   DESCRICAO           			varchar(1024) not null,
   VALOR               			decimal(10,2) not null,
   TIPO                 		varchar(10) not null,
   PAGO                 		bool,
   VENCIMENTO           		date,
   DATA_PAGAMENTO       		date,
   ULTIMA_ATUALIZACAO   		date not null,
   USUARIO_ULTIMA_ATUALIZACAO   varchar(100) not null,
   USUARIO_CRIACAO      		varchar(100),
   DATA_CRIACAO         		date,
   FOREIGN KEY (CLIENTE_COD) REFERENCES CLIENTE(COD)
);
INSERT INTO LANCAMENTO (CLIENTE_COD, DESCRICAO, VALOR, TIPO, DATA_PAGAMENTO, ULTIMA_ATUALIZACAO, USUARIO_ULTIMA_ATUALIZACAO, USUARIO_CRIACAO, DATA_CRIACAO) VALUES (1, "Dinheiro encontrado na rua", 13.02, "RECEITA", CURDATE(), CURDATE(), "brunojustino888", "brunojustino888", CURDATE());
INSERT INTO LANCAMENTO (CLIENTE_COD, DESCRICAO, VALOR, TIPO, PAGO, VENCIMENTO, DATA_PAGAMENTO, ULTIMA_ATUALIZACAO, USUARIO_ULTIMA_ATUALIZACAO, USUARIO_CRIACAO, DATA_CRIACAO) VALUES (1, "Dinheiro gasto com nada", 10.00, "DESPESA", FALSE, CURDATE(), CURDATE(), CURDATE(), "brunojustino888", "brunojustino888", CURDATE());       
INSERT INTO LANCAMENTO (CLIENTE_COD, DESCRICAO, VALOR, TIPO, DATA_PAGAMENTO, ULTIMA_ATUALIZACAO, USUARIO_ULTIMA_ATUALIZACAO, USUARIO_CRIACAO, DATA_CRIACAO) VALUES (1, "Investimento em moeda digital litecoin", 10.00, "INVESTIMENTO", CURDATE(), CURDATE(), "brunojustino888", "brunojustino888", CURDATE());       
INSERT INTO LANCAMENTO (CLIENTE_COD, DESCRICAO, VALOR, TIPO, PAGO, VENCIMENTO, DATA_PAGAMENTO, ULTIMA_ATUALIZACAO, USUARIO_ULTIMA_ATUALIZACAO, USUARIO_CRIACAO, DATA_CRIACAO) VALUES (1,"Despesa com o homen invisísel" , 0.01, "DESPESA", TRUE, CURDATE(), CURDATE(), CURDATE(), "brunojustino888", "brunojustino888", CURDATE());
SELECT * FROM LANCAMENTO;