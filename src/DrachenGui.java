import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;
public class DrachenGui
{
	private JFrame frame;
	private Canvas canvas;
	
	public DrachenGui(Dragon drake){
		frame = new JFrame("Unleash the Dragon");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(drake);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void AddDragon(Dragon drake){
		frame.add(drake);
		frame.setVisible(true);
	}
	
	public JFrame getFrame(){
		return frame;
	}

}
