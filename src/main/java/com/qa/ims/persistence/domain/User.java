package com.qa.ims.persistence.domain;

public class User {
	
	private Long id;
	private String username;
	
	public User(Long id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public User(String username) {
		this.username = username;
	}
	public Long getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}

	@Override
	public String toString() {
		return "id=" + id + ", username=" + username;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
