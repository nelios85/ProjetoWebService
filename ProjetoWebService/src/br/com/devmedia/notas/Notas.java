package br.com.devmedia.notas;

import com.owlike.genson.annotation.JsonProperty;

public class Notas {
	@JsonProperty("Id")
	private Integer id;
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("Body")
	private String body;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
