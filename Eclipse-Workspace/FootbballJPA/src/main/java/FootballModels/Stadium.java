package FootballModels;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stadium database table.
 * 
 */
@Entity
@NamedQuery(name="Stadium.findAll", query="SELECT s FROM Stadium s")
public class Stadium implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String location;

	private String name;

	public Stadium() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}