package com.eclipse.ec.repository;


public class Zombe extends Character implements ForestCharacters {
	
	private int regeneration;

	public int getRegeneration() {
		return regeneration;
	}

	public void setRegeneration(int regeneration) {
		this.regeneration = regeneration;
	}

	@Override
	protected String getPlaceOfOccurrence() {
		return "Graweyard";
	}

	@Override
	public String toString() {
		return "Zombe [regeneration=" + regeneration + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

}
