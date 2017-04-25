package pl.jemiol.util;

public class TripleMap {
	private String key, value, value2;

	public TripleMap(String index, String name, String lastname) {
		super();
		this.key = index;
		this.value = name;
		this.value2 = lastname;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

}
