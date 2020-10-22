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
	}

	void killEmber(GameObject g) {
		if (g.location == 1) {
			int Darkforestplace = JOptionPane.showOptionDialog(null,
					"Where do you want to go", "Dark Forest", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Ember", "Orcs" }, null);
			if (Darkforestplace == DRAGON) {

				// System.out.println("Working");

				ember = new Enemy();
				ember.draw();
				ember.health = 300;
				ember.damage = 50;
				ember.prot= 20;
				while (ember.alive) {

					ember.round(g, "Ember");
					// g.health-= 30;
					if(!g.alive){
						break;
					}
					
					
					int mercy = JOptionPane.showOptionDialog(null,
							"Do you wish to spare ember", "Dark Forest", 0,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Spare", "Kill" }, null);
					if (mercy == 0) {
						JOptionPane.showMessageDialog(null,
								"Ember incinerates you. A dragon as great as he is won't stand for defeat. ");
						g.alive=false;
						break;
					} else if (mercy == 1) {
						JOptionPane
								.showMessageDialog(
										null,
										"The great dragon stumbles backward after the finality of the last stroke. He is consumed by rage and becomes a demon ");
						
						


						// System.out.println("Working");

						ember2 = new Enemy();
						ember2.draw();
						ember2.health = 300;
						ember2.damage = 50;
						ember2.prot= 20;
						while (ember2.alive) {

							ember2.round(g, "Ember");
							// g.health-= 30;
							if(!g.alive){
								break;
							}
							JOptionPane.showMessageDialog(null, "The demons poisoned blood spills. It rears its head back in rage before collapsing to the ground. With its protector gone, you get his gold");
							g.money+=99999;
							System.out.println(+g.money);
							JOptionPane.showMessageDialog(null, "you have "+g.money+ " gold.")
							
							
							;
							

								// System.out.println("Working");


							
							}

						}

					

						// System.out.println("Working");


					
					}
				g.location=3;
				}
				

			
		else if (Darkforestplace == ORCS) {
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
												"The orc runs off afraid and dishonered ");
								break;
							}

						}
					}
					break;
				}
			g.location=3;
			}}

		}
	

	void goblin(GameObject g) {
		JOptionPane.showMessageDialog(null, "Travel to the goblins");
		if (g.location == 2) {

			int task = JOptionPane.showOptionDialog(null,
					"Where do you want to go", "Goblin Hideout", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Goblins", "Hydra" }, null);
			if (task == GOBlINS) {

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
												"The goblin runs off as its friends laugh");
								;
							}

						}
						g.location=3;
					}
					break;
				}
				

			}
			if (task == HYDRA) {

				// System.out.println("Working");

				hydra = new Enemy();
				hydra.draw();
				hydra.health = 600;
				hydra.damage = 50;
				while (hydra.alive) {

					hydra.round(g, "Hydra");
					// g.health-= 30;
					if(!g.alive){
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
								.showMessageDialog(
										null,
										"The Heads laughs cruely as its poisonous blood spills, killing you.");
						g.alive=false;
						break;
					}

				}
				g.location=3;

			}

		}
		g.location=3;

	}
}
