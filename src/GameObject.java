import java.util.ArrayList;


public class GameObject  {
int damage;
int prot;
int value;
int time;
int hands = 2;
int dps;
int speed=10;
int x;
int y;
int location = 0;
int money;
int health;
boolean alive;
int rations;
int hunger;
String name;
int enemyHealth;

void doDamage(int damage){
	System.out.println("Damage "+damage);
	this.health-=damage;
	if(health<=0){
		System.out.println("Dead");
		alive=false;
	}
}


}
