//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

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

// TODO: Listar todas as referências consultadas para solucionar a atividade.

/*Referencias:
 * https://pt.stackoverflow.com/questions/374001/lista-duplamente-encadeada-java
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;


public class MainApl2 {
	
	public static void main(String[] args) {
		boolean ended  = false;
				Scanner myObj = new Scanner(System.in);  // Create a Scanner object

		String tex = "";
		String title = "dados.txt";
		DLinkedList fixedList = new DLinkedList() ;	
		DLinkedList filteredGradedList = new DLinkedList();
		float average = 0.0f;
		
		
		LinkedListOriginal list = new LinkedListOriginal();
		
		while(ended == false){
		 
		System.out.println("1) Dados originais: lê arquivo dados.txt e apresenta todos os dados do Sistema de Notas Legado");
		System.out.println("2) Dados convertidos:  gera arquivo dados.csv e apresenta todos os dados do Sistema de Notas Atualizado ");
		System.out.println("3) Lista notas filtradas válidas: apresenta os dados somente das notas válidas filtradas");
		System.out.println("4) Lista notas filtradas inválidas: apresenta os dados somente das notas filtradas pela “ausência de notas ");
		System.out.println("5) Média de notas válidas: apresenta a média das notas válidas filtradas");
		System.out.println("6) Notas acima da média: apresenta os dados para as notas acima da média");
		System.out.println("7) Lista mapeada para uma única string: apresenta a String contendo os dados mapeados");
		System.out.println("8) Finaliza sistema");
		int op = 0;
    	System.out.println("DIGITE A OPERAÇÃO:");
		op = myObj.nextInt();
		
		
		switch (op) {
			case 1:
			try{
			tex = Data.loadTextFileToString(title);
		}catch(Exception e){
			System.out.println("none " + e);
		}
		BufferedReader br = new BufferedReader(new StringReader(tex));
		
     StringBuilder sb = new StringBuilder();
		String line ;
		while (true) {
			try{
         line = br.readLine();
			
			}catch(Exception e){
				line ="";
			}
         if (line == null) {
             break;
         }
			String[] dividido = line.split("#");
			NodeOriginal dadoAluno = new NodeOriginal();
			int newId = Integer.parseInt(dividido[0]);
			int inteiro = Integer.parseInt(dividido[2]);
			int decimo = Integer.parseInt(dividido[3]);
         list.append(newId,dividido[1],inteiro,decimo);
     }
		
		System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
		System.out.println(list );
		System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
		fixedList = Operation.map(list);
		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(fixedList);
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		String contents3 = Operation.mapToString(fixedList);
		break;
		case 2:
		 fixedList = Operation.map(list);
		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
		System.out.println(fixedList);
		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		String contents = Operation.mapToString(fixedList);
try {
			Data.saveStringToTextFile("dados.csv", contents);
		} catch (IOException e) {
			System.out.println("Erro ao salvar a string contents no arquivo dados.csv: " + e);
		}
		
		break;
		case 3:
		 filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
		System.out.println(filteredGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
		break;
		case 4:
		DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
		System.out.println(filteredNonGradedList);
		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");
		break;
		case 5:
		 average = Operation.reduce(filteredGradedList);
		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
		System.out.println(average);
		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
		break;
		case 6:
		DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
		System.out.println(aboveAverageList);
		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
	 	break;


		// daqui para baixo



	 	case 7:
		String contents2 = Operation.mapToString(fixedList);
		System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
		System.out.println(contents2);
		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
		break;
		
		case 8:
		ended = true;
		break;
		}
	}
	}
}
	

