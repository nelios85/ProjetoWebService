package br.com.devmedia.notas;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class NotaRest {

	public List<Notas> listar() {
		Client client = Client.create();
		WebResource webResource = client.resource("http://devmedianotesapi.azurewebsites.net/api/");
		return webResource.path("Notes").get(new GenericType<List<Notas>>() {
		});
	}
	
	public static void main(String...args) {
		NotaRest notaRest = new NotaRest();
		List<Notas> list = notaRest.listar();
		for(Notas notas: list) {
			System.out.println(notas.getTitle());
		}
	}

}
