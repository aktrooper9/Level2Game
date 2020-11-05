import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
	String name;
	static	final int MENU = 0;
	static	final int GAMEINTRO = 1;
	static	final int GAME = 2;
	static	final int MAP = 3;
	static	final int END = 4;
	Stack<String> actions = new Stack<String>();
	static int currentState = 0;
	// Timer framedraw;
	JButton play = new JButton("play");
	JButton store = new JButton("store");
	JButton quests = new JButton("quests");
	JButton town = new JButton("Town");
	JButton dark = new JButton("Dark Forest :Orcs: ");
	JButton goblins = new JButton("The Goblin Hideout");
	JButton map = new JButton("Map");
	JButton heal = new JButton("Heal");
	JButton instructions = new JButton("Instructions ");

	String creature;
	GameObject player;
	Missions m = new Missions(player);
MissionComplete c = new MissionComplete(player);
	GamePanel() {
		play.addActionListener(this);
		store.addActionListener(this);
		quests.addActionListener(this);
		map.addActionListener(this);
		dark.addActionListener(this);
		town.addActionListener(this);
		goblins.addActionListener(this);
		heal.addActionListener(this);
		instructions.addActionListener(this);

		// framedraw = new Timer(1000 / 60, this);
		add(play);
		add(store);
		add(quests);
		add(map);
		add(town);
		add(dark);
		add(goblins);
		add(heal);
		add(instructions);

		// framedraw.start();

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAMEINTRO) {
			drawGameIntroState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == MAP) {
			drawMapState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
		// System.out.println(currentState);
		drawActions(g);
	}

	void updateMenuState() {

	}

	void updateGameIntroState() {

	}

	void updateGameState() {

	}

	void updateMapState() {

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		play.setVisible(true);
		instructions.setVisible(true);
		quests.setVisible(false);
		store.setVisible(false);
		town.setVisible(false);
		dark.setVisible(false);
		goblins.setVisible(false);
		heal.setVisible(false);
		map.setVisible(false);

	}

	void drawActions(Graphics g) {
		// System.out.println("actions");
		g.setColor(Color.black);
		String status = "";
		for (int i = 0; i < actions.size(); i++) {
			status += actions.get(i);
			status += ". ";
		}
		g.drawString(status, 50, GameRunner.HEIGHT - 50);
	}

	void drawGameIntroState(Graphics g) {

		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);

		play.setVisible(false);
		drawActions(g);
	}

	void drawGameState(Graphics g) {
		map.setVisible(true);
		quests.setVisible(true);
		store.setVisible(true);
		heal.setVisible(true);
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		if (!player.alive) {
			currentState = MENU;

		}

		// System.out.println("HI");
		// repaint();
	}

	void drawEndState(Graphics g) {
		// System.out.println("end");

	}

	void drawMapState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);

		// System.out.println("map");
		quests.setVisible(false);
		store.setVisible(false);
		town.setVisible(true);
		dark.setVisible(true);
		heal.setVisible(true);
		goblins.setVisible(true);
		// System.out.println("HI");
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// repaint();

		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.equals(play)) {
			// actions.push("play");
			// currentState++;
			boolean success = false;
			while (!success) {

				creature = JOptionPane
						.showInputDialog("Choose  orcs, elves, and dragonborns,");
				if (creature.equalsIgnoreCase("orc")
						|| creature.equalsIgnoreCase("orcs")) {
					player = new Orc();
					success = true;
					player.alive = true;
				} else if (creature.equalsIgnoreCase("elf")
						|| creature.equalsIgnoreCase("elves")) {
					player = new Elf();
					success = true;
					player.alive = true;

				} else if (creature.equalsIgnoreCase("dragonborn")
						|| creature.equalsIgnoreCase("dragonborns")) {
					player = new DragonBorn();
					success = true;
					player.alive = true;

				} else {
					JOptionPane.showMessageDialog(null, creature
							+ " does not compute");

				}
			}
			JOptionPane.showMessageDialog(null, "Damage: " + player.damage
					+ "\nArmor: " + player.prot + " health: " + player.health);
			player.name = JOptionPane.showInputDialog("Choose a name");
			JOptionPane.showMessageDialog(null, "You are " + player.name
					+ " of the " + creature);
			currentState = GAME;
			
			player.rations+=20;
		}
		if (buttonPressed.equals(store)) {
			// actions.push("Store");
			int Purchasable = JOptionPane.showOptionDialog(null,
					"What would you like to buy", "Shop", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Broad Sword: 5 gold", "Great Club: 6 gold", "Claymore: 6 gold", "Shield: 5 gold",
							"Armor: Gold", "Food: 1 gold","Quit" }, null);
			if (Purchasable == 0) {
				player.money -= 5;
				if (player.money <= 0) {
					JOptionPane.showMessageDialog(null, "Not enough money");
					player.money += 5;
				} else {
					new BroadSword(player);
					JOptionPane.showMessageDialog(null, "Congratulations on your new Weapon");
				}
				// System.out.println(player.damage);
			} else if (Purchasable == 1) {
				player.money -= 6;
				if (player.money <= 0) {
					JOptionPane.showMessageDialog(null, "Not enough money");
					player.money += 6;
				} else {
					new GreatClub(player);
					JOptionPane.showMessageDialog(null, "Congratulations on your new Weapon");

				}
				// System.out.println(player.damage);
			} else if (Purchasable == 2) {
				player.money -= 6;
				if (player.money <= 0) {
					JOptionPane.showMessageDialog(null, "Not enough money");
					player.money += 6;
				} else {
					new Claymore(player);
					JOptionPane.showMessageDialog(null, "Congratulations on your new Weapon");

				}
				// System.out.println(player.damage);
			} else if (Purchasable == 3) {
				player.money -= 5;
				if (player.money <= 0) {
					JOptionPane.showMessageDialog(null, "Not enough money");
					player.money += 5;
				} else {
					new Shield(player);
					JOptionPane.showMessageDialog(null, "Congratulations on your new shield");

				}
				// System.out.println(player.damage);
			} else if (Purchasable == 4) { //

				player.money -= 10;
				if (player.money <= 0) {
					JOptionPane.showMessageDialog(null, "Not enough money");
					player.money += 10;
				} else {
					new Armor(player);
					JOptionPane.showMessageDialog(null, "Congratulations on your new Armor");

				}}
				// System.out.println(player.damage);
				else if (Purchasable == 5) { //

					player.money -= 1;
					if (player.money <= 0) {
						JOptionPane.showMessageDialog(null, "Not enough money");
						player.money += 1;
					} else {
						player.rations+=1;
						JOptionPane.showMessageDialog(null, "You have bought one more Ration");

					}
				// System.out.println(player.damage);
			} else if (Purchasable == 6) { // Quit
				// System.out.println(player.damage);
				actions.pop();
				currentState += 1;
				currentState -= 1;
			}
		}
		if (buttonPressed.equals(quests)) {
			c.run(player);
		}

		if (buttonPressed.equals(town)) {
			player.location = 0;
			currentState = GAME;
			town.setVisible(false);
			dark.setVisible(false);
			goblins.setVisible(false);
			map.setVisible(true);

		} else if (buttonPressed.equals(dark)) {
			player.location = 1;
			m.killEmber(player);
			town.setVisible(false);
			dark.setVisible(false);
			goblins.setVisible(false);
			map.setVisible(true);

		} else if (buttonPressed.equals(goblins)) {
			player.location = 2;
			m.goblin(player);
			town.setVisible(false);
			dark.setVisible(false);
			goblins.setVisible(false);
			map.setVisible(true);

		}

		else if (buttonPressed.equals(map)) {
			currentState = MAP;

		}
		else if(buttonPressed.equals(instructions)){
			System.out.println("Instructions");
			int instruct = JOptionPane.showOptionDialog(null, "Instructions",
					"Instructing ", 0, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Moving","Combat","Quit" }, null);
			if(instruct==0){
				JOptionPane.showMessageDialog(null, "Click on the store to buy items. Click on the quests to see possible jobs.  "
						+ "Click on the map to find all the places you need to go");
			}
			if(instruct==1){
				JOptionPane.showMessageDialog(null, "When in fights you may use a basic attack which will always hit "
						+ "or a big attack which has a 50% chance of striking. You may also choose to heal your character with rations, however you will lose the chance to strike.");
			}

		}
		
		else if(buttonPressed.equals(heal)){

			if(player.rations<=0){
				JOptionPane.showMessageDialog(null, "No food left");
			}
			else{
			player.health+=50;
			player.rations-=1;
			JOptionPane.showMessageDialog(null, "The delicous food is a most welcome guest. You now have "+player.health+" health");
			}
		
		}
		else 		if (!player.alive) {
			JOptionPane.showMessageDialog(null, "You lose");
			currentState = 0;
		}
		
		repaint();
	}

}
