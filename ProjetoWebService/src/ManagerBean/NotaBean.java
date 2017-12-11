package ManagerBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.devmedia.notas.NotaRest;
import br.com.devmedia.notas.Notas;

@ManagedBean
@SessionScoped
public class NotaBean {
	private Integer id;
	private Notas nota;
	private List<Notas> notas;	
	
	public void initDetalhes() {
		NotaRest notaRest = new NotaRest();
		this.nota = notaRest.obter(id);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Notas getNota() {
		return nota;
	}

	public void setNota(Notas nota) {
		this.nota = nota;
	}

	public List<Notas> getNotas() {
		return notas;
	}
	
	public void setNotas(List<Notas> notas) {
		this.notas = notas;
	}

	@PostConstruct
	public void init() {
		NotaRest notaRest = new NotaRest();
		notas = notaRest.listar();
	}
	
	public String exibir(Notas nota) {
		this.nota = nota;
		return "detalhes";
		
	}

	
}
