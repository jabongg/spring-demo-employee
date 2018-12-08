package com.dsal.java;

public class Bean {

	private String name;
	
	public Bean(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bean [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;*/
		return 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		Bean other = (Bean) obj;
		
		
		if (obj instanceof Bean) {
			
		}
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
