-- 2 +/- SELECT COUNT(*) FROM PUBLIC.AUTHORITIES;             
INSERT INTO PUBLIC.AUTHORITIES(AUTHORITY, EMAIL) VALUES
('ROLE_USUARIO', 1),
('ROLE_ADMIN', 2);

-- 2 +/- SELECT COUNT(*) FROM PUBLIC.USUARIO; 
INSERT INTO PUBLIC.USUARIO(ID, EMAIL, NOMBRE, NUM_TLF, PASS, VALIDADO) VALUES
(1, 'usuario@usuario.com', 'Usuario', '111222333', '$2a$04$Kl8L17nXNhC1Rfr/z2aGjuo8XOQUVS.ZYUcHdDUOVX26XN1ru263G', TRUE),
(2, 'admin@admin.com', 'Admin', '444555666', '$2a$04$r8Ar8dyS0gfybPUSg825aOZYg4/41vXwcvQGVe5.bOCOxyQh1I3eu', TRUE);

ALTER TABLE PUBLIC.USUARIO ADD CONSTRAINT PUBLIC.UK_5NXBP92JYGM8O49SPMBREVXE1 UNIQUE(NUM_TLF);
ALTER TABLE PUBLIC.USUARIO ADD CONSTRAINT PUBLIC.UK_7BVKHIRWL95XJ8QV4PFNTCQP2 UNIQUE(EMAIL);  
ALTER TABLE PUBLIC.AUTHORITIES ADD CONSTRAINT PUBLIC.FK1ENLPXKHYM2T6WMLMM07M5SE8 FOREIGN KEY(EMAIL) REFERENCES PUBLIC.USUARIO(ID) NOCHECK;    
ALTER TABLE PUBLIC.RESERVA ADD CONSTRAINT PUBLIC.FKOHJG86HQ57XFUCUDKQEESG841 FOREIGN KEY(SALA_ID) REFERENCES PUBLIC.SALA(ID) NOCHECK;         
ALTER TABLE PUBLIC.RESERVA ADD CONSTRAINT PUBLIC.FKKRXQWQVEWD2PLS5TDIGWQPRJ2 FOREIGN KEY(USUARIO_ID) REFERENCES PUBLIC.USUARIO(ID) NOCHECK;   