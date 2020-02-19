package br.com.senac;

import java.util.Scanner;

import br.com.senac.model.SubTarefa;
import br.com.senac.model.Tarefa;

public class Program {

	public static void main(String[] args) {
		Mock db = new Mock();

		Character opcao = ' ';
		Character continuar = ' ';
		Character opcaoSub = ' ';
		int n = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Escolha uma opção: \n 1:Nova tarefa \n 2:Listar tarefas \n 3:Alterar titulo \n");

			n = sc.nextInt();
			sc.nextLine();

			switch (n) {

			case 1:
				do {

					System.out.println("Nova tarefa: ");
					System.out.println("Titulo:");
					String titulo = sc.nextLine();
					System.out.println("Estado: (0/1)");
					int estado = sc.nextInt();

					Tarefa tarefa = new Tarefa(titulo, estado);

					System.out.print("Deseja inserir uma sub tarefa ? (s/n)");
					opcaoSub = sc.next().charAt(0);
					sc.nextLine();

					while (opcaoSub.equals('s')) {
						System.out.println("Nova sub tarefa: ");
						System.out.println("Titulo:");
						String tituloSub = sc.nextLine();
						System.out.println("Estado: (0/1)");
						int estadoSub = sc.nextInt();

						SubTarefa subTarefa = new SubTarefa(tituloSub, estadoSub);
						tarefa.adicionaSubTarefa(subTarefa);
						opcaoSub = ' ';
					}

					db.adicionaTarefa(tarefa);

					System.out.print("Deseja inserir uma nova tarefa ? (s/n)");
					opcao = sc.next().charAt(0);
					sc.nextLine();

				} while (opcao.equals('s'));

				break;

			case 2:
				System.out.println(db.getTarefas().toString());
				break;

			case 3:
				System.out.print("Nome da tarefa: ");
				String nome = sc.nextLine();
				System.out.print("Novo titulo: ");
				String novo = sc.nextLine();

				boolean resultado = db.alteraTitulo(nome, novo);

				if (resultado) {
					System.out.println("Titulo alterado");
				} else {
					System.out.println("Erro ao tentar alterar");
				}

			}

			System.out.println("Sair ? (s/n)");
			continuar = sc.next().charAt(0);
			sc.nextLine();

		} while (continuar.equals('n'));
		sc.close();

	}
}
