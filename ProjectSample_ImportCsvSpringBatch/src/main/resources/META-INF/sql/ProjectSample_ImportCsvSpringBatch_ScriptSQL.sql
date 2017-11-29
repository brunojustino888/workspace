/*==============================================================*/
/* INTERNAL CONTEXT                                             */
/*==============================================================*/

drop index INTERNALSERVICES_PK;
drop table INTERNALSERVICES;

/*==============================================================*/
/* Table: INTERNALSERVICES                                      */
/*==============================================================*/
create table INTERNALSERVICES (
   ID_FORNECEDOR        VARCHAR(10)          not null,
   ID_SERVICO           VARCHAR(10)          not null,
   DESC_SERVICO         VARCHAR(40)          not null,
   LOCALIDADE           VARCHAR(40)          not null,
   VALOR                MONEY                not null,
   SIGLA_MOEDA          VARCHAR(5)           not null,
   DATA_ATUALIZACAO     DATE                 not null,
   constraint PK_INTERNALSERVICES primary key (ID_FORNECEDOR)
);

/*==============================================================*/
/* Index: INTERNALSERVICES_PK                                   */
/*==============================================================*/
create unique index INTERNALSERVICES_PK on INTERNALSERVICES (
ID_FORNECEDOR
);

/*==============================================================*/
/* EXTERNAL CONTEXT                                             */
/*==============================================================*/

drop index EXTERNALSERVICES_PK;
drop table EXTERNALSERVICES;

/*==============================================================*/
/* Table: EXTERNALSERVICES                                      */
/*==============================================================*/
create table EXTERNALSERVICES (
   ID_SERVICO           VARCHAR(10)          not null,
   DESC_SERVICO         VARCHAR(5)           not null,
   LOCALIDADE           VARCHAR(40)          not null,
   VALOR                MONEY                not null,
   SIGLA_MOEDA          VARCHAR(4)           not null,
   constraint PK_EXTERNALSERVICES primary key (ID_SERVICO)
);

/*==============================================================*/
/* Index: EXTERNALSERVICES_PK                                   */
/*==============================================================*/
create unique index EXTERNALSERVICES_PK on EXTERNALSERVICES (
ID_SERVICO
);