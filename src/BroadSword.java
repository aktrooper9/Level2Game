
public class BroadSword extends GameObject {
	BroadSword(GameObject tgo){
		System.out.println(tgo.damage);
	 tgo.damage += 10;
	 tgo.dps -= 1;
	 tgo.hands -=1;
	 tgo.value = 5;
		System.out.println(tgo.damage);

	}
}
