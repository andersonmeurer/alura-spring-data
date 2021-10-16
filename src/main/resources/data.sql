INSERT INTO alura.cargos (descricao) VALUES('Desenvolvedor');
INSERT INTO alura.cargos (descricao) VALUES('Analista de Sistemas');
INSERT INTO alura.cargos (descricao) VALUES('Web Developer');
INSERT INTO alura.cargos (descricao) VALUES('BackEnd Developer');

INSERT INTO alura.unidade_trabalho (descricao, endereco) VALUES('Empresa Teste1', 'Rua Teste1');
INSERT INTO alura.unidade_trabalho (descricao, endereco) VALUES('Empresa Teste2', 'Rua Teste2');

INSERT INTO alura.funcionarios (cpf, dt_contratacao, nome, salario, cargo_id) VALUES('12345678910', '2012-10-15', 'Anderson', 1000.0, 2);
																					
INSERT INTO alura.funcionarios_unidades (fk_funcionario, fk_unidade) VALUES(1, 1);
INSERT INTO alura.funcionarios_unidades (fk_funcionario, fk_unidade) VALUES(1, 2);
