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
    	
		//framedraw = new Timer(1000 / 60, this);
    	 add(play);
    	 add(store);
    	 add(quests);
    	 add(map);
    	 add(town);
    	 add(dark);
    	 add(goblins);
    	
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
        drawMapState(g);
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
		
		 map.setVisible(false);

	 }
	 void drawGameIntroState(Graphics g) { 
	
		 g.setColor(Color.GREEN);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		 
		 
		 play.setVisible(false);
		
	 } void drawGameState(Graphics g) { 
		 map.setVisible(true);
		 quests.setVisible(true);
		 store.setVisible(true);
		 g.setColor(Color.GREEN);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
		

	
		 //System.out.println("HI");
	repaint();
	 }	 void drawEndState(Graphics g)  {  
		// System.out.println("end");
		 
	 }  void drawMapState(Graphics g) { 
		 g.setColor(Color.GREEN);
		 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);

		 //System.out.println("map");
		 quests.setVisible(false);
		 store.setVisible(false);
		 town.setVisible(true);
		 dark.setVisible(true);
		 goblins.setVisible(true);
		 //System.out.println("HI");
		repaint();
	 }	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//	repaint();
		
		JButton buttonPressed = (JButton) e.getSource();
		 if (buttonPressed.equals(play)){
			 
			 //currentState++;
			 boolean success = false;
			 while(!success){
				
			 creature = JOptionPane.showInputDialog("Choose  orcs, elves, and dragonborns,");
				if(creature.equalsIgnoreCase("orc")||creature.equalsIgnoreCase("orcs")){
					player = new Orc();
					success = true;
					player.alive=true;
				}
				else if(creature.equalsIgnoreCase("elf")||creature.equalsIgnoreCase("elves")){
					player = new Elf();
					success = true;
					player.alive=true;

				}
				else if (creature.equalsIgnoreCase("dragonborn")||creature.equalsIgnoreCase("dragonborns")){
					player = new DragonBorn();
					success = true;
					player.alive=true;

				}
				else{
					JOptionPane.showMessageDialog(null, creature+" does not compute");
					
				}
			 }
				JOptionPane.showMessageDialog(null, "Damage: "+player.damage+"\nArmor: "+player.prot+"\nSpeed: "+player.speed+"\nhealth:"+player.health+"\nConstitution "+player.dps+"\nHunger: "+player.hunger);
				player.name = JOptionPane.showInputDialog("Choose a name");
				JOptionPane.showMessageDialog(null, "You are "+player.name+" of the "+creature);
				currentState=GAME;
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
			 int task = JOptionPane.showOptionDialog(null, "Choose a Quest", "Quests", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{ "Kill Ember (EXTRA HARD)","Kill 10 goblins","kill 4 orcs ","Kill a goblin Hyrda",  "Quit"}, null);
			 if( task == 0){
					
					if(task ==0){
						JOptionPane.showInputDialog(" Go to dark forest , than kill the dragon Ember at his lair  Warning: EXTRA HARD  Reward: 500 gold");
						
					}
					if(task ==1){
						JOptionPane.showInputDialog("Go to the goblin hideout and kill 10 Goblins    Reward: 40");
					}
					if(task ==2){
						JOptionPane.showInputDialog("go to the dark forest and kill 4 Orcs    Reward: 70");
					}
				
				}	  
			
					
					if(task ==3 ){
						JOptionPane.showInputDialog("go to the goblin hidout and kill a hydra  Reward: 5 gold");
						
					}
		 }
		
		 if (buttonPressed.equals(town)){
			 player.location = 0;
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 map.setVisible(true);
		
		 }
		 if (buttonPressed.equals(dark)){
			 player.location = 1;
			 m.killEmber(player);
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 map.setVisible(true);

		 }
		 if (buttonPressed.equals(goblins)){
			 player.location = 2;
			 
			 town.setVisible(false);
			 dark.setVisible(false);
			 goblins.setVisible(false);
			 map.setVisible(true);

		 }
	
		 
		
		

		 
		
		
		 
		 else if(buttonPressed.equals(map)){
			 currentState = MAP;
		 }
			 repaint();
		 }
	
}

