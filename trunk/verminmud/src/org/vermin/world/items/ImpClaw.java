/* ImpClaw.java
	19.1.2002	TT & VV
	
	An item representing an imp claw as a melee weapon.
*/

package org.vermin.world.items;

import org.vermin.mudlib.*;

public class ImpClaw extends DefaultWieldableImpl
{
	
	private static final String OBJECT_HIT_MESSAGE = "You shred $subject$ with your claw.";
	private static final String SUBJECT_HIT_MESSAGE = "$object$ shreds you with $o_poss$ claw.";
	private static final String SPECTATOR_HIT_MESSAGE = "$object$ shreds $subject$ with $o_poss$ claw.";
	
	private static Damage[] dmg = null;
	
	public boolean isWeapon() { return true; }
	
	public Damage[] getHitDamage(Living target)
	{
		if(dmg == null)
		{
			dmg = new Damage[2];
			dmg[0] = new Damage();
			dmg[0].type = Damage.Type.SLASHING;
			dmg[0].damage = 6;
		        dmg[1] = new Damage();
		        dmg[1].type = Damage.Type.CRUSHING;
		        dmg[1].damage = 3;
		}
		
		return dmg;
	}

	public String getObjectHitMessage(int damageType)
	{
		return OBJECT_HIT_MESSAGE;
	}
		
	public String getSubjectHitMessage(int damageType)
	{
		return SUBJECT_HIT_MESSAGE;
	}
	
	public String getSpectatorHitMessage(int damageType)
	{
		return SPECTATOR_HIT_MESSAGE;
	}

	public boolean isVisible() {
		return false;
	}
	
	public String getName() { return "claw"; }
}