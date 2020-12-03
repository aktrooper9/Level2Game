import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	public static BufferedImage townImage;
	 public static BufferedImage mapImage;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	static final int MENU = 0;
	static final int GAMEINTRO = 1;
	static final int GAME = 2;
	static final int MAP = 3;
	static final int END = 4;
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
	JLabel health = new JLabel();
	JLabel xp = new JLabel();
	JButton mountains = new JButton(":Locked:");
	JButton hydra = new JButton(":Locked:");

	String creature;
	GameObject player;
	Missions m = new Missions(player);
	MissionComplete c = new MissionComplete(player);

	GamePanel() {
		play.add(health);
		play.addActionListener(this);
		store.addActionListener(this);
		quests.addActionListener(this);
		map.addActionListener(this);
		dark.addActionListener(this);
		town.addActionListener(this);
		goblins.addActionListener(this);
		heal.addActionListener(this);
		instructions.addActionListener(this);
		mountains.addActionListener(this);
		hydra.addActionListener(this);

		// framedraw = new Timer(1000 / 60, this);
		add(play);
		add(store);
		add(quests);
		add(map);
		add(town);
		add(dark);
		add(goblins);
		add(heal);
		add(mountains);
		add(instructions);
		add(health);
		add(xp);
		add(hydra);
			townImage=loadImage("Town.jpg");
			mapImage=loadImage("Map.png");
		// framedraw.start();

	}

	// paintcompoenent likely causing lag
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
		mountains.setVisible(false);
		hydra.setVisible(false);

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
		play.setVisible(false);
		map.setVisible(true);
		quests.setVisible(true);
		store.setVisible(true);
		heal.setVisible(true);
		mountains.setVisible(false);
		hydra.setVisible(false);
		//
		quests.setLocation(380, 65);
		store.setLocation(250, 350);
		map.setLocation(180, 180);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		if (!player.alive) {
			currentState = MENU;

		}
		if (townImage!=null) {
			g.drawImage(townImage, 0, 0, GameRunner.WIDTH, GameRunner.HEIGHT, null);
		} else {
			System.out.println("noimage");
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
		// System.out.println("HI");
		// repaint();
	}

	BufferedImage loadImage(String imageFile) {

		try {
			return ImageIO
					.read(this.getClass().getResourceAsStream(imageFile));
		} catch (Exception e) {
			System.out.println("Cannot load image "+imageFile);
		}
		return null;
	}

	void drawEndState(Graphics g) {
		// System.out.println("end");

	}

	void drawMapState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);

		//player.level= 30; //testing
		// System.out.println("map");
		play.setVisible(false);

		quests.setVisible(false);
		store.setVisible(false);
		town.setVisible(true);
		town.setLocation(700, 350);
		dark.setVisible(true);
		dark.setLocation(508, 242);
		heal.setVisible(true);
		goblins.setVisible(true);
		goblins.setLocation(170, 140);
		mountains.setVisible(true);
		mountains.setLocation(267, 700);
		hydra.setVisible(true);
		hydra.setLocation(620, 550);
		if(player.level>=10){
			mountains.setText("The Mountains: Dragons");
			hydra.setText("The Swamp: Hydra");
		}
		
		else if(player.level>=5){
			hydra.setText("The Swamp: Hydra");
		}
		else if(player.level<5){
			hydra.setText(":Locked:");
			mountains.setText(":Locked:");
		}
		
		
		
		// System.out.println("HI");
		if (mapImage!=null) {
			g.drawImage(mapImage, 0, 0, GameRunner.WIDTH, GameRunner.HEIGHT, null);
		} else {
			System.out.println("noimage");
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// repaint()
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed.equals(play)) {
			// actions.push("play");
			// currentState++;
			// boolean success = false;
			// while (!success) {

			creature = JOptionPane.showInputDialog(null,
					"Choose your race;  Orc, elf, Dragonborn  ",
					"Character Creation", JOptionPane.INFORMATION_MESSAGE);
			if (creature.equalsIgnoreCase("orc")
					|| creature.equalsIgnoreCase("orcs")) {
				player = new Orc();
				// success = true;
				player.alive = true;
			} else if (creature.equalsIgnoreCase("elf")
					|| creature.equalsIgnoreCase("elves")) {
				// player = new Elf();
				// success = true;
				player.alive = true;

			} else if (creature.equalsIgnoreCase("dragonborn")
					|| creature.equalsIgnoreCase("dragonborns")) {
				player = new DragonBorn();
				// success = true;
				player.alive = true;

			} else {
				JOptionPane.showMessageDialog(null, creature
						+ " does not compute");

			}
			JOptionPane.showMessageDialog(null, "Your stats are \nDamage: "
					+ player.damage + "\nArmor: " + player.prot + " \nhealth: "
					+ player.health, "Stats", JOptionPane.INFORMATION_MESSAGE);
			player.name = JOptionPane.showInputDialog("Choose your name");
			JOptionPane.showMessageDialog(null, "You are " + player.name
					+ " of the " + creature);
			currentState = GAME;

			player.rations += 20;
		}

		// }
		if (buttonPressed.equals(store)) {
			Shop shop = new Shop();
			// actions.push("Store");
			if(player.emberComplete=true){
				int sell = JOptionPane.showOptionDialog(null,
						"Selling or buying "+player.name+" dragonslayer", "Shop", 0,
						JOptionPane.INFORMATION_MESSAGE, null, new String[] {
								"Buying","Selling" }, null);
			}
			shop.shop(player);
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
			//player.location = 1;
			m.orcKiller(player);
			town.setVisible(false);
			dark.setVisible(false);
			goblins.setVisible(false);
			map.setVisible(true);

		} else if (buttonPressed.equals(goblins)) {
			//player.location = 2;
			m.goblin(player);
			town.setVisible(false);
			dark.setVisible(false);
			goblins.setVisible(false);
			map.setVisible(true);

		}
	 else if (buttonPressed.equals(mountains)) {
		 if(player.level>10||player.level==10){
		//player.location = 1;
		m.killEmber(player);
		town.setVisible(false);
		dark.setVisible(false);
		goblins.setVisible(false);
		map.setVisible(true);
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "You are not high enough level");
			 
		 }
	}
	 else if (buttonPressed.equals(hydra)) {
		 if(player.level>5||player.level==5){
		//player.location = 1;
		m.hydra(player);
		town.setVisible(false);
		dark.setVisible(false);
		goblins.setVisible(false);
		map.setVisible(true);
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "You are not high enough level");
			 
		 }
	}

		else if (buttonPressed.equals(map)) {
			currentState = MAP;

		} else if (buttonPressed.equals(instructions)) {
			System.out.println("Instructions");
			int instruct = JOptionPane.showOptionDialog(null, "Instructions",
					"Which would you like to learn about, ", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Moving", "Combat", }, null);
			if (instruct == 0) {
				JOptionPane
						.showMessageDialog(
								null,
								"Click on the store to buy items. \nClick on the quests to see possible jobs.  "
										+ "\nClick on the map to find all the places you need to go",
								"Intro", JOptionPane.INFORMATION_MESSAGE);
			}
			if (instruct == 1) {
				JOptionPane
						.showMessageDialog(
								null,
								"When in fights you may use a basic attack which will always hit "
										+ "/nor a big attack which has a 50% chance of striking. /nYou may also choose to heal your character with rations, however you will lose the chance to strike.",
								"Intro", JOptionPane.INFORMATION_MESSAGE);
			}

		}

		else if (buttonPressed.equals(heal)) {

			if (player.rations <= 0) {
				JOptionPane.showMessageDialog(null, "No food left");
			} else {
				player.health += 50;
				player.rations -= 1;
				JOptionPane.showMessageDialog(null,
						"The delicous food is a most welcome guest. You now have "
								+ player.health + " health", "Food",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else if (!player.alive) {
			JOptionPane.showMessageDialog(null, "You lose", "lose",
					JOptionPane.INFORMATION_MESSAGE);
			currentState = 0;
		}

		repaint();
		String hp = String.valueOf(player.health);
	
		health.setForeground(Color.WHITE);
		String xP = String.valueOf( player.xp);
		xp.setText(xP);
		int exp = Integer.parseInt(xP);
		xp.setForeground(Color.WHITE);
		player.levelup(exp, player);
		health.setText("health: " + hp+ "  experience: "+exp);
	}

}
