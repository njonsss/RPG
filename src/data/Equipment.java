package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import characters.Personnage;

public class Equipment implements Cloneable{
	
	private Personnage owner;
	private String name;
	private int attackBonus;
	private int defenceBonus;
	private int magicBonus;
	private int resistanceBonus;
	private int speedBonus;
	private int lifePointsBonus;
	private int willPointsBonus;
	private int value;
	private String [] equipmentOwner;

	public Equipment(String name, int attackBonus, int defenceBonus, int magicBonus, int resistanceBonus,
			int speedBonus, int lifePointsBonus, int willPointsBonus, int value) {
		this.name = name;
		this.attackBonus = attackBonus;
		this.defenceBonus = defenceBonus;
		this.magicBonus = magicBonus;
		this.resistanceBonus = resistanceBonus;
		this.speedBonus = speedBonus;
		this.lifePointsBonus = lifePointsBonus;
		this.willPointsBonus = willPointsBonus;
		this.value = value;
	}
	
	
	public void buy() {
		Squad squad = Squad.getInstance();
		squad.setGold(squad.getGold() - value);
		squad.addEquipment(this);
	}
	
	public void sell() {
		Squad squad = Squad.getInstance();
		squad.setGold(squad.getGold() + value);
		if (this.owner != null) {
			unequip();
		}
		squad.removeEquipment(this);
	}
	
	
	
	public void equip(Personnage owner) {
		this.owner = owner;
		if (attackBonus != 0) {
			owner.setAttack(owner.getAttack() + attackBonus);
		}
		if (defenceBonus != 0) {
			owner.setDefence(owner.getDefence() + defenceBonus);
		}
		if (magicBonus != 0) {
			owner.setMagic(owner.getMagic() + magicBonus);
		}
		if (resistanceBonus != 0) {
			owner.setResistance(owner.getResistance() + resistanceBonus);
		}
		if (speedBonus != 0) {
			owner.setSpeed(owner.getSpeed() + speedBonus);
		}
		if (lifePointsBonus != 0) {
			owner.setLifePoints(owner.getLifePoints() + lifePointsBonus);
			owner.setMaxLifePoints(owner.getMaxLifePoints() + lifePointsBonus);
		}
		if (willPointsBonus != 0) {
			owner.setWillPoints(owner.getWillPoints() + willPointsBonus);
			owner.setMaxWillPoints(owner.getMaxWillPoints() + willPointsBonus);
		}
	}
	
	public void unequip() {
		this.owner = null;
		if (attackBonus != 0) {
			owner.setAttack(owner.getAttack() - attackBonus);
		}
		if (defenceBonus != 0) {
			owner.setDefence(owner.getDefence() - defenceBonus);
		}
		if (magicBonus != 0) {
			owner.setMagic(owner.getMagic() - magicBonus);
		}
		if (resistanceBonus != 0) {
			owner.setResistance(owner.getResistance() - resistanceBonus);
		}
		if (speedBonus != 0) {
			owner.setSpeed(owner.getSpeed() - speedBonus);
		}
		if (lifePointsBonus != 0) {
			owner.setLifePoints(owner.getLifePoints() - lifePointsBonus);
			owner.setMaxLifePoints(owner.getMaxLifePoints() - lifePointsBonus);
		}
		if (willPointsBonus != 0) {
			owner.setWillPoints(owner.getWillPoints() - willPointsBonus);
			owner.setMaxWillPoints(owner.getMaxWillPoints() - willPointsBonus);
		}
	}
	
	public HashMap<String,String> getEquipmentDetails() {
		HashMap<String,String> h = new HashMap<String,String>();
		h.put("equipmentOwner", "" +equipmentOwner);
		h.put("name", name);
		h.put("attackBonus", ""+attackBonus);
		h.put("defenceBonus", ""+defenceBonus);
		h.put("magicBonus", ""+magicBonus);
		h.put("resistanceBonus", ""+resistanceBonus);
		h.put("speedBonus", ""+speedBonus);
		h.put("lifePointsBonus", ""+lifePointsBonus);
		h.put("willPointsBonus", ""+willPointsBonus);
		h.put("value", ""+value);
		return h;
	}

 	public int getValue() {
		return value;
	}

 	public String [] getEquipmentTeam(String [] name) {
		return name;
 		
 	} 

	public Personnage getOwner() {
		return owner;
	}


	public String getName() {
		return name;
	}


	public String [] getEquipmentOwner() {
		if (equipmentOwner != null) {
			equipmentOwner .equals(owner);
		}else {
			System.out.println(equipmentOwner == null);
		}
		return equipmentOwner;
	}


	public void setEquipementOwner(String [] equipementOwner) {
		this.equipmentOwner = equipementOwner;
	}
	
	
	
}