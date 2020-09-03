import java.util.Random;


public class Elf extends GameObject {
	Random ran = new Random();
	Elf(){
	damage = ran.nextInt(5)+5;
	 prot = ran.nextInt(5);
	 speed = ran.nextInt(15)+20;
	 health = ran.nextInt(300)+200;
	 dps = ran.nextInt(40)+5;
	 hunger = ran.nextInt(40)+50;
	}
	}
