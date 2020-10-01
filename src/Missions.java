import javax.swing.JOptionPane;

public class Missions extends GameObject {
	Enemy[] goblins = new Enemy[10];
	Enemy[] orcs = new Enemy[5];
	Enemy hydra = new Enemy();

	final int GOBlINS = 0;
	final int HYDRA = 1;
	final int DRAGON = 0;
	final int ORCS = 1;

	Missions(GameObject g) {
	}

	void killEmber(GameObject g) {
		if (g.location == 1) {
			int task = JOptionPane.showOptionDialog(null,
					"Where do you want to go", "Dark Forest", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Ember", "Orcs" }, null);
			if (task == DRAGON) {
				Fight fight = new Fight();
				// System.out.println("here");
				fight.draw();
				fight.alive = true;
				while (fight.alive) {
					fight.round(g);
					if (g.health == 0 || g.health < 0) {
						g.alive = false;
						break;
					} else if (fight.health == 0 || fight.health < 0) {
						alive = false;
						int mercy = JOptionPane.showOptionDialog(null,
								"Do you wish to spare Ember", "Dark Forest", 0,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "Spare", "Kill" }, null);
						if (mercy == 0) {
							JOptionPane
									.showMessageDialog(
											null,
											"Ember spreads his wings incinerates you. He whispers I will not be killed by the likes of you. ");
							break;
						} else {
							JOptionPane
									.showMessageDialog(null,
											"The great dragons body lies motionless. His gold is now yours.");
							g.money += 10000;
						}
					}
					// System.out.println("Working");'
					if (g.alive == false) {
						break;
					}
				}

			}
			if (task == ORCS) {
				// System.out.println("Working");
				for (int i = 0; orcs.length > i; i++) {
					orcs[i] = new Enemy();
					orcs[i].draw();
				}
				while (g.alive) {
					for (int i = 0; orcs.length > i; i++) {
						orcs[i].round(g);
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

				// System.out.println("Working");
				for (int i = 0; goblins.length > i; i++) {
					goblins[i] = new Enemy();
					goblins[i].draw();
				}
				while (g.alive) {
					for (int i = 0; goblins.length > i; i++) {
						goblins[i].round(g);
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
					}
					break;
				}

			}
if(task == HYDRA){


	// System.out.println("Working");
	
		hydra = new Enemy();
		hydra.draw();
	hydra.health = 600;
	hydra.damage = 50;
	while (g.alive) {
			hydra.round(g);
			//g.health-= 30;
			if (g.health == 0 || g.health < 0) {
				g.alive = false;
				break;
			} else if (hydra.health == 0
					|| hydra.health < 0) {
				alive = false;
				int mercy = JOptionPane.showOptionDialog(null,
						"Do you wish to spare the goblin",
						"Dark Forest", 0,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "Spare", "Kill" }, null);
				if (mercy == 0) {
					JOptionPane
							.showMessageDialog(null,
									"The Hydra slithers off annoyed");
					break;
				}
				else if(mercy==1){
					JOptionPane
					.showMessageDialog(null,
							"The Heads laughs cruely as its poisonous blood spills, killing you. The hydra smiles knowing it will live...                                                             when you restart.");
			break;
				}

			
		}
		break;
	}


}
		}
	}

}
