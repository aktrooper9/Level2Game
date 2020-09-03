
public class Armor extends GameObject {
Armor(GameObject g){

	g.prot +=70;
	g.speed-=1;
	g.dps+=1;
	g.value = 10;
}
}
