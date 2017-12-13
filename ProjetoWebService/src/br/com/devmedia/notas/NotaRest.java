package br.com.devmedia.notas;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

import rest.GensonProvider;

public class NotaRest {
	private Client client;
	private WebResource webResource;
	
	public NotaRest() {
		ClientConfig clientConfig = new DefaultClientConfig(GensonProvider.class);
		client = Client.create(clientConfig);
		client.addFilter(new LoggingFilter(System.out));
		webResource = client.resource("http://devmedianotesapi.azurewebsites.net/api/");
	}
	
	public List<Notas> listar() {
		return webResource.path("Notes").get(new GenericType<List<Notas>>() {
		});
	}
	
	
	/**
	 * obtem o id da classe notas
	 * @param id parametro identificador da lista
	 * @return retorna o objeto clicado
	 */
	
	public Notas obter(Integer id) {
		return webResource.path("Notes").path(id.toString()).get(new GenericType<Notas>(){});
		
	}
	
	/**
	 * Atualiza dados do webservice
	 * @param nota
	 */
	
	public void atualizar(Notas nota) {
		webResource.path("Notes").path(nota.getId().toString()).put(ClientResponse.class,nota);
		
	}
	
	public void remover(Integer id) {
		webResource.path("Notes").path(id.toString()).delete();
	}
	
	/**
	 * Inserir dados ao webservice
	 * @param nota da classe nota
	 */
	
	public void inserir(Notas nota) {
		webResource.path("Notes").post(new GenericType<Notas>() {}, nota);
	}
	
	public static void main(String...args) {
		NotaRest notaRest = new NotaRest();
		Notas nota = new Notas();
		nota.setId(800);
		nota.setTitle("DevMedia");
		nota.setBody("Corpo");
		notaRest.atualizar(nota);
	}

}