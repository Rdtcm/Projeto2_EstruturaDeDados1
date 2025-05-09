// arquivo: src/apl2/DLinkedList.java

// TODO: Colocar a identificação dos(as) integrantes aqui.


// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

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

public class DLinkedList {
	
	private Node head;
	private Node tail;
	private int count;

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	

// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(Node node) {
		if (isEmpty()) {
			head = tail = node;
		} else {
			node.setNext(head);
			head.setAnt(node);
			head = node;
		}
		count++;
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(Node node) {
	    if (isEmpty()) { 
	        head = tail = node;
	    } else { // Lista não está vazia
	        node.setAnt(tail);
			tail.setNext(node);
			tail = node;
	    }
	    count++; // Incrementa o contador
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		if (isEmpty()) return null;

		Node aux = head;

		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
			head.setAnt(null);

		}
		count--;
		aux.setNext(null);
		aux.setAnt(null);
		return aux;
	}
	


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		if (isEmpty()) return null;

		Node aux = tail;

		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.getAnt();
			tail.setNext(null);

		}
		count--;
		aux.setNext(null);
		aux.setAnt(null);
		return aux;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {
		Node node = getNode(id);

		if (node == null || isEmpty()) return null;

		if (node == head) return removeHead();
		if (node == tail) return removeTail();

		Node anterior = node.getAnt();
		Node proximo = node.getNext();

		anterior.setNext(proximo);
		proximo.setAnt(anterior);
		count--;

		return node;
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		if (! isEmpty()) return head;
		else return null;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		if (! isEmpty()) return tail;
		else return null;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		Node node = head;

		while (node != null) {
			if (node.getID().equals(id)) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		return count;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		return head == null; // || tail == null;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		head = tail = null;
		count = 0;
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		LocalDate dataAtual = LocalDate.now();
	int ano = dataAtual.getYear();
	ano = ano - 2000;
	int mes = dataAtual.getMonthValue();
	int sem;
		if(mes <= 6){
			sem = 1;
		}else{
			sem = 2;
		}
		sb.append("(" + count + ") \n");
		
		Node node = head;
		while (node != null) {
			sb.append("(")
			.append(ano)
			.append(".S")
			.append(sem)
			.append(node.getID())
			.append(";")
			.append(node.getNome())
			.append(";")
			.append(node.getNota())
			.append(") -> \n");
			node  = node.getNext();
		}
		sb.append("null.");
		
		return sb.toString();
	}
}

