package com.kachade.Dao.modle;

public class AccountInfo {
	private String name;
	private int id;

	public AccountInfo() {
	}

	public AccountInfo(String name, int id) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
