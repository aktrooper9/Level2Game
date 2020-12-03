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
boolean dragonborn;
String name;
int scales;
int blood;
int enemyHealth;
boolean emberComplete= false;
boolean orcComplete= false;
boolean hydraComplete = false;
boolean goblinComplete = false;
int xp = 0;
int level= 0;

void levelup (int xp, GameObject g){
	if(xp==30+g.level*10){
		g.level+=1;
		xp-=30+g.level*10;
		g.damage+=g.level*10;
		g.health+=g.level*20;
		g.prot+=g.level*1;
	}
}
void doDamageEnemy(int damage){
	System.out.println("Damage "+damage);
	this.health-=damage;
if(health<=0){
		
		alive=false;
}
}

void doDamage(int damage){
	System.out.println("Damage "+damage);
	this.health-=damage;
	if(health<=0){
		
		JOptionPane.showMessageDialog(null,"You died.");
		alive=false;
	}
}
void tutorial(GameObject g){}
}
