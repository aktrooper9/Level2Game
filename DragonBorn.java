import java.util.Random;


public class DragonBorn extends GameObject {
	Random ran = new Random();
DragonBorn(){
	 damage = ran.nextInt(40)+30;
	//damage = 999999;  //for testing purposes
	 prot = ran.nextInt(15)+5;
	 health = ran.nextInt(200)+500;
	//health = 1; // Also for testing
	 dragonborn = true;
	 maxhealth=health;
	 score=0;
	// level=2000;
	 emberComplete= false;
	  orcComplete= false;
	 hydraComplete = false;
	 goblinComplete = false;
}
}
