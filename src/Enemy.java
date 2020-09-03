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
}
	

