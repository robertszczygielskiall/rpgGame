package com.eclipse.ec.repository;

public abstract class Character implements Comparable<Character> {

	private int hitPoints;
	private int intiative;
	private String name;

	public Character(int hitPoints, int intiative, String name) {
		this.hitPoints = hitPoints;
		this.intiative = intiative;
		this.name = name;
	}

	public Character() {
		hitPoints = 2;
		intiative = 0;
		name = "NN";
	}

	public void showPlaceOfOccurrence() {
		String occurre = getPlaceOfOccurrence();
		System.out.println("This enemy is occure in " + occurre);
	}

	abstract protected String getPlaceOfOccurrence();

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public void setHitPoints(String hitPoints) {
		this.hitPoints = Integer.valueOf(hitPoints);
	}

	public int getIntiative() {
		return intiative;
	}

	public void setIntiative(int intiative) {
		this.intiative = intiative;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Character o) {
		if (this.intiative < o.intiative)
			return 1;
		if (this.intiative > o.intiative)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "Character [hitPoints=" + hitPoints + ", intiative=" + intiative + ", name=" + name + "]";
	}
	
}
