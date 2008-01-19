/* DrowRace.java
	13.9.2003 MV
	
	Drow race implementation.
*/

package org.vermin.world.races;

import org.vermin.mudlib.Item;
import org.vermin.mudlib.PlayerRace;
import org.vermin.mudlib.Race;
import org.vermin.mudlib.Slot;
import org.vermin.mudlib.World;
import org.vermin.world.items.HumanHand;


public class DrowRace extends PlayerRace {
	private static HumanHand hand = null;
	
	protected static DrowRace _instance = null;

	private String name = new String("drow");
	
	Slot[] slots = new Slot[] { new Slot(Slot.HEAD, "head"),
								new Slot(Slot.NECK, "neck"),
								new Slot(Slot.ARM, "left arm"),
								new Slot(Slot.HAND, "left hand"),
								new Slot(Slot.ARM, "right arm"),
								new Slot(Slot.HAND, "right hand"),
								new Slot(Slot.TORSO, "torso"),
								new Slot(Slot.LEG, "left leg"),
								new Slot(Slot.FOOT, "left foot"),
								new Slot(Slot.LEG, "right leg"),
								new Slot(Slot.FOOT, "right foot"),
								new Slot(Slot.FINGER, "left hand finger"),
								new Slot(Slot.FINGER, "right hand finger"),
								new Slot(Slot.AMULET, "amulet"),
								new Slot(Slot.BELT, "belt"),
								new Slot(Slot.CLOAK, "cloak"),
								new Slot(Slot.WRIST, "left wrist"),
								new Slot(Slot.WRIST, "right wrist")
								};

	public int getMinimumVisibleIllumination() {
		return 10;
	}

	/* hit location name by percent */
	public String getHitLocation(int pos)
	{
		if(pos < 2)		{ return "forehead"; }
		if(pos < 3)		{ return "left eye"; }
		if(pos < 4)		{ return "right eye"; }
		if(pos < 5)		{ return "nose"; }	
		if(pos < 6)		{ return "jaw"; }
		if(pos < 7)		{ return "neck"; }
		if(pos < 8)		{ return "left shoulder"; }
		if(pos < 10)	{ return "upper left arm"; }						
		if(pos < 11)	{ return "left elbow"; }
		if(pos < 13)	{ return "lower left arm"; }
		if(pos < 14)	{ return "left wrist"; }
		if(pos < 17)	{ return "left hand"; }						
		if(pos < 18)	{ return "right shoulder"; }
		if(pos < 20)	{ return "upper right arm"; }						
		if(pos < 21)	{ return "right elbow"; }
		if(pos < 23)	{ return "lower right arm"; }
		if(pos < 24)	{ return "right wrist"; }
		if(pos < 27)	{ return "right hand"; }
		if(pos < 47)	{ return "chest"; }
		if(pos < 62)	{ return "stomach"; }						
		if(pos < 66)	{ return "groin"; }
		if(pos < 70)	{ return "left hip"; }
		if(pos < 75)	{ return "left thigh"; }
		if(pos < 76)	{ return "left knee"; }						
		if(pos < 79)	{ return "left leg"; }
		if(pos < 80)	{ return "left ankle"; }
		if(pos < 82)	{ return "left foot"; }
		if(pos < 85)	{ return "right hip"; }						
		if(pos < 91)	{ return "right thigh"; }						
		if(pos < 92)	{ return "right knee"; }						
		if(pos < 97)	{ return "right leg"; }						
		if(pos < 98)	{ return "right ankle"; }						
		if(pos <= 100)	{ return "right foot"; }	
		return "invisible antenna";
	}

	/* slot by percent */
	public Slot getSlotForLocation(int pos)
	{
		if(pos < 6)		{ return slots[0]; }
		if(pos < 7)		{ return slots[1]; }
		if(pos < 13)	{ return slots[2]; }
		if(pos < 17)	{ return slots[3]; }						
		if(pos < 23)	{ return slots[4]; }
		if(pos < 27)	{ return slots[5]; }
		if(pos < 62)	{ return slots[6]; }											
		if(pos < 79)	{ return slots[7]; }
		if(pos < 82)	{ return slots[8]; }				
		if(pos < 97)	{ return slots[9]; }												
		if(pos <= 100)	{ return slots[10]; }	
		return slots[0];
	}	

   /* Returns array of armour slots for this
    * race.
    */
   public Slot[] getSlots()
   {
		return slots;
   }
   
	
	public String getName() { return this.name; }
	
	/* indexed limb name 0 to n */
	public String getLimbName(int limb)
	{
		switch(limb)
		{
			case 0: return "right hand";
			case 1: return "left hand";
			default: return "left butt cheek";
		}
	}
	
		
	public Item getLimb(int limb)
	{
		return new HumanHand();
	}

	public int getLimbCount()
	{
		return 2;
	}
	
	public static Race getInstance() {
		return (Race) World.get("races/drow");
	}
	
	public int getBaseHpRegen()
	{
		return 55;
	}
	
	public int getBaseSpRegen()
	{
		return 65;
	}
	
	public int getSize()
	{
		return 50;
	}
	
	public int getExpRate()
	{
		return 85;
	}
	
	public String[] getGenders() { return new String[] { "male", "female" }; }

	/* Max stats for this race */
	public int getMaxPhysicalStrength() { return 50; }
	public int getMaxMentalStrength() { return 66; }
	public int getMaxPhysicalConstitution() { return 50; }
	public int getMaxMentalConstitution() { return 67; }
	public int getMaxPhysicalCharisma() { return 50; }
	public int getMaxMentalCharisma() { return 55; }
	public int getMaxPhysicalDexterity() { return 58; }
	public int getMaxMentalDexterity() { return 57; }

	/* Statcosts for this race (0-10) */
	public int getPhysicalStrengthCost() { return 5; }
	public int getMentalStrengthCost() { return 4; }
	public int getPhysicalConstitutionCost() { return 5; }
	public int getMentalConstitutionCost() { return 4; }
	public int getPhysicalCharismaCost() { return 5; }
	public int getMentalCharismaCost() { return 4; }
	public int getPhysicalDexterityCost() { return 4; }
	public int getMentalDexterityCost() { return 4; }

}
