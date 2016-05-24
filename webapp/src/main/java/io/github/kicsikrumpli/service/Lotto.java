package io.github.kicsikrumpli.service;

import java.util.List;

public class Lotto {
	private String id;
	private List<Integer> numbers;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Integer> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
}
