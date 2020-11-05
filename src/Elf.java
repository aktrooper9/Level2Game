import java.util.Random;


public class Elf extends GameObject {
	Random ran = new Random();
	Elf(){
	damage = ran.nextInt(30)+5;
	 prot = ran.nextInt(5);

	 health = ran.nextInt(300)+200;

	}
	}
