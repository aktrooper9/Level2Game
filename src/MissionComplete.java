import javax.swing.JOptionPane;

public class MissionComplete extends GameObject {
int ember=0;
int goblins=0;
int hydra =0;
int orc =0;
	MissionComplete(GameObject g) {

	}

	void run(GameObject g) {

	
		int task = JOptionPane.showOptionDialog(null, "View Quests", "Quests",
				0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {
						"Kill Ember (EXTRA HARD)", "Kill 10 goblins",
						"kill 4 orcs ", "Kill a Hyrda", "Quit" }, null);

		if (task == 0) {
if(g.emberComplete==true){
	if(ember==0) {
JOptionPane.showMessageDialog(null, "Mission Complete; You earned 50 gold and 100 score");		
g.money+=50;
g.score+=100;
	}
	else {
		JOptionPane.showMessageDialog(null, "Mission Complete");				

	}
	ember+=1;
			}
else{
			JOptionPane
					.showMessageDialog(
							null,
							" Go to dark forest , than kill the dragon Ember at his lair  Warning: EXTRA HARD ");
}
			
		} else if (task == 1) {
			if(g.goblinComplete==true){
				if(goblins==0) {
					JOptionPane.showMessageDialog(null, "Mission Complete; You earned 10 gold and 40 score");		
					g.money+=10;
					g.score+=40;
						}
						else {
							JOptionPane.showMessageDialog(null, "Mission Complete");				

						}
						goblins+=1;
								}
		else{
			JOptionPane
					.showMessageDialog(null,
							"Go to the goblin hideout and kill 10 Goblins    ");
		}
		} else if (task == 2) {
			if(g.orcComplete==true){
				if(orc==0) {
					JOptionPane.showMessageDialog(null, "Mission Complete; You earned 15 gold and 50 score");		
					g.money+=15;
					g.score+=50;
						}
						else {
							JOptionPane.showMessageDialog(null, "Mission Complete");				

						}
						orc+=1;
								}
			else{
			JOptionPane.showMessageDialog(null,
					"go to the dark forest and kill 4 Orcs    ");
			}
		}

		else if (task == 3) {
			if(g.hydraComplete==true){
				if(hydra==0) {
					JOptionPane.showMessageDialog(null, "Mission Complete; You earned 40 gold and 80 score");		
					g.money+=40;
					g.score+=80;
						}
						else {
							JOptionPane.showMessageDialog(null, "Mission Complete");				

						}
						hydra+=1;
								}
			else{
			JOptionPane.showMessageDialog(null,
					"go to the swamps and kill a hydra  ");
			}
		}
	}

}
