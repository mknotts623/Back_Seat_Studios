import javax.swing.*;
import java.awt.*;

/*
 * this is going to be our "dummy" screen, so we have something to show to the class, and so we can get started
 * on UI that is actually interactive
 */
class CardTemplate extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		for (int i = 1; i < 6; i++) {
			int x = (200 * i) + 100;
			
			g.setColor(Color.GRAY);
			g.fillRect(x, 40, 180, 260);

			g.setColor(Color.BLACK);
			g.fillRect((x + 10), 50, 160, 120);
		}
		for (int i = 1; i < 6; i++) {
			int x = (200 * i) + 100;
			
			g.setColor(Color.GRAY);
			g.fillRect(x, 700, 180, 260);

			g.setColor(Color.BLACK);
			g.fillRect((x + 10), 710, 160, 120);
		}
		g.setColor(Color.GRAY);
		int style = Font.BOLD;
		Font font = new Font("Comic Sans",style, 22);
		g.fillRect(1400, 40, 180, 260);
		g.drawString("Deck", 1410, 150); //need to bring to front and establish other deck
		
	
	}
}

	public class TestWindow {
		public static void main(String[] args) {
			JFrame f = new JFrame("Gam");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			CardTemplate c = new CardTemplate();
			f.add(c);
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			f.setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
			f.setVisible(true);
		}
	}
