import java.util.Random;


public class Orc extends GameObject {
	Random ran = new Random();
Orc(){
	 damage = ran.nextInt(20)+30;
	 prot = ran.nextInt(10)+5;

	 health = ran.nextInt(600)+200;
	 maxhealth=health;
	 score=0;
	 emberComplete= false;
	  orcComplete= false;
	 hydraComplete = false;
	 goblinComplete = false;
}
}
