import java.util.Random;

import javax.swing.JOptionPane;

public class Enemy extends GameObject {
	Random ran = new Random();

	Enemy() {
		alive = true;
	}

	void draw() {
		health = ran.nextInt(70) + 30;
		damage = ran.nextInt(70) + 30;

	}

	void update(GameObject g) {
	}

	void round(GameObject g, String Creature) {

		int characterdamage = g.damage;
		int gruntdamage = damage;
		while (alive&&g.alive) {
			damage -= g.prot;
			g.doDamage(damage);
			if(!g.alive){
				break;
			}
			System.out.println("You took " + damage + " damage, you have "
					+ g.health + " Left");
			damage = gruntdamage;
			damage -= g.prot;

			int task = JOptionPane.showOptionDialog(null, "Choose your move",
					"BATTLE", 0, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Big Hit (50% percent chance of missing)",
							"Strike (100% chance of hitting)" }, null);
			if (task == 0) {
				Random ran = new Random();
				int i = ran.nextInt(2);
				if (i == 1) {
					if (g.damage < 0) {
						g.damage = 0;
					}
					g.damage = g.damage * 2;
					g.damage -= prot;
					doDamage(g.damage);
					System.out.println("You dealt " + g.damage + " damage, "
							+ Creature + " has " + health + " Health Left");
					g.damage = characterdamage;
				}
			}
			if (task == 1) {

				g.damage -= prot;
				if (g.damage < 0) {
					g.damage = 0;
				}

				System.out.println("You dealt " + g.damage + " damage, the "
						+ Creature + " has " + health + " Health Left");
				g.damage = characterdamage;
			}
		}

	}
}
