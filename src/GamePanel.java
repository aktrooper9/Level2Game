import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
 final int MENU = 0;
final int GAME = 1;
 final int END = 2;
 int currentState = MENU;
 Font titlefont;
 Font textfont;
 GamePanel(){
	 titlefont = new Font("Arial", Font.PLAIN, 48);
	 textfont = new Font("Arial", Font.PLAIN, 24);
 }	 
 @Override

 public void paintComponent(Graphics g){
	 if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
 }
 void updateMenuState() { 
	 
 }
 void updateGameState() {  
	 
 }
 void updateEndState()  {  
	 
 }
 void drawMenuState(Graphics g) {  
	 g.setColor(Color.BLACK);
	 g.fillRect(0, 0, GameRunner.WIDTH, GameRunner.HEIGHT);
	 g.setFont(titlefont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Welcome to my game", 125, 100);
	 g.setFont(textfont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Press Space For Rules", 250, 200);
	 g.drawString("Press Enter to Start", 265, 150);
 }
 void drawGameState(Graphics g) {  
	 
 }
 void drawEndState(Graphics g)  {  
	 g.setFont(titlefont);
	 g.setColor(Color.YELLOW);
	 g.drawString("Game Over", 300, 100);
	 g.setFont(textfont);
	 g.setColor(Color.YELLOW);
	
	 g.drawString("Press Enter to restart", 267, 150);
 }
}
