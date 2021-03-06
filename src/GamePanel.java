import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	 public static BufferedImage menuImage;
	 public static BufferedImage endImage;

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
	JButton mountains = new JButton(":Locked:");
	JButton hydra = new JButton(":Locked:");
	JLabel title = new JLabel("Kill a Dragon");
	Font font = new Font("Arial", Font.PLAIN, 48);
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
		add(title);
		add(health);
		add(hydra);
			townImage=loadImage("Town.jpg");
			mapImage=loadImage("Map.png");
			menuImage=loadImage("Dragon.jpg");
			endImage=loadImage("Youdied.jpg");


		// framedraw.start();

	}
	void setup() {
		title.setPreferredSize(new Dimension(800, 100));
		title.setLocation(325, 400);
		title.setForeground(Color.WHITE);
		title.setFont(font);

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
	//	g.setColor(Color.BLUE);
	//	g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
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
		title.setVisible(true);
		setup();

		if (townImage!=null) {
			g.drawImage(menuImage, 0, 0, GameRunner.WIDTH, GameRunner.HEIGHT, null);
		} else {
			System.out.println("noimage");
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
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
		title.setVisible(false);

		
		
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
		health.setForeground(Color.RED );
		font = new Font("Arial", Font.PLAIN, 90);
		health.setText("Your final score was "+player.score);

		
		System.out.println("end");
		if (townImage!=null) {
			g.drawImage(endImage, 0, 0, GameRunner.WIDTH, GameRunner.HEIGHT, null);
		} else {
			System.out.println("noimage");
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, WIDTH, HEIGHT);
		}
	}

	void drawMapState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);

		//player.level= 30; //testing
		// System.out.println("map");
		play.setVisible(false);
		//player.level=100;
title.setVisible(false);
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
			m.ember();
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
			if(player!=null) {
				JOptionPane.showMessageDialog(null, "Your stats are \nDamage: "
						+ player.damage + "\nArmor: " + player.prot + " \nhealth: "
						+ player.health, "Stats", JOptionPane.INFORMATION_MESSAGE);
				player.name = JOptionPane.showInputDialog("Choose your name");
				JOptionPane.showMessageDialog(null, "You are " + player.name
						+ " of the " + creature);
				currentState = GAME;

				player.rations += 20;
			}
			
		}
		else if(!player.alive) {
			currentState=END;
		}
		// }
		if (buttonPressed.equals(store)) {
			Shop shop = new Shop();
			
			// actions.push("Store");
			if(player.emberComplete){
				int sell = JOptionPane.showOptionDialog(null,
						"Selling or buying "+player.name+" dragonslayer", "Shop", 0,
						JOptionPane.INFORMATION_MESSAGE, null, new String[] {
								"Buying","Selling" }, null);
				if(sell==0){
					shop.shop(player);
				}
				if(sell==1){
					shop.sell(player);
				}
			}
			else{
			shop.shop(player);
			}
			}
		if (buttonPressed.equals(quests)) {
			c.run(player);
		}

		if (buttonPressed.equals(town)) {
			System.out.println("Town");
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
			JOptionPane.showMessageDialog(null, "Click play to begin. \n You will first make your character."
					+ "\n Go to the map to travel to different places.\n You may buy items from the shop for gold."
					+ "\n You can get gold by completing the Missions stated at the quests."
					+ "\n Fight Monsters by going to the locations on the map"
					+ "\n You have two attacks; A small hit which alwasy hits, A big hit which only hits half the time."
					+ "\n Spare them for gold, or kill them to gain Experience"
					+ "\n Your health level and experience are shown on the top of the frame"
					+ "\n Try to get t,he highest score possible", "Instructions", JOptionPane.INFORMATION_MESSAGE);
		
	/*
			int instruct = JOptionPane.showOptionDialog(null, "Instructions",
					"Which would you like to learn about, ", 0,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] {
							"Basics", }, null);
if(instruct==0) {
	
}
if(instruct==1) {
	
}
*/
		}

		else if (buttonPressed.equals(heal)) {

			if (player.rations <= 0) {
				JOptionPane.showMessageDialog(null, "No food left");
			} else {
				player.changeHealth(-50);
				player.rations -= 1;
				if(player.health>player.maxhealth) {
					player.health=player.maxhealth;
				}
				JOptionPane.showMessageDialog(null,
						" You now have "
								+ player.health + " health", "Food",
						JOptionPane.INFORMATION_MESSAGE);
			}
		
			
		} else if (currentState==END) {
		//	System.out.println("ELSE");
			
			JOptionPane.showMessageDialog(null, "You lose", "lose",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		repaint();

	if(player!=null){
		font = new Font("Arial", Font.PLAIN, 48);
		if(currentState>1&&currentState<4) {
	//	int score = player.score;
		health.setForeground(Color.WHITE );
		String xP = String.valueOf( player.xp);
		int exp = Integer.parseInt(xP);
		player.levelup(exp);
		health.setText("health: " + player.health+ " Level: "+player.level+"  experience: "+exp+" Score: "+player.score +" Gold: "+player.money);
	}
		
	}
	}

}
