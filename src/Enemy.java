import java.util.Random;

import javax.swing.JOptionPane;

public class Enemy extends GameObject {
	boolean loop=true;
	Random ran = new Random();

	Enemy() {
			}

	void draw() {
		health = ran.nextInt(70) + 30;
		damage = ran.nextInt(70) + 30;
		alive = true;


	}

	void update(GameObject g) {
	}

	void round(GameObject g, String Creature) {

		int characterdamage = g.damage;
		int gruntdamage = damage;
		while (alive&&g.alive) {
			damage -= g.prot;
			g.doDamageEnemy(damage);
			if(!g.alive){
				GamePanel.currentState= GamePanel.END;
				break;
			}
			JOptionPane.showMessageDialog(null,"The enemy swings dealing " + damage + " damage, you have "
					+ g.health + " health left");
			damage = gruntdamage;
			damage -= g.prot;
			loop=true;
while(loop) {
			int move = JOptionPane.showOptionDialog(null, "Choose your move",
					"BATTLE", 0, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Big Hit (50% percent chance of missing)",
							"Strike (100% chance of hitting)", "heal ", "quit" }, null);
			if (move == 0) {
				Random ran = new Random();
				int i = ran.nextInt(2);
				if (i == 1) {
					if (g.damage < 0) {
						g.damage = 0;
					}
					g.damage = g.damage * 2;
					g.damage -= prot;
					doDamageEnemy(g.damage);
					if(health<=0) {
						JOptionPane.showMessageDialog(null,"You have beaten your enemy.");
					}
					else {
					JOptionPane.showMessageDialog(null,"You swing your sword wildly connecting with your enemies flesh. It deals " + g.damage + " damage, "
							+ Creature + " has " + health + " Health Left");
					}
					g.damage = characterdamage;
				}
				else{
					JOptionPane.showMessageDialog(null,"You swing wildly throwing you off balance and missing your strike.");
				}
				loop=false;
			}
			if (move == 1) {

				g.damage -= prot;
				if (g.damage < 0) {
					g.damage = 0;
				}
				doDamageEnemy(g.damage);
				if(health<=0) {
					JOptionPane.showMessageDialog(null,"You have beaten your enemy.");
				}
				else {
JOptionPane.showMessageDialog(null,"You swing your sword with swift strokes dealing " + g.damage + " damage, "
		+ Creature + " has " + health + " Health Left");
				}
				g.damage = characterdamage;
				loop=false;

			}
			if(move==2){
				if(g.rations<=0){
					JOptionPane.showMessageDialog(null, "No food left");
				}
				g.health+=damage;
				g.changeHealth(-50);
				g.rations-=1;
				if(g.health>g.maxhealth) {
					JOptionPane.showMessageDialog(null, "You grab a quick bite while dodging attacks.. You now have "+g.maxhealth+" health");
					
				}
				else {
					JOptionPane.showMessageDialog(null, "You grab a quick bite while dodging attacks.. You now have "+g.health+" health");
				}
				loop=false;
			}
			if(move==3) {
				int quit = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
			if (quit==0) {
				
				System.exit(g.health);

			}	
			else {
				loop=true;
			}
			}
			
		}
		}

	}
}
