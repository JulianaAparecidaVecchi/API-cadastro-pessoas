-- V2: Migrations para adicionar a coluna mother_name na tabela person

ALTER TABLE person
ADD COLUMN mother_name VARCHAR(255);