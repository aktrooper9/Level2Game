import java.util.Random;

import javax.swing.JOptionPane;

public class Missions extends GameObject {
	Enemy[] goblins = new Enemy[5];
	Enemy[] orcs = new Enemy[4];
	Enemy hydra = new Enemy();
	Enemy ember = new Enemy();
	Enemy wyvern = new Enemy();

	final int GOBlINS = 0;
	final int HYDRA = 1;
	final int DRAGON = 0;
	int wyverns = 0;
	int lines = 0;

	Missions(GameObject g) {
		ember.alive=true;
		ember.draw();
		ember.health = 900;
		ember.damage = 90;
		ember.prot = 25;	
		
	}

	void ember() {
		ember.alive=true;
		ember.draw();
		ember.health = 900;
		ember.damage = 90;
		ember.prot = 25;
	}
	
	void killEmber(GameObject g) {
	
		if (ember.alive == false) {

			int visit = JOptionPane.showOptionDialog(null, "You may fight other lesser wyverns", "Wyvern", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] { "return", "wyverns" }, null);
			if (visit == 0) {
				g.location = 3;
			}
			if (visit == 1) {
				wyverns += 1;
				if (wyverns == 1) {
					JOptionPane.showMessageDialog(null,
							"The mountains are now covered with wyverns.\n They are smaller then the dragons"
									+ "\n but a full set of scales are worth a fortune");
				}
					JOptionPane.showMessageDialog(null,
							"A wyvern swoops down in front of you baring its teeth in a challenge");

					System.out.println("Working");

					wyvern = new Enemy();
					wyvern.draw();
					wyvern.health = 300;
					wyvern.damage = 50;
					wyvern.prot=5;
					while (wyvern.alive) {

						wyvern.round(g, "wyvern");
						// g.health-= 30;
						if (!g.alive) {
							break;
						}

						int mercy = JOptionPane.showOptionDialog(null, "Do you wish to kill the wyvern", "Wyvern", 0,
								JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Spare", "Kill" }, null);
						if (mercy == 0) {
							JOptionPane.showMessageDialog(null, "The wyvern crumbles to the floor, a lifeless husk\n You gained 5 bottles of wyvern blood");
							g.score+=50;
							g.xp += 30;
							g.blood+=5;
							JOptionPane.showMessageDialog(null, "You gained 30 experience");
							
							break;
						} else if (mercy == 1) {
							JOptionPane.showMessageDialog(null,
									"The Wyvern hisses revealing his fangs before flying off.\n You gained 5 Wyvern scales");
							g.scales+=5;
							break;
						}

					}
					g.location = 3;

				
				}
			}
	
			
		

		// System.out.println("Working");
		else if (ember.alive) {
			JOptionPane.showMessageDialog(null,
					"As you walk around the great cave, jewels clink beneath your feet\n, warriors rot away there weapons by their sides. \n A great pile"
							+ " of treasure sits at the center of the cave. ");
			JOptionPane.showMessageDialog(null,
					"A great dragon sits on his hoard watching you. \nIts dark scales glow like embers in the light.\n He then roars a spurt of red hot flames challenging you.");
			while (ember.alive) {

				ember.round(g, "Ember");
				// g.health-= 30;
				if (!g.alive) {
					break;
				}

				int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare ember", "Dark Forest", 0,
						JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Spare", "Kill" }, null);
				if (mercy == 0) {
					JOptionPane.showMessageDialog(null,
							"Ember incinerates you. A dragon as great as he is won't stand for defeat. ");
					g.alive = false;
					g.doDamageEnemy(10000);
					break;
				} else if (mercy == 1) {
					JOptionPane.showMessageDialog(null,
							"The great drake stumbles roaring, then crashes down to the \n cavern floor, the sound reverbertaing around the hall"
									+ "before fading.");
					ember.alive = false;
					// System.out.println("Working");
					g.xp += 100;
					g.score += 100;
					g.money += 99999;
					System.out.println(+g.money);
					JOptionPane.showMessageDialog(null, " you gained 99999 gold.  \nYou earned 100 experience \n"
							+ "You gained a set of dragon scale armor(protection 20)")

					;
					g.prot += 20;
					g.emberComplete = true;

				}
			} // System.out.println("Working");

		}
		// System.out.println("Working");
		g.location = 3;
	}


	void orcKiller(GameObject g1) {
		JOptionPane.showMessageDialog(null, "You walk around the dark forest before stumbling upon a group orcs");
		// System.out.println("Working");
		for (int i = 0; orcs.length > i; i++) {
			orcs[i] = new Enemy();
			orcs[i].draw();
		}
		while (g1.alive) {
			for (int i = 0; orcs.length > i; i++) {
				orcs[i].round(g1, "Orc");
				if (g1.health == 0 || g1.health < 0) {
					g1.alive = false;
					break;
				} else if (enemyHealth == 0 || enemyHealth < 0) {
					alive = false;
					int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare the orc", "Dark Forest", 0,
							JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Spare", "Kill" }, null);
					if (mercy == 0) {
						JOptionPane.showMessageDialog(null,
								"The orc runs off afraid and dishonered.");
						g1.money += 1;
						JOptionPane.showMessageDialog(null, "You gained 1 gold.");
						g1.score+=5;

					} else {
						g1.xp += 10;
						g1.score+=5;
						JOptionPane.showMessageDialog(null, "You gained 10 experience");

					}
					g1.location = 3;
				}
			}
			g1.orcComplete = true;
			break;
		}

	}

	void goblin(GameObject g) {
		JOptionPane.showMessageDialog(null, "You walk around the dark forest before stumbling upon a group goblin");
		// System.out.println("Working");
		for (int i = 0; goblins.length > i; i++) {
			goblins[i] = new Enemy();
			goblins[i].draw();
		}
		while (g.alive) {
			for (int i = 0; goblins.length > i; i++) {
				goblins[i].round(g, "Goblin");
				if (g.health == 0 || g.health < 0) {
					g.alive = false;
					break;
				} else if (goblins[i].health == 0 || goblins[i].health < 0) {
					alive = false;
					int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare the goblin", "Dark Forest", 0,
							JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Spare", "Kill" }, null);
					if (mercy == 0) {
						JOptionPane.showMessageDialog(null,
								"The goblin runs off as its friends laugh.");
						;
						JOptionPane.showMessageDialog(null, "You gained 1 gold.");
						g.score+=10;

					} else {
						g.score+=10;
						g.xp += 10;
						JOptionPane.showMessageDialog(null, "You gained 10 experience");

					}
				}
				g.location = 3;
			}
			break;
		}

	}

	void hydra(GameObject g) {
		JOptionPane.showMessageDialog(null,
				"As you blindly stumble around\n, 7 pairs of glowing eyes open/n as a hydra rears its many heads out of the moss with a hiss");

		System.out.println("Working");

		hydra = new Enemy();
		hydra.draw();
		hydra.health = 600;
		hydra.damage = 50;
		while (hydra.alive) {

			hydra.round(g, "Hydra");
			// g.health-= 30;
			if (!g.alive) {
				break;
			}

			int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare the hydra", "Dark Forest", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Spare", "Kill" }, null);
			if (mercy == 0) {
				JOptionPane.showMessageDialog(null, "The Hydra lurches off to die");
				g.score+=70;
				g.xp += 50;
				JOptionPane.showMessageDialog(null, "You gained 50 experience");
				break;
			} else if (mercy == 1) {
				JOptionPane.showMessageDialog(null,
						"The Heads laughs cruely as its poisonous blood spills, killing you.");
				g.alive = false;
				break;
			}

		}
		g.location = 3;

	}

}
