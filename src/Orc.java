import java.util.Random;


public class Orc extends GameObject {
	Random ran = new Random();
Orc(){
	 damage = ran.nextInt(20)+30;
	 prot = ran.nextInt(10)+5;
	 speed = ran.nextInt(15)+10;
	 health = ran.nextInt(600)+200;
	 dps = ran.nextInt(10)+5;
	 hunger = ran.nextInt(40)+40;
}
}