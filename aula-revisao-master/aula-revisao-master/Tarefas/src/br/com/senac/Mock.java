package br.com.senac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.senac.model.Tarefa;

public class Mock {
	private static List<Tarefa> tarefas = new ArrayList<>();

	public void adicionaTarefa(Tarefa tarefa) {
		tarefas.add(tarefa);
	}

	public List<Tarefa> getTarefas() {
		return Collections.unmodifiableList(tarefas);

	}

	public boolean alteraTitulo(String anterior, String novo) {

		if (novo == null) {
			return false;
		}

		for (Tarefa tarefa : tarefas) {
			if (tarefa.getTitulo().equalsIgnoreCase(anterior)) {
				tarefa.setTitulo(novo);
				return true;
			}
		}
		return false;
	}

}
