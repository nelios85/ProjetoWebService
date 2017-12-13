package ManagerBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.devmedia.notas.NotaRest;
import br.com.devmedia.notas.Notas;

@ManagedBean
@ViewScoped
public class NotaBean {
	private Integer id;
	private Notas nota;
	private List<Notas> notas;
	private NotaRest notaRest = new NotaRest();
	
	public void initDetalhes() {
		if(this.id != null) {
			this.nota = notaRest.obter(id);
		} else {
			this.nota = new Notas();
		}
	}
	
	public String editar() {
		if(this.id != null) {
			notaRest.atualizar(this.nota);
		} else {
			notaRest.inserir(this.nota);
		}
		
		this.notas =  notaRest.listar();
		return "index";
	}
	
	public String remover(Integer id) {
		notaRest.remover(id);
		this.notas = notaRest.listar();
		return "index";
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
		notas = notaRest.listar();
	}
	
	public String exibir(Notas nota) {
		this.nota = nota;
		return "detalhes";
	}
}
