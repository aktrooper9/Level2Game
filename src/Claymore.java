
public class Claymore extends GameObject {
	Claymore(GameObject g){
	g.damage += 40;
	g.dps -= 2;
	g.hands -= 2;
	g.value = 6;
	}
}
