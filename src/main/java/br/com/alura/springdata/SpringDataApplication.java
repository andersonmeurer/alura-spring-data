package br.com.alura.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.ICargoRepository;
import br.com.alura.springdata.service.CrudCargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudCargoService service;

	public SpringDataApplication(CrudCargoService service) {
		this.service = service;
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

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				service.inicial(scanner);
				break;

			default:
				System.exit(0);
				break;
			}
		} while (true);
	}
}