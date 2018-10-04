DROP SEQUENCE IF EXISTS PUBLIC.SEQ_USUARIO;
DROP SEQUENCE IF EXISTS PUBLIC.SEQ_SALA;
DROP SEQUENCE IF EXISTS PUBLIC.SEQ_AUTHORITIES;
DROP SEQUENCE IF EXISTS PUBLIC.SEQ_RESERVA;
DROP TABLE IF EXISTS PUBLIC.AUTHORITIES;
DROP TABLE IF EXISTS PUBLIC.USUARIO;
DROP TABLE IF EXISTS PUBLIC.RESERVA;
DROP TABLE IF EXISTS PUBLIC.SALA;

;
CREATE USER IF NOT EXISTS SA SALT 'ec84e143ecc50e5b' HASH 'f78351aa065d8562a9c22fb62be894ece5d97b7115b0a3028af87b7b29cfc88e' ADMIN;           
CREATE SEQUENCE PUBLIC.SEQ_USUARIO START WITH 4;              
CREATE SEQUENCE PUBLIC.SEQ_SALA START WITH 3; 
CREATE SEQUENCE PUBLIC.SEQ_AUTHORITIES START WITH 4;          
CREATE SEQUENCE PUBLIC.SEQ_RESERVA START WITH 3;              
CREATE CACHED TABLE PUBLIC.AUTHORITIES(
    ID BIGINT NOT NULL,
    AUTHORITY VARCHAR(255),
    USUARIO_ID BIGINT
);      
ALTER TABLE PUBLIC.AUTHORITIES ADD CONSTRAINT PUBLIC.CONSTRAINT_A PRIMARY KEY(ID);            
   
CREATE CACHED TABLE PUBLIC.RESERVA(
    ID BIGINT NOT NULL,
    FECHAFINAL TIMESTAMP,
    FECHAINICIAL TIMESTAMP,
    SALA_ID BIGINT,
    USUARIO_ID BIGINT
);          
ALTER TABLE PUBLIC.RESERVA ADD CONSTRAINT PUBLIC.CONSTRAINT_6 PRIMARY KEY(ID);
         
CREATE CACHED TABLE PUBLIC.SALA(
    ID BIGINT NOT NULL,
    AFOROMAX INTEGER NOT NULL,
    NOMBRE VARCHAR(255)
);        
ALTER TABLE PUBLIC.SALA ADD CONSTRAINT PUBLIC.CONSTRAINT_2 PRIMARY KEY(ID);   

CREATE CACHED TABLE PUBLIC.USUARIO(
    ID BIGINT NOT NULL,
    EMAIL VARCHAR(255),
    NOMBRE VARCHAR(255),
    NUM_TLF VARCHAR(255),
    PASS VARCHAR(255),
    VALIDADO BOOLEAN NOT NULL
);         
ALTER TABLE PUBLIC.USUARIO ADD CONSTRAINT PUBLIC.CONSTRAINT_22 PRIMARY KEY(ID);