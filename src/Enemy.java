import java.util.Random;

import javax.swing.JOptionPane;


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
		health-=damage;
		if(health==0||health<0){
			alive = false;
		}
	}
	void round(GameObject g){
		
int characterdamage = g.damage;
int emberdamage = damage;
		while(alive){
		damage-=g.prot;
		g.health-=damage;
		System.out.println("You took "+damage+" damage, you have "+g.health+" Left");
		damage = emberdamage;
		 int task = JOptionPane.showOptionDialog(null, "Choose your move", "BATTLE", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{ "Big Hit (50% percent chance of missing)", "Strike (100% chance of hitting)"}, null);
		if(task == 0){
			Random ran = new Random();
			int i = ran.nextInt(2);
			if(i==1){
				if(g.damage < 0){
					g.damage = 0;
				}
				g.damage=g.damage*2;
				 g.damage-=prot;
				 health-=g.damage;
					System.out.println("You dealt "+g.damage+" damage, Ember has "+health+" Health Left");
					 g.damage= characterdamage;
			}
		}
		if(task==1){
			
		 g.damage-=prot;
		if(g.damage < 0){
			g.damage = 0;
		}
		
		System.out.println("You dealt "+g.damage+" damage, the Ember has "+health+" Health Left");
		g.damage = characterdamage;
		}
		health-=damage;
		if(health==0||health<0){
			alive = false;
		}
		
		
		}
		}
}
	

