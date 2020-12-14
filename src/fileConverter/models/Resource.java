package fileConverter.models;

public class Resource {
	private int id;
	private String type;
	private String version;

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getVersion() {
		return version;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Resource [id=" + id + ", type=" + type + ", version=" + version + "]";
	}

}
