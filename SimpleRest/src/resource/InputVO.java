package resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="InputVO")
public class InputVO {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
