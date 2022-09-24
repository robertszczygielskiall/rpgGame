package com.eclipse.ec.repository;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Enemy {

	@Id
	@GenericGenerator(name="kaugen" , strategy="increment")
	@GeneratedValue(generator="kaugen")
	private Integer id;
	private String name;
	private Integer intiative;
	@Column(name = "hit_points")
	private Integer hitPoints;
	@JoinColumn(name = "enemy_type_id", insertable = true, updatable = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private EnemyType enemyType;
	@JoinColumn(name = "wapen_id", insertable = true, updatable = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private Wapen wapen;
	@JoinColumn(name = "immunity", insertable = true, updatable = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private Material immunity;
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
	public Integer getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(Integer hitPoints) {
		this.hitPoints = hitPoints;
	}
	public EnemyType getEnemyType() {
		return enemyType;
	}
	public void setEnemyType(EnemyType enemyType) {
		this.enemyType = enemyType;
	}
	public Wapen getWapen() {
		return wapen;
	}
	public void setWapen(Wapen wapen) {
		this.wapen = wapen;
	}
	public Material getImmunity() {
		return immunity;
	}
	public void setImmunity(Material immunity) {
		this.immunity = immunity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(enemyType, hitPoints, id, immunity, intiative, name, wapen);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enemy other = (Enemy) obj;
		return Objects.equals(enemyType, other.enemyType) && Objects.equals(hitPoints, other.hitPoints)
				&& Objects.equals(id, other.id) && Objects.equals(immunity, other.immunity)
				&& Objects.equals(intiative, other.intiative) && Objects.equals(name, other.name)
				&& Objects.equals(wapen, other.wapen);
	}
	@Override
	public String toString() {
		return "Enemy [id=" + id + ", name=" + name + ", intiative=" + intiative + ", hitPoints=" + hitPoints
				+ ", enemyType=" + enemyType + ", wapen=" + wapen + ", immunity=" + immunity + "]";
	}

	
	
}
