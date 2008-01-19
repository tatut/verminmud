/*
 * Created on Jul 17, 2004
 */
package org.vermin.world.items;
import org.vermin.mudlib.*;

public class InsectClaw extends DefaultWieldableImpl {
	
	private static Damage[] dmg = null;
	
	public boolean isWeapon() { return true; }
	
	static {
	   dmg = new Damage[1];
	   dmg[0] = new Damage();
	   dmg[0].type = Damage.Type.SLASHING;
	   dmg[0].damage = 10;
	}  
   
	public Damage[] getHitDamage(Living target) {
	   return dmg;
	}
   
	public int getDefensiveValue() {
	   return 0;
	}
  
	public boolean isVisible() {
		return false;
	}
	
	public String getName() {
	   return "claw";
	}
}
