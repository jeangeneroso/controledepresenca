-- Cadastro de Operações
INSERT INTO operacao (nome_operacao) VALUES ('Operação Padrão');
INSERT INTO operacao (nome_operacao) VALUES ('Operação Atendimento SAC');
INSERT INTO operacao (nome_operacao) VALUES ('Operação Retenção');
INSERT INTO operacao (nome_operacao) VALUES ('Operação Backoffice');
INSERT INTO operacao (nome_operacao) VALUES ('Operação Vendas');

-- Cadastro de Líderes (vinculados às operações pelos IDs 1, 2, 3, 4 e 5)
INSERT INTO lider (nome_lider, rg_lider, cpf_lider, chave_pix, operacao_id) VALUES ('Líder Teste', '123456', '12345678900', 'pix@teste.com', 1);
INSERT INTO lider (nome_lider, rg_lider, cpf_lider, chave_pix, operacao_id) VALUES ('Ana Souza', '987654', '98765432100', 'ana.souza@email.com', 2);
INSERT INTO lider (nome_lider, rg_lider, cpf_lider, chave_pix, operacao_id) VALUES ('Carlos Roberto', '456123', '45678912344', '11999999999', 3);
INSERT INTO lider (nome_lider, rg_lider, cpf_lider, chave_pix, operacao_id) VALUES ('Mariana Costa', '789321', '32165498711', 'mari.pix@email.com', 4);
INSERT INTO lider (nome_lider, rg_lider, cpf_lider, chave_pix, operacao_id) VALUES ('Ricardo Alves', '159753', '75315945622', 'ricardo.alves@email.com', 5);