
public class Fight extends GameObject{
Fight(){
	
}
void draw(){
	enemyHealth = 900;
	damage = 100;
	prot = 60;
	alive = true;
}
void update(GameObject g){
	if(g.health==0||g.health<0){
		g.alive = false;
	}
	else if(enemyHealth==0||enemyHealth<0){
		alive = false;
	}
}

void round(GameObject g){
	damage-=g.prot;
	g.health-=damage;
	System.out.println("You took "+damage+" damage, you have "+g.health+" Left");
	g.damage-=prot;
	System.out.println("You dealt "+g.damage+" damage, Ember has "+health+" Left");
	enemyHealth-=g.damage;
}
}
