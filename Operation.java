
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// TODO: Colocar a identificação dos(as) integrantes aqui.
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

public class Operation {

	/**
	 * <p>Recebe como parâmetro uma lista encadeada do tipo {@code LinkedListOriginal}, sendo que os nós da lista estão
	 * populados com o conteúdo da base de dados original (conteúdo do arquivo dados.txt).</p>
	 * <p>A operação {@code map()} deve mapear os dados originais para uma lista encadeada do tipo {@code DLinkedList} e
	 * retornar a referência da {@code DLinkedList} que possui os dados mapeados para a nova estrutura usada pelo sistema de notas.</p>
	 * 
	 * @param original Base de dados original carregada em uma {@code LinkedListOriginal}.
	 * @return Uma nova {@code DLinkedList} que contém o mapeamento da coleção de dados {@code original} para a nova estrutura usada pelo sistema de notas. 
	 */
	public static DLinkedList map(final LinkedListOriginal original) {
		DLinkedList listaNew = new DLinkedList();
		int number = original.count();
		
		for(int i = 0 ; i < number  ;i++){
			Node inserir = new Node();
			NodeOriginal dadoAntigo = original.removeHead();
			inserir.setID(dadoAntigo.getId());
			inserir.setNome(dadoAntigo.getNome());
			float inteiro = dadoAntigo.getInteiro();
			float decimo = dadoAntigo.getDecimo();
			if(inteiro == -1 || decimo == -1){
				inserir.setNota(99.9f);
			}else{
				inserir.setNota(inteiro + ((decimo) * 0.1f));
			}
			listaNew.append(inserir);
			original.append(dadoAntigo.getId(), dadoAntigo.getNome(), dadoAntigo.getInteiro(), dadoAntigo.getDecimo());
		}
		return listaNew;
	}
	


	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveNonGraded()} deve filtrar os nós que não possuem notas válidas (caso de "ausência de nota")
	 * e retornar uma nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas válidas.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas válidas.
	 */
	public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
		DLinkedList listaNew = new DLinkedList();
		int number = data.count();

		for (int i = 0; i < number; i++) {
			Node dadoAntigo = data.removeHead();

			if (dadoAntigo.getNota() != 99.9f) {
				// Criando um novo nó com os mesmos dados
				Node inserir = new Node();
				inserir.setID(dadoAntigo.getID());
				inserir.setNome(dadoAntigo.getNome());
				inserir.setNota(dadoAntigo.getNota());

				listaNew.append(inserir);
			}

			// Recoloca o nó original de volta na lista original
			data.append(dadoAntigo);
		}

		return listaNew;
	}


	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveGraded()} deve filtrar os nós que possuem notas válidas e retornar uma nova lista do
	 * tipo {@code DLinkedList} contendo apenas os nós com notas inválidas (caso de "ausência de nota").</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas inválidas.
	 */
	public static DLinkedList filterRemoveGraded(final DLinkedList data) {
		DLinkedList listaNew = new DLinkedList();
		int number = data.count();

		for (int i = 0; i < number; i++) {
			Node dadoAntigo = data.removeHead();

			if (dadoAntigo.getNota() == 99.9f) {
				// Criando um novo nó com os mesmos dados
				Node inserir = new Node();
				inserir.setID(dadoAntigo.getID());
				inserir.setNome(dadoAntigo.getNome());
				inserir.setNota(dadoAntigo.getNota());

				listaNew.append(inserir);
			}

			// Recoloca o nó original de volta na lista original
			data.append(dadoAntigo);
		}

		return listaNew;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}, e a média de notas válidas, calculadas com a
	 * operação {@code reduce()}.</p>
	 * <p>A operação {@code filterRemoveBelowAverage()} deve filtrar os nós que possuem notas abaixo da média e retornar uma
	 * nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas acima da média.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @param average Média de notas válidas calculada com a operação {@code reduce()}.
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada somente com pessoas com notas maiores do que {@code average}.
	 */
	public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
		DLinkedList listaNew = new DLinkedList();
		int number = data.count();

		for (int i = 0; i < number; i++) {
			Node dadoAntigo = data.removeHead();

			if (dadoAntigo.getNota() >= average) {
				// Criando um novo nó com os mesmos dados
				Node inserir = new Node();
				inserir.setID(dadoAntigo.getID());
				inserir.setNome(dadoAntigo.getNome());
				inserir.setNota(dadoAntigo.getNota());

				listaNew.append(inserir);
			}

			// Recoloca o nó original de volta na lista original
			data.append(dadoAntigo);
		}

		return listaNew;
	}
	
	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}.</p>
	 * <p>A operação {@code reduce()} deve calcular a média das notas contidas na coleção de dados passada como parâmetro e
	 * retornar a média calculada.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @return Média das notas ({@code float}) contidas na coleção de dados ({@code data}).
	 */
	public static float reduce(final DLinkedList data) {
		int number = data.count();
		float average = 0;
		for (int i = 0; i < number; i++) {
			Node dadoAntigo = data.removeHead();

			if (dadoAntigo.getNota() != 99.9f) {
				// Criando um novo nó com os mesmos dados
				average += dadoAntigo.getNota(); 
				
				
			}

			// Recoloca o nó original de volta na lista original
			data.append(dadoAntigo);
		}
		average = average / number;
		return average;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code mapToString()} deve mapear todos os nós da coleção de dados passada como parâmetro para uma única
	 * {@code String}, sendo que cada dado de uma pessoa é separado por ponto-e-vírgula (;) e cada pessoa é separada por uma
	 * quebra de linha.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return {@code String} com a coleção de dados separada por ponto-e-vírgula (dados de cada pessoa) e quebras de linha (cada pessoa).
	 */
	public static String mapToString(final DLinkedList data) {
		StringBuilder sb = new StringBuilder();

		Node aux = data.getHead();
		while(aux != null)
		{
			sb.append(aux.getID())
				.append(";")
				.append(aux.getNome())
				.append(";")
				.append(aux.getNota())
				.append("\n");
			
			aux = aux.getNext();
		}
		return sb.toString();
	}


}
