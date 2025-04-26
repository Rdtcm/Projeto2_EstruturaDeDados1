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

import java.time.Year;

public class Node {
	private String id;
	private String nome;
	private float nota;
	private Node next;
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


	

	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}


	public Node() {
		this(1, 0, " ", 0.0f, null);  // Usa semestre = 1 e oldId = 0 como padrão
	}
	
	
	public Node(int Semestre,int oldId,String nome,float notaPessoal,Node next) {
		int year = Year.now().getValue();
		String idFinish = year + ".S" + Semestre + "-" + oldId;
		this.id = idFinish;
		this.nome = nome;
		this.nota = notaPessoal;
		this.next = next;
	}
	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.

	

	
}