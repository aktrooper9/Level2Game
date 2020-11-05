import javax.swing.JOptionPane;

public class MissionComplete extends GameObject {

	MissionComplete(GameObject g) {

	}

	void run(GameObject g) {

	
		int task = JOptionPane.showOptionDialog(null, "View Quests", "Quests",
				0, JOptionPane.INFORMATION_MESSAGE, null, new String[] {
						"Kill Ember (EXTRA HARD)", "Kill 10 goblins",
						"kill 4 orcs ", "Kill a goblin Hyrda", "Quit" }, null);

		if (task == 0) {
if(g.emberComplete==true){
JOptionPane.showMessageDialog(null, "Complete");				
			}
else{
			JOptionPane
					.showMessageDialog(
							null,
							" Go to dark forest , than kill the dragon Ember at his lair  Warning: EXTRA HARD  Reward: 500 gold");
}
			
		} else if (task == 1) {
			if(g.goblinComplete==true){
				JOptionPane.showMessageDialog(null, "Complete");
			}
		else{
			JOptionPane
					.showMessageDialog(null,
							"Go to the goblin hideout and kill 10 Goblins    Reward: 40");
		}
		} else if (task == 2) {
			if(g.orcComplete==true){
				JOptionPane.showMessageDialog(null, "Complete");
			}
			else{
			JOptionPane.showMessageDialog(null,
					"go to the dark forest and kill 4 Orcs    Reward: 70");
			}
		}

		else if (task == 3) {
			if(g.hydraComplete==true){
				JOptionPane.showMessageDialog(null, "Complete");
			}
			else{
			JOptionPane.showMessageDialog(null,
					"go to the goblin hidout and kill a hydra  Reward: 5 gold");
			}
		}
	}

}
