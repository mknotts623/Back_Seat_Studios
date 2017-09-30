import java.awt.*;
import javax.swing.*;
public class DrawBoard
{
    public static void main(String[] args) {
        JFrame f = new JFrame("Game");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SampleBoard boardDrawing = new SampleBoard();
        f.add(boardDrawing);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();
        f.setSize(width,height);
        f.setVisible(true);
    }
}