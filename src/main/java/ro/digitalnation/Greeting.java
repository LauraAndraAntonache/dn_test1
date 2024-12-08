package ro.digitalnation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Greeting { 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String content;
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public Greeting() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", content=" + content + "]";
	}
	
	
}