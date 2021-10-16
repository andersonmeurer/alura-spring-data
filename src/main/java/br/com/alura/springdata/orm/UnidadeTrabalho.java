package br.com.alura.springdata.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "unidade_trabalho")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UnidadeTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private String endereco;

	@ManyToMany(mappedBy = "listUnidadesDeTrabalho", fetch = FetchType.EAGER)
	private List<Funcionario> listFuncionarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Funcionario> getFuncionarios() {
		return listFuncionarios;
	}

	public void setFuncionarios(List<Funcionario> list) {
		this.listFuncionarios = list;
	}

	@Override
	public String toString() {
		return "UnidadeTrabalho [id=" + id + ", descricao=" + descricao + ", endereco=" + endereco + "]";
	}
}