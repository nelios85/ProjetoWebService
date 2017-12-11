package br.com.devmedia.notas;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class NotaRest {
	private Client client;
	private WebResource webResource;
	
	public NotaRest() {
		client = Client.create();
		webResource = client.resource("http://devmedianotesapi.azurewebsites.net/api/");
	}
	
	public List<Notas> listar() {
		return webResource.path("Notes").get(new GenericType<List<Notas>>() {
		});
	}
	
	public Notas obter(Integer id) {
		return webResource.path("Notes").path(id.toString()).get(new GenericType<Notas>(){});
		
	}
	
	public static void main(String...args) {
		NotaRest notaRest = new NotaRest();
		notaRest.obter(753); 
	}

}