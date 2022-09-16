package com.revature.repository.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "armor")
public class Armor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int armor_id;
	
	private String name;
	
	private int defense;
	
	private int cost;

	public Armor() {
		super();
	}

	public Armor(int armor_id, String name, int defense, int cost) {
		super();
		this.armor_id = armor_id;
		this.name = name;
		this.defense = defense;
		this.cost = cost;
	}

	public int getArmor_id() {
		return armor_id;
	}

	public void setArmor_id(int armor_id) {
		this.armor_id = armor_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(armor_id, cost, defense, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Armor other = (Armor) obj;
		return armor_id == other.armor_id && cost == other.cost && defense == other.defense
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Armor [armor_id=" + armor_id + ", name=" + name + ", defense=" + defense + ", cost=" + cost + "]";
	}
	
	

}
