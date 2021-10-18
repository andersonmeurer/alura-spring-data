package br.com.alura.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.repository.IFuncionarioRepository;
import br.com.alura.springdata.specification.SpecificatioFuncionario;

@Service
public class RelatorioFuncionarioDinamico {

	private final IFuncionarioRepository fRepository;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public RelatorioFuncionarioDinamico(IFuncionarioRepository fRepository) {
		this.fRepository = fRepository;
	}

	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome:");
		String nome = scanner.next();
		if(nome.equalsIgnoreCase("null")) {
			nome = null;
		}

		System.out.println("Digite o cpf:");
		String cpf = scanner.next();
		if(cpf.equalsIgnoreCase("null")) {
			cpf = null;
		}
		
		System.out.println("Digite o salario:");
		Double salario = scanner.nextDouble();
		if(salario== 0) {
			salario = null;
		}
		
		System.out.println("Digite o data de contratacao:");
		String data = scanner.next();
		LocalDate dataContratacao = null;
		if(data.equalsIgnoreCase("null")) {
			data= null;
		} else {
			dataContratacao = LocalDate.parse(data, formatter);
		}
 
		List<Funcionario> list = fRepository.findAll(Specification
				.where(
						SpecificatioFuncionario.nome(nome))
						.or(SpecificatioFuncionario.cpf(cpf))
						.or(SpecificatioFuncionario.salario(salario))
						.or(SpecificatioFuncionario.dataContratacao(dataContratacao))
				);
		list.forEach(System.out::println);
	}
}