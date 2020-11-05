import java.util.Random;


public class DragonBorn extends GameObject {
	Random ran = new Random();
DragonBorn(){
	 damage = ran.nextInt(20)+30;
	 // damage = 9999;  //for testing purposes
	 prot = ran.nextInt(15)+5;
	 health = ran.nextInt(200)+500;
//health = 1; // Also for testing
}
}
