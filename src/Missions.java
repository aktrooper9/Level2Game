import javax.swing.JOptionPane;


public class Missions extends GameObject{
Missions(GameObject g){
}
	void killEmber(GameObject g){
	JOptionPane.showMessageDialog(null, "Travel to the Dark Woods");
	if(g.location ==1 ){
		 int task = JOptionPane.showOptionDialog(null, "Where do you want to go", "Dark Forest", 0, JOptionPane.INFORMATION_MESSAGE, null,new String[]{"Ember","Orcs" }, null);
		 if( task == 0){
			 Fight fight = new Fight();
			
			
				while(alive){
				 fight.round(g);
				 fight.update(g);
				}
				 
				if(alive){
				JOptionPane.showMessageDialog(null,"You Win");
				}	
				else if(!alive){
					JOptionPane.showMessageDialog(null,"You Lose");
					}	
			
	}
}
}
}
