import java.util.Random;


public class DragonBorn extends GameObject {
	Random ran = new Random();
DragonBorn(){
	 damage = ran.nextInt(20)+30;
	 prot = ran.nextInt(15)+5;
	 speed = ran.nextInt(15)+5;
	 health = ran.nextInt(200)+500;
	 dps = ran.nextInt(30)+5;
	 hunger = ran.nextInt(40)+100;
}
}