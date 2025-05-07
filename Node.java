// arquivo: src/apl2/Node.java

// TODO: Colocar a identificação dos(as) integrantes aqui.



// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

/*
Nome:Alef de souza Iima
RA:10431891
-------------------------------
Nome:Derick Sant’Ana Nascimento
RA:10443727
-------------------------------
Nome:Renan Horochk de Andrade
RA:10438120
-------------------------------
Nome:Ryan Vinicius Ledo
RA:10352727
 */

import java.time.LocalDate;

public class Node {
	private String id;
	private String nome;
	private float nota;
	private Node next;
	private Node ant;

	// construtores
	public Node() {
		this(1, " ", 0.0f, null, null);  // Usa semestre = 1 e oldId = 0 como padrão
	}

	public Node(String id, String nome, float nota) {
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}
	
	
	public Node(int oldId, String nome,float notaPessoal,Node next, Node ant) {
		LocalDate dataAtual = LocalDate.now();
	int ano = dataAtual.getYear();
	int mes = dataAtual.getMonthValue();
		int sem;
		if(mes <= 6){
			sem = 1;
		}else{
			sem = 2;
		}
		String idFinish = ano + ".S" + sem + "-" + oldId;
		this.id = idFinish;
		this.nome = nome;
		this.nota = notaPessoal;
		this.next = next;
		this.ant = ant;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	
	public float getNota() {
		return nota;
	}


	public void setNota(float nota) {
		this.nota = nota;
	}

	public String getID() {
		return id;
	}

	public void setID(int ID) {
		LocalDate dataAtual = LocalDate.now();
		int ano = dataAtual.getYear();
	int mes = dataAtual.getMonthValue();
	int sem;
		if(mes <= 6){
			sem = 1;
		}else{
			sem = 2;
		}
		String idFinish = ano + ".S" + sem + "-" + ID;
		this.id = idFinish;
	}

	public void setID(String ID) {
		
		this.id = ID;
	}

	
	// metodos para andar entre os nos
	public Node getNext() {
		return next;
	}

	public Node getAnt() {
		return ant;
	}


	public void setNext(Node next) {
		this.next = next;
	}

	public void setAnt(Node ant) {
		this.ant = ant;
	}

	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.
	// FAZER O TO STRING DO NODE
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
			sb.append("(")
			.append(getID())
			.append(" # ")
			.append(getNome())
			.append(" # ")
			.append(getNota())
			.append(") -> \n");
		
		return sb.toString();
	}

}