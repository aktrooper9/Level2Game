import javax.swing.JOptionPane;


public class Missions extends GameObject{
	Enemy[] goblins = new Enemy[10];
	final int GOBlINS = 0;
	final int DRAGON = 0;
Missions(GameObject g){
}
	void killEmber(GameObject g){
	JOptionPane.showMessageDialog(null, "Travel to the Dark Woods");
	if(g.location ==1 ){
		 int task = JOptionPane.showOptionDialog(null, "Where do you want to go", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Ember","Orcs" }, null);
		 if( task == DRAGON){
			 Fight fight = new Fight();
			
			
				while(alive){
				 fight.round(g);
				 fight.update(g);
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
	void hi(GameObject g){
		JOptionPane.showMessageDialog(null,"Travel to the goblins");
		if(g.location==2){
			
			

			 int task = JOptionPane.showOptionDialog(null, "Where do you want to go", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Goblins","Goblin King" }, null);
		if(task ==1){
			 
			Enemy goblin = new Enemy();
		goblin.health= 200;
		goblin.damage= 100;
		while(alive){
		goblin.round(g);
		goblin.update();
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
