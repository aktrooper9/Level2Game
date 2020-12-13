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

void levelup (int xp){
	if(xp==30+level*10){
		level+=1;
		xp-=30+level*10;
		damage+=level*10;
		health+=level*200;
		prot+=level*1;
	}
	System.out.println("Level up");

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
