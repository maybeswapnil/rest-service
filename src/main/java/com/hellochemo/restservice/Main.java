package com.hellochemo.restservice;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private int id;
	private String name;
	private List<String> chat = new ArrayList<String>();
	
	public Main(int id, String name, String chat) {
		super();
		this.id = id;
		this.name = name;
		this.chat.add(chat);
	}
	public List<String> getChat() {
		return chat;
	}
	public void setChat(List<String> chat) {
		this.chat = chat;
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
	
	
}
