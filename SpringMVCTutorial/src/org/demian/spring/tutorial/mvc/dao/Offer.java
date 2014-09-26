package org.demian.spring.tutorial.mvc.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.demian.spring.tutorial.mvc.validation.ValidEmail;

public class Offer {
	private int id = 0;
	@NotNull
	@Size(min = 5, max = 100, message = "Size of name is not valid.")
	private String name;
	@NotNull
	@ValidEmail
	private String email;
	@Size(max = 777, message = "Max length of message is 777.")
	private String text;

	public Offer() {
	}

	public Offer(String name, String email, String text) {
		super();
		this.name = name;
		this.email = email;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + "]";
	}
}