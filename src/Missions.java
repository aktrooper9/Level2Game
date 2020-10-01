import javax.swing.JOptionPane;


public class Missions extends GameObject{
	Enemy[] goblins = new Enemy[10];
	Enemy[] orcs = new Enemy[5];

	final int GOBlINS = 0  ;
	final int DRAGON = 0;
	final int ORCS = 1;
Missions(GameObject g){
}
	void killEmber(GameObject g){
	if(g.location ==1 ){
		 int task = JOptionPane.showOptionDialog(null, "Where do you want to go", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Ember","Orcs" }, null);
		 if( task == DRAGON){
			 Fight fight = new Fight();
//			System.out.println("here");
			fight.draw();
			fight.alive = true;
				while(fight.alive){
				 fight.round(g);
					if(g.health==0||g.health<0){
						g.alive = false;
						 break;
					}
					else if(enemyHealth==0||enemyHealth<0){
						alive = false;
						 int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare Ember", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Spare","Kill" }, null);
						 if(mercy ==0){	
							 JOptionPane.showMessageDialog(null, "Ember spreads his wings incinerates you. He whispers I will not be killed by the likes of you. ");
						 break;
						 }
						 else{
							 JOptionPane.showMessageDialog(null, "The great dragons body lies motionless. His gold is now yours.");
						g.money+=10000;
						 }
					}
				 // System.out.println("Working");'
				 if(g.alive==false){
					 break;
				 }
				}
				 
			
				
			
	}
		 if(task == ORCS){
//System.out.println("Working");
				for(int i =0;orcs.length>i;i++){
					orcs[i]= new Enemy();
					orcs[i].draw();
				}
				while(g.alive){
					for(int i =0;orcs.length>i;i++){
					orcs[i].round(g);
						if(g.health==0||g.health<0){
							g.alive = false;
							 break;
						}
						else if(enemyHealth==0||enemyHealth<0){
							alive = false;
							 int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare the orc", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Spare","Kill" }, null);
							 if(mercy ==0){	
								 JOptionPane.showMessageDialog(null, "The orc runs off afraid and dishonered ");
							 break;
							 }
							
							
							 }
					}
					
					}
					}
		
		 }
}

	void goblin(GameObject g){
		JOptionPane.showMessageDialog(null,"Travel to the goblins");
		if(g.location==2){
			
			

			 int task = JOptionPane.showOptionDialog(null, "Where do you want to go", "Goblin Hideout", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Goblins","Hydra" }, null);
		if(task ==GOBlINS){
			 
			Enemy hydra = new Enemy();
			hydra.draw();
		hydra.health= 200;
		hydra.damage= 100;
		while(alive){

			 hydra.round(g);
			 hydra.damage*=3;
				if(g.health==0||g.health<0){
					g.alive = false;
					 break;
				}
				else if(enemyHealth==0||enemyHealth<0){
					alive = false;
					 int mercy = JOptionPane.showOptionDialog(null, "Do you wish to spare The hydra of the Goblins", "Lair", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Spare","Kill" }, null);
					 if(mercy ==0){	
						 JOptionPane.showMessageDialog(null, "Its heads look confused before retreating back into the swamp ");
					 break;
					 }
					 else{
						 JOptionPane.showMessageDialog(null, "The hydras's blood spills over you. The middle head gives a half hearted smile, as the poison in its blood finshes you.");
					g.alive = false;
					 }
				}
			 // System.out.println("Working");'
			 if(g.alive==false){
				 break;
			 }
			
		}
		if(!alive){
			JOptionPane.showMessageDialog(null,"You Win");
			}	
			else if(alive){
				JOptionPane.showMessageDialog(null,"You Lose");
				}	
		}
		if(task == GOBlINS){
			for(int i =0;goblins.length>i;i++){
				goblins[i]= new Enemy();
				goblins[i].draw();
			}
			while(alive){
				for(int i =0;goblins.length>i;i++){
					goblins[i]= new Enemy();
				
				goblins[i].round(g);
				goblins[i].update();
				}
				}
			if(!alive){
				JOptionPane.showMessageDialog(null,"You Win");
				}	
				else if(alive){
					JOptionPane.showMessageDialog(null,"You Lose");
					}	
		}
		}
	}
	
	
}
