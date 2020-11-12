import javax.swing.JOptionPane;


 // add tutorial add death confusing. add more information.



public class GameObject  {
int damage;
int prot;
int value;
int location = 0;
int money;
int health;
boolean alive;
int rations;
String name;
int enemyHealth;
boolean emberComplete= false;
boolean orcComplete= false;
boolean hydraComplete = false;
boolean goblinComplete = false;

void doDamage(int damage){
	System.out.println("Damage "+damage);
	this.health-=damage;
	if(health<=0){
		JOptionPane.showMessageDialog(null,"You died.");
		alive=false;
	}
}
void tutorial(GameObject g){
	JOptionPane.showMessageDialog(null, "As you return to your town, you're ambushed by an orc. ");
	Enemy orc = new Enemy();
	orc.draw();
	orc.health = 70;
	orc.damage = 10;
	JOptionPane.showMessageDialog(null, "Your health is shown on the top right corner.");
	orc.round(g, "Ember");
	// g.health-= 30;
	if (!g.alive) {
		
	}

	int mercy = JOptionPane.showOptionDialog(null,
			"You may kill", "Dark Forest", 0,
			JOptionPane.INFORMATION_MESSAGE, null,
			new String[] { "Spare", "Kill" }, null);
	if (mercy == 0) {
		JOptionPane
				.showMessageDialog(null,
						"The orc stumbles before running away. ");
		g.alive = false;
		
	} else if (mercy == 1) {
		JOptionPane
				.showMessageDialog(
						null,
						"The orcs body slumps forward, lifeless. ");
orc.alive= false;
}


}
}
