import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements ActionListener{
	String name;
	   final int MENU = 0;
    final int GAMEINTRO = 1;
    final int GAME = 2;
    final int MAP = 3;
    final int END = 4;
    int currentState = 0;
   // Timer framedraw;
    JButton play = new JButton("play");
    JButton store = new JButton("store");
    JButton quests = new JButton("quests");
    JButton town = new JButton("Town");
    JButton dark = new JButton("Dark Forest :Orcs: ");
    JButton goblins= new JButton("The Goblin Hideout");
    JButton humans = new JButton("Human Settlement");
    JButton elves = new JButton("Elven Highlands");
JButton map = new JButton("Map");

    String creature;
   GameObject player;
   Missions m = new Missions(player);
    GamePanel(){
    	play.addActionListener(this);
    	store.addActionListener(this);
    	quests.addActionListener(this);
    	map.addActionListener(this);
    	dark.addActionListener(this);
    	town.addActionListener(this);
    	goblins.addActionListener(this);
    	elves.addActionListener(this);
    	humans.addActionListener(this);
		//framedraw = new Timer(1000 / 60, this);
    	 add(play);
    	 add(store);
    	 add(quests);
    	 add(map);
    	 add(town);
    	 add(dark);
    	 add(goblins);
    	 add(elves);
    	 add(humans);
 		//framedraw.start();

    }
    
    @Override
    
	public void paintComponent(Graphics g){
	super.paintComponent(g);
	    if(currentState == MENU){
	        drawMenuState(g);
	    }else if(currentState == GAMEINTRO){
	        drawGameIntroState(g);
	    }else if(currentState == GAME){
	        drawGameState(g);
	    }
    else if(currentState == MAP){
        draMapState(g);
    }else if(currentState == END){
	        drawEndState(g);
	    }
	    //System.out.println(currentState);

	}
	 void updateMenuState() {  
		 
	 }
	 void updateGameIntroState(){
		 
	 }
	 
	 void updateGameState() {  
		 
	 }
 void updateMapState() {  
		 
	 }
	 void updateEndState()  {  
		 
	 }
	 void drawMenuState(Graphics g) {  
		 
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		 play.setVisible(true);
		 quests.setVisible(false);
		 store.setVisible(false);
		 town.setVisible(false);
		 dark.setVisible(false);
		 goblins.setVisible(false);
		 humans.setVisible(false);
		 elves.setVisible(false);
		 map.setVisible(false);

	 }
	 void drawGameIntroState(Graphics g) { 
	
		 g.setColor(Color.GREEN);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		 
		 
		 play.setVisible(false);
		
	 } void drawGameState(Graphics g) { 
		 g.setColor(Color.GREEN);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		

		 map.setVisible(true);
		 quests.setVisible(true);
		 store.setVisible(true);
		 //System.out.println("HI");
		
	 }	 void drawEndState(Graphics g)  {  
		// System.out.println("end");
		 
	 }  void draMapState(Graphics g) { 
		 g.setColor(Color.GREEN);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);

		 //System.out.println("map");
		 quests.setVisible(false);
		 store.setVisible(false);
		 town.setVisible(true);
		 dark.setVisible(true);
		 goblins.setVisible(true);
		 humans.setVisible(true);
		 elves.setVisible(true);

		 //System.out.println("HI");
		
	 }	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		JButton buttonPressed = (JButton) e.getSource();
		 if (buttonPressed.equals(play)){
			 
			 currentState++;
			 boolean success = false;
			 while(!success){
			 creature = JOptionPane.showInputDialog("Choose  orcs, elves, and dragonborns,");
				if(creature.equalsIgnoreCase("orc")||creature.equalsIgnoreCase("orcs")){
					player = new Orc();
					success = true;
				}
				else if(creature.equalsIgnoreCase("elf")||creature.equalsIgnoreCase("elves")){
					player = new Elf();
					success = true;

				}
				else if (creature.equalsIgnoreCase("dragonborn")||creature.equalsIgnoreCase("dragonborns")){
					player = new DragonBorn();
					success = true;

				}
				else{
					JOptionPane.showMessageDialog(null, creature+" does not compute");
					
				}
			 }
				JOptionPane.showMessageDialog(null, "Damage: "+player.damage+"\nArmor: "+player.prot+"\nSpeed: "+player.speed+"\nhealth:"+player.health+"\nConstitution "+player.dps+"\nHunger: "+player.hunger);
				player.name = JOptionPane.showInputDialog("Choose a name");
				JOptionPane.showMessageDialog(null, "You are "+player.name+" of the "+creature);
				currentState++;
		 }
		 if (buttonPressed.equals(store)){
			 int task = JOptionPane.showOptionDialog(null, "What would you like to buy", "Shop", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{ "Broad Sword","Great Club","Claymore" , "shield","Armor", "Quit"}, null);
		if( task == 0){
			new BroadSword(player);
		//	System.out.println(player.damage);
		}	  
		else if( task == 1){
			new GreatClub(player);
		//	System.out.println(player.damage);
		}	  
		else if( task == 3){
			new Claymore(player);
		//	System.out.println(player.damage);
		}	  
		else if( task == 4){
			new Shield(player);
		//	System.out.println(player.damage);
		}	  
		else if( task == 4){
			new Shield(player);
		//	System.out.println(player.damage);
		}	  
		else if( task == 5){
			new Armor(player);
		//	System.out.println(player.damage);
		}	  
		else if( task == 6){
		//	System.out.println(player.damage);
			currentState+=1;
			currentState-=1;
		}	  
		 }
		 if (buttonPressed.equals(quests)){
			 Random ran = new Random();
			 int task = JOptionPane.showOptionDialog(null, "Choose a Quest", "Quests", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{ "Hard","Medium","Easy" , "Quit"}, null);
			 if( task == 0){
					int i = ran.nextInt(3);
					if(i ==0){
						JOptionPane.showInputDialog("Kill the dragon Ember at his lair  Warning: EXTRA HARD  Reward: 500 gold");
						
					}
					if(i ==1){
						JOptionPane.showInputDialog("Inflitrate the goblins hideout to kill thier leader    Reward: 40");
					}
					if(i ==2){
						JOptionPane.showInputDialog("Kill 4 Orcs    Reward: 70");
					}
				
				}	  
			 if( task == 1){
					int i = ran.nextInt(3);
					if(i ==0){
						JOptionPane.showInputDialog("Kill the hydra  Reward: 5 gold");
						
					}
					if(i ==1){
						JOptionPane.showInputDialog("Kill 10 Goblins Reward: 6");
					}
					if(i ==2){
						JOptionPane.showInputDialog(" kill 1 Orc Reward: 7");
					}
				
				}	  
			 if( task == 2){
					int i = ran.nextInt(3);
					if(i ==0){
						JOptionPane.showInputDialog("kill monsters that stalk the forest   Reward: 1 head = 1 gold");
						
					}
					if(i ==1){
						JOptionPane.showInputDialog("Kill 1 elf   Reward: 2");
					}
					if(i ==2){
						JOptionPane.showInputDialog("Kill two humans   Reward: 3");
					}
				
				}	   
		 }
		 if (buttonPressed.equals(town)){
			 player.location = 0;
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 humans.setVisible(false);
			 elves.setVisible(false);
		 }
		 if (buttonPressed.equals(dark)){
			 player.location = 1;
			 m.killEmber(player);
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 humans.setVisible(false);
			 elves.setVisible(false);
		 }
		 if (buttonPressed.equals(goblins)){
			 player.location = 2;
			 
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 humans.setVisible(false);
			 elves.setVisible(false);
		 }
		 if (buttonPressed.equals(humans)){
			 player.location = 3;
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 humans.setVisible(false);
			 elves.setVisible(false);
		 }
		 if (buttonPressed.equals(elves)){
			 player.location = 4;
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 humans.setVisible(false);
			 elves.setVisible(false);
		 }
		 else if(buttonPressed.equals(map)){
			 currentState = MAP;
		 }

		 
		 repaint();
		
	}
}

