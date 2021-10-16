package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.service.CrudCargoService;
import br.com.alura.springdata.service.CrudFuncionarioService;
import br.com.alura.springdata.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService serviceC;
	public static CrudUnidadeTrabalhoService serviceUT;
	private final CrudFuncionarioService funcionarioService;

	public SpringDataApplication(CrudCargoService serviceC, CrudUnidadeTrabalhoService serviceUT, CrudFuncionarioService funcionarioService) {
		this.serviceC = serviceC;
		this.serviceUT = serviceUT;
		this.funcionarioService = funcionarioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Qual opcao voce deseja executar");
			System.out.println("0 - sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Unidade de Trabalho");
			System.out.println("3 - Funcionarios");

			int action = scanner.nextInt();
			switch (action) {
			case 1: serviceC.inicial(scanner);				break;
			case 2: serviceUT.inicial(scanner); 			break;
			case 3: funcionarioService.inicial(scanner); 	break;

			default:
				System.exit(0);
				break;
			}
		} while (true);
	}
}