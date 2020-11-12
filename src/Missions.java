import javax.swing.JOptionPane;

public class Missions extends GameObject {
	Enemy[] goblins = new Enemy[10];
	Enemy[] orcs = new Enemy[5];
	Enemy hydra = new Enemy();
	Enemy ember = new Enemy();
	Enemy ember2 = new Enemy();

	final int GOBlINS = 0;
	final int HYDRA = 1;
	final int DRAGON = 0;
	final int ORCS = 1;

	Missions(GameObject g) {
		ember = new Enemy();
		ember.draw();
		ember.health = 300;
		ember.damage = 50;
		ember.prot = 20;
	}

	void killEmber(GameObject g) {
		int Darkforest= 0;
		if (g.location == 1) {
		
		 Darkforest = JOptionPane.showOptionDialog(null,
					"Where do you want to go", "Dark Forest", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Ember", "Orcs" }, null);
		 if (Darkforest == DRAGON) {
		 if ( ember.alive==false) {
				JOptionPane.showMessageDialog(null,
						"You have already killed Ember.");
				int visit = JOptionPane.showOptionDialog(null,
						"You wish to leave", "Dark Forest", 0,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "return" }, null);
				if (visit == 0) {
					JOptionPane
							.showMessageDialog(null,
									"You leave Embers cave as you have no good memories of the place.");
				}
			}
			
				
				// System.out.println("Working");
				else if (ember.alive) {
					while (ember.alive) {

						ember.round(g, "Ember");
						// g.health-= 30;
						if (!g.alive) {
							break; 
						}

						int mercy = JOptionPane.showOptionDialog(null,
								"Do you wish to spare ember", "Dark Forest", 0,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Spare", "Kill" }, null);
						if (mercy == 0) {
							JOptionPane
									.showMessageDialog(null,
											"Ember incinerates you. A dragon as great as he is won't stand for defeat. ");
							g.alive = false;
							break;
						} else if (mercy == 1) {
							JOptionPane
									.showMessageDialog(
											null,
											"The great dragon stumbles backward after the finality of the last stroke. He then falls over dead. ");
ember.alive= false;
							// System.out.println("Working");

								g.money += 99999;
								System.out.println(+g.money);
								JOptionPane.showMessageDialog(null, "you have "
										+ g.money + " gold.")
								;
								g.emberComplete= true;
						
	}
					}							// System.out.println("Working");

						}
					// System.out.println("Working");
g.location = 3;
					}


				
				
			

			else if (Darkforest == ORCS) {
				JOptionPane.showMessageDialog(null, "You walk around the dark forest before stumbling upon a group orcs");
				// System.out.println("Working");
				for (int i = 0; orcs.length > i; i++) {
					orcs[i] = new Enemy();
					orcs[i].draw();
				}
				while (g.alive) {
					for (int i = 0; orcs.length > i; i++) {
						orcs[i].round(g, "Orc");
						if (g.health == 0 || g.health < 0) {
							g.alive = false;
							break;
						} else if (enemyHealth == 0 || enemyHealth < 0) {
							alive = false;
							int mercy = JOptionPane.showOptionDialog(null,
									"Do you wish to spare the orc",
									"Dark Forest", 0,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Spare", "Kill" }, null);
							if (mercy == 0) {
								JOptionPane
										.showMessageDialog(null,
												"The orc runs off afraid and dishonered. In his haste he drops his gold");
								g.money+=1;
								JOptionPane.showMessageDialog(null, "You gained 1 gold.");
							}
							g.location = 3;
						}
						}
					g.orcComplete= true;
					break;
}
					
				}
		}
			
					
			
		}

	void goblin(GameObject g) {
		JOptionPane.showMessageDialog(null, "Travel to the goblins");
		if (g.location == 2) {

			int task = JOptionPane.showOptionDialog(null,
					"Where do you want to go", "Goblin Hideout", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Goblins", "Hydra" }, null);
			if (task == GOBlINS) {
				JOptionPane
						.showMessageDialog(null,
								"You walk around the dark forest before stumbling upon a group goblin");
				// System.out.println("Working");
				for (int i = 0; goblins.length > i; i++) {
					goblins[i] = new Enemy();
					goblins[i].draw();
				}
				while (hydra.alive) {
					for (int i = 0; goblins.length > i; i++) {
						goblins[i].round(g, "Goblin");
						if (g.health == 0 || g.health < 0) {
							g.alive = false;
							break;
						} else if (goblins[i].health == 0
								|| goblins[i].health < 0) {
							alive = false;
							int mercy = JOptionPane.showOptionDialog(null,
									"Do you wish to spare the goblin",
									"Dark Forest", 0,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "Spare", "Kill" }, null);
							if (mercy == 0) {
								JOptionPane
										.showMessageDialog(null,
												"The goblin runs off as its friends laugh. He drops what little money he has");
								;
								JOptionPane.showMessageDialog(null, "You gained 1 gold.");
							}

						}
						g.location = 3;
					}
					break;
				}

			}
			if (task == HYDRA) {
				JOptionPane.showMessageDialog(null, "You stumble upon one of goblins hydras.");

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

					int mercy = JOptionPane.showOptionDialog(null,
							"Do you wish to spare the hydra", "Dark Forest", 0,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Spare", "Kill" }, null);
					if (mercy == 0) {
						JOptionPane.showMessageDialog(null,
								"The Hydra lurches off to die");
						break;
					} else if (mercy == 1) {
						JOptionPane
								.showMessageDialog(null,
										"The Heads laughs cruely as its poisonous blood spills, killing you.");
						g.alive = false;
						break;
					}

				}
				g.location = 3;

			}

		}
		g.location = 3;

	}
}
