import java.util.Random;


public class Enemy extends GameObject{

	Enemy(){
	}
	void draw(){
		Random ran = new Random();
		enemyHealth = ran.nextInt(30-100);
		damage = ran.nextInt(30-500);
		alive = true;
	}
	
	
	void update(){
		enemyHealth-=damage;
		if(enemyHealth==0||enemyHealth<0){
			alive = false;
		}
	}
	void round(GameObject g){
		damage-=g.prot;
		g.health-=damage;
		System.out.println("You took "+damage+" damage, you have "+g.health+" Left");
		g.damage-=prot;
		System.out.println("You dealt "+g.damage+" damage, Ember has "+health+" Left");
		enemyHealth-=g.damage;
	}
}
	

