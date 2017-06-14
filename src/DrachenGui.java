import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class DrachenGui
{
	private JFrame frame;
	private Container cp;
	private JPanel panel;
	
	public DrachenGui(Dragon drake){
		frame = new JFrame("Unleash the Dragon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = frame.getContentPane();
		panel = new JPanel();
		panel.add(drake);
		
		cp.add(drake);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void AddDragon(Dragon drake){
		cp.add(drake);
		frame.setVisible(true);
	}
	
	public JFrame getFrame(){
		return frame;
	}

	
}
