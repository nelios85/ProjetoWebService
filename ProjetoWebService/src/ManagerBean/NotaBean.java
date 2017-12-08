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
	private List<Notas> notas;
	
	public List<Notas> getNotas() {
		return notas;
	}

	@PostConstruct
	public void init() {
		NotaRest notaRest = new NotaRest();
		notas = notaRest.listar();
	}
	
}
