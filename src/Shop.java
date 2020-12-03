import javax.swing.JOptionPane;


public class Shop extends GameObject {
void shop(GameObject g){
	int Purchasable = JOptionPane.showOptionDialog(null,
			"What would you like to buy", "Shop", 0,
			JOptionPane.INFORMATION_MESSAGE, null, new String[] {
					"Broad Sword: 5 gold", "Great Club: 6 gold",
					"Claymore: 6 gold", "Shield: 5 gold",
					"Armor: Gold", "Food: 1 gold", }, null);
	if (Purchasable == 0) {
		g.money -= 5;
		if (g.money <= 0) {
			JOptionPane.showMessageDialog(null, "Not enough money",
					"Shop", JOptionPane.INFORMATION_MESSAGE);
			g.money += 5;
		} else {
			new BroadSword(g);
			JOptionPane.showMessageDialog(null,
					"Congratulations on your new Weapon", "Congrats",
					JOptionPane.INFORMATION_MESSAGE);
		}
		// System.out.println(player.damage);
	} else if (Purchasable == 1) {
		g.money -= 6;
		if (g.money <= 0) {
			JOptionPane.showMessageDialog(null, "Not enough money",
					"Shop", JOptionPane.INFORMATION_MESSAGE);
			g.money += 6;
		} else {
			new GreatClub(g);
			JOptionPane.showMessageDialog(null,
					"Congratulations on your new Weapon", "Congrats",
					JOptionPane.INFORMATION_MESSAGE);

		}
		// System.out.println(player.damage);
	} else if (Purchasable == 2) {
		g.money -= 6;
		if (g.money <= 0) {
			JOptionPane.showMessageDialog(null, "Not enough money",
					"Shop", JOptionPane.INFORMATION_MESSAGE);
			g.money += 6;
		} else {
			new Claymore(g);
			JOptionPane.showMessageDialog(null,
					"Congratulations on your new Weapon", "Congrats",
					JOptionPane.INFORMATION_MESSAGE);

		}
		// System.out.println(player.damage);
	} else if (Purchasable == 3) {
		g.money -= 5;
		if (g.money <= 0) {
			JOptionPane.showMessageDialog(null, "Not enough money",
					"Shop", JOptionPane.INFORMATION_MESSAGE);
			g.money += 5;
		} else {
			new Shield(g);
			JOptionPane.showMessageDialog(null,
					"Congratulations on your new shield", "Congrats",
					JOptionPane.INFORMATION_MESSAGE);

		}
		// System.out.println(player.damage);
	} else if (Purchasable == 4) { //

		g.money -= 10;
		if (g.money <= 0) {
			JOptionPane.showMessageDialog(null, "Not enough money",
					"Shop", JOptionPane.INFORMATION_MESSAGE);
			g.money += 10;
		} else {
			new Armor(g);
			JOptionPane.showMessageDialog(null,
					"Congratulations on your new Armor", "Congrats",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}
	// System.out.println(player.damage);
	else if (Purchasable == 5) { //

		g.money -= 1;
		if (g.money <= 0) {
			JOptionPane.showMessageDialog(null, "Not enough money",
					"Shop", JOptionPane.INFORMATION_MESSAGE);
			g.money += 1;
		} else {
			g.rations += 1;
			JOptionPane.showMessageDialog(null,
					"You have bought one more Ration", "Congrats",
					JOptionPane.INFORMATION_MESSAGE);

		}
		// System.out.println(player.damage);
	
}
}
}
