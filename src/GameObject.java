import java.util.ArrayList;


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
		System.out.println("Dead");
		alive=false;
	}
}


}
