import javax.swing.JFrame;


public class GameRunner {
	 JFrame frame;
	 public static final int WIDTH = 800;
	 public static final int HEIGHT = 800;
	 GamePanel panel = new GamePanel();

GameRunner(){
	this.frame = new JFrame();
	this.frame.setVisible(true);
}
public static void main(String[] args) {
	new GameRunner().setup();
	
}
void setup(){
	frame.setSize(WIDTH, HEIGHT);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);

}
}
