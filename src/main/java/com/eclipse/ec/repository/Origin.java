package com.eclipse.ec.repository;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Origin {

	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private Integer id;
	private String name;
	private Integer intiative;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIntiative() {
		return intiative;
	}
	public void setIntiative(Integer intiative) {
		this.intiative = intiative;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, intiative, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Origin other = (Origin) obj;
		return Objects.equals(id, other.id) && Objects.equals(intiative, other.intiative)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Origin [id=" + id + ", name=" + name + ", intiative=" + intiative + "]";
	}
	
	
	
}
