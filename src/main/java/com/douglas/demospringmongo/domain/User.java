package com.douglas.demospringmongo.domain;

public class User {
	
	private String name;
	private String login;
	private String password;
	private String email;
	private int codeAgentBranch;
	
	public User(String name, String login, String password, String email, int codeAgentBranch) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.codeAgentBranch = codeAgentBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodeAgentBranch() {
		return codeAgentBranch;
	}

	public void setCodeAgentBranch(int codeAgentBranch) {
		this.codeAgentBranch = codeAgentBranch;
	}	
	
}
