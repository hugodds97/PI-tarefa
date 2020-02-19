package br.com.senac.model;

import java.util.ArrayList;
import java.util.List;

public class Tarefa {

	private String titulo;
	private int estado;
	
	private List<SubTarefa> subTarefa = new ArrayList<>();

	public Tarefa(String titulo, int estado) {
		this.titulo = titulo;
		this.estado = estado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void adicionaSubTarefa(SubTarefa obj) {
		subTarefa.add(obj);
	}

	@Override
	public String toString() {
		return "Tarefa [titulo=" + titulo + ", estado=" + estado + ", subTarefa=" + subTarefa + "]";
	}
	
	

}
