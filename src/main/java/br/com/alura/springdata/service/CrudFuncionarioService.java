package br.com.alura.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.alura.springdata.SpringDataApplication;
import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.UnidadeTrabalho;
import br.com.alura.springdata.repository.ICargoRepository;
import br.com.alura.springdata.repository.IFuncionarioRepository;
import br.com.alura.springdata.repository.IUnidadeTrabalhoRepository;

@Service
public class CrudFuncionarioService {

	private final IFuncionarioRepository fRepository;
	private final ICargoRepository cRepository;
	private final IUnidadeTrabalhoRepository utRepository;

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public CrudFuncionarioService(IFuncionarioRepository fRepository, ICargoRepository cRepository,
			IUnidadeTrabalhoRepository utRepository) {
		this.fRepository = fRepository;
		this.cRepository = cRepository;
		this.utRepository = utRepository;
	}

	public void inicial(Scanner scanner) {
		boolean continuar = true;
		do {
			System.out.println("Funcionario -> Qual opcao voce deseja executar");
			System.out.println("0 - Exit");
			System.out.println("1 - Insert");
			System.out.println("2 - Update");
			System.out.println("3 - Show All");
			System.out.println("4 - Delete");

			int action = scanner.nextInt();

			switch (action) {
				case 1: insert(scanner);	break;
				case 2: update(scanner);	break;
				case 3: findAll(scanner);	break;
				case 4: delete(scanner);	break;
				default: continuar = false;	break; 
			}
		} while (continuar);
	}

	private void delete(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		Funcionario f = fRepository.findById(id).get();
		fRepository.deleteById(f.getId());
		System.out.println(f.getNome() + " Deletado!");
	}

	private void findAll(Scanner scanner) {
		System.out.println("Qual pagina voce deseja visualizar?");
		Integer nrPagina = scanner.nextInt();

		Pageable pageable = PageRequest.of(nrPagina, 5, Sort.unsorted());
		Page<Funcionario> list = fRepository.findAll(pageable);

		System.out.println(list);
		System.out.println("Pagina atual: " + list.getNumber());
		System.out.println("Total elementos: " + list.getTotalElements());
		list.forEach(obj -> System.out.println(obj));
	}

	private void update(Scanner scanner) {
		Funcionario funcionario = new Funcionario();

        System.out.println("Digite o id");
        funcionario.setId(scanner.nextInt());

        loadFuncionario(scanner, funcionario);

        System.out.println("Digite o cargoId");
        Optional<Cargo> cargo = cRepository.findById(scanner.nextInt());
        funcionario.setCargo(cargo.get());

        fRepository.save(funcionario);
        System.out.println(funcionario.getNome()+ " Alterado!");
	}

	private void insert(Scanner scanner) {


        Funcionario funcionario = new Funcionario();

        loadFuncionario(scanner, funcionario);
        System.out.println("Digite o cargoId:");
        
        Optional<Cargo> cargo = cRepository.findById(scanner.nextInt());
        funcionario.setCargo(cargo.get());

        List<UnidadeTrabalho> unidades = SpringDataApplication.serviceUT.unidade(scanner);
        funcionario.setUnidadeTrabalho(unidades);

        fRepository.save(funcionario);
        System.out.println(funcionario.getNome() + " Salvo!");
	}

	private void loadFuncionario(Scanner scanner, Funcionario funcionario) {
		System.out.println("Digite o nome:");
        funcionario.setNome(scanner.next());

        System.out.println("Digite o cpf:");
        funcionario.setCpf(scanner.next());

        System.out.println("Digite o salario:");
        funcionario.setSalario(scanner.nextDouble());

        System.out.println("Digite a data de contracao:");
        funcionario.setDtContratacao(LocalDate.parse(scanner.next(), formatter));
	}
}