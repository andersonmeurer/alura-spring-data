INSERT INTO alura.cargos (descricao) VALUES('Developer');
INSERT INTO alura.cargos (descricao) VALUES('Systems Analyst');
INSERT INTO alura.cargos (descricao) VALUES('Web Developer');
INSERT INTO alura.cargos (descricao) VALUES('BackEnd Developer');

INSERT INTO alura.unidade_trabalho (descricao, endereco) VALUES('Company Test1', 'Road Test1');
INSERT INTO alura.unidade_trabalho (descricao, endereco) VALUES('Company Test2', 'Road Test2');

INSERT INTO alura.funcionarios (cpf, dt_contratacao, nome, salario, cargo_id) VALUES('12345678910', '2012-10-15', 'Anderson', 1000.0, 2);
																					
INSERT INTO alura.funcionarios_unidades (fk_funcionario, fk_unidade) VALUES(1, 1);
INSERT INTO alura.funcionarios_unidades (fk_funcionario, fk_unidade) VALUES(1, 2);
