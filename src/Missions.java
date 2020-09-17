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
	JOptionPane.showMessageDialog(null, "Travel to the Dark Woods");
	if(g.location ==1 ){
		 int task = JOptionPane.showOptionDialog(null, "Where do you want to go", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Ember","Orcs" }, null);
		 if( task == DRAGON){
			 Fight fight = new Fight();
//			System.out.println("here");
			fight.draw();
			fight.alive = true;
				while(fight.alive){
				 fight.round(g);				// System.out.println("Working");'
				 
				}
				 
			
				
			
	}
		 if(task == ORCS){

				for(int i =0;orcs.length>i;i++){
					orcs[i]= new Enemy();
					orcs[i].draw();
				}
				while(alive){
					for(int i =0;orcs.length>i;i++){
						orcs[i]= new Enemy();
					
					orcs[i].round(g);
					orcs[i].update();
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
		hydra.update();
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
