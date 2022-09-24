package com.eclipse.ec.domain;

import com.eclipse.ec.enums.Wapens;
import com.eclipse.ec.repository.Character;
import com.eclipse.ec.repository.Warrior;

/**
 * This is Forest 
 * @author ksenoform
 * @version 0.0.1
 *
 */
public class Forest extends Place implements Occurenable {
	
	private Character[] enemies;

	public Forest() {};
	public Forest(int enemiesAmoutn) {
		enemies = new Character[enemiesAmoutn];
	}

	public Character[] getEnemies() {
		return enemies;
	}

	public void setEnemies(Character[] enemies) {
		this.enemies = enemies;
	}
	
	public void setEnemies(Character characere, int idx) {
		this.enemies[idx] = characere;
	}
	@Override
	protected String getPlaceOfOccurrence() {
		return "Forest";
	}
	@Override
	public String occurenceAtTimeOfDay() {
		return "Midnight";
	}
	
	public void fight(Warrior warrior) {
		greatings();
		var place = warrior.getVisitedPalce();
		int extraIntiative = 0;
		if (getPlaceOfOccurrence().toUpperCase().equals(place.name().toUpperCase())) {
			extraIntiative = 20;
		}
		
		for (Character enemy: enemies) {
			fightWithEmemy(enemy, warrior, extraIntiative);
			showEnemiDefidet(enemy);
			showWarriorDefidet(warrior);
		}
	}
	
	private void showWarriorDefidet(Warrior warrior) {
		if (warrior.getHitPoints() < 0) {
			System.out.println("You Are Dead");
		}	
	}
	
	private void greatings() {
		System.out.println("Now you see " + enemies.length + " enemies");
		System.out.print("they names are: ");
		for (Character enemy: enemies) {
			System.out.print(enemy.getName() + ", ");
		}
		System.out.println();
		System.out.println("========================================================");
		System.out.println("Fight: ");
		
	}
	
	private void showEnemiDefidet(Character enemy) {
		if (enemy.getHitPoints() < 0) {
			System.out.println("You have defited " + enemy.getName());
		}
	}
	
	private void fightWithEmemy(Character enemy, Warrior warrior, int extraIntiative) {
		if ((enemy.getIntiative() + extraIntiative) <= warrior.getIntiative()) {
			int warriorHit = warrior.getHitPoints() - warrior.getWapen().getExtraHit(); 
			int hp = enemy.getHitPoints() - warriorHit;
			enemy.setHitPoints(hp);
		} else {
			int hp = warrior.getHitPoints() - enemy.getHitPoints();
			System.out.println("You was wonded, HP = " + hp);
			warrior.setHitPoints(hp);
		}
	
	}
	
}
