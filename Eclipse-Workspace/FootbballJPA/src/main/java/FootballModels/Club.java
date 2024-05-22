package FootballModels;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the club database table.
 * 
 */
@Entity
@NamedQuery(name="Club.findAll", query="SELECT c FROM Club c")
public class Club implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer foundedyear;

	private String name;

	private Integer stadiumid;

	public Club() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFoundedyear() {
		return this.foundedyear;
	}

	public void setFoundedyear(Integer foundedyear) {
		this.foundedyear = foundedyear;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStadiumid() {
		return this.stadiumid;
	}

	public void setStadiumid(Integer stadiumid) {
		this.stadiumid = stadiumid;
	}

}