import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Dragon extends JPanel{
	private ArrayList<Point> points;
	private int sideLength = 4;
	private int defaultDirection;
	private int direction;
	private Point start;
	private int iteration;
	private int height = 850;
	private int width = 1150;
	private JFrame frame;
	private ArrayList<Character> turns;
	private Color color;
	
	private void turn(char dir){
		if(dir == 'r') direction++;
		else direction--;
		if(direction >= 4) direction = direction - 4;
		if(direction < 0) direction = direction + 4;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		ArrayList<ArrayList<Integer>> xy = getIterationPoints(iteration);
		int[] x = new int[xy.get(0).size()];
		int[] y = new int[xy.get(0).size()];
		int iterationCounter = 1;
		if(color != null) g.setColor(color);
		for(int i = 0; i<x.length; i++){
			x[i] = xy.get(0).get(i);
			y[i] = xy.get(1).get(i);
			if(color == null && i == (int)(Math.pow(2, iterationCounter) - 1)){
				iterationCounter++;
				int r =(int) (Math.random()*255.0);
				int gr =(int) (Math.random()*255.0);
				int b = (int) (Math.random()*255.0);
				g.setColor(new Color(r,gr,b));
			}
			if(i>0)g.drawLine(x[i-1], y[i-1], x[i], y[i]);
			//frame.setVisible(true);

		}
		//g.drawPolyline(x, y, x.length);
		
		
	}
	
	public void printIteration(int i){
		ArrayList<Character> turns = getIteration(i);
		for(int j = 0; j < turns.size(); j++){
			System.out.print(turns.get(j) + " ");
		}
	}
	
	public ArrayList<Character> getIteration(int i){
		ArrayList<Character> turns = new ArrayList<Character>();

		if(i == 1){
			turns.add('r');
			return turns;
		} else {
			ArrayList<Character> oldTurns = getIteration(i-1);
			ArrayList<Character> newTurns = new ArrayList<Character>();
			newTurns.addAll(oldTurns);
			newTurns.add('r');
			int mid = (oldTurns.size() / 2);
			oldTurns.set(mid, 'l');
			newTurns.addAll(oldTurns);
			return newTurns;
		}
	}
	
	public ArrayList<ArrayList<Integer>> getIterationPoints(int i){
		ArrayList<ArrayList<Integer>> xy = new ArrayList<ArrayList<Integer>>();
		direction = defaultDirection;
		
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();
		
		x.add(start.x);
		y.add(height - start.y);
		for(int j = 0; j<turns.size(); j++){
			switch (direction){
			case 0:	x.add(x.get(j)); y.add(y.get(j) - sideLength); break;
			case 1: x.add(x.get(j) + sideLength); y.add(y.get(j)); break;
			case 2: x.add(x.get(j)); y.add(y.get(j) + sideLength); break;
			case 3: x.add(x.get(j) - sideLength); y.add(y.get(j)); break;
			}
			turn(turns.get(j));
		}
		int j = x.size() - 1;
		switch (direction){
		case 0:	x.add(x.get(j)); y.add(y.get(j) - sideLength); break;
		case 1: x.add(x.get(j) + sideLength); y.add(y.get(j)); break;
		case 2: x.add(x.get(j)); y.add(y.get(j) + sideLength); break;
		case 3: x.add(x.get(j) - sideLength); y.add(y.get(j)); break;
		}
		xy.add(x);
		xy.add(y);
		return xy;
	}
	
	public Dragon(int pIteration, int pDirection){
		this.setBackground(new Color(0,0,0,0));
		start = new Point(400, 350);
		defaultDirection = pDirection;
		turns = getIteration(pIteration);
		this.setPreferredSize(new Dimension(width + 50, height + 50));
	}
	public Dragon(int pIteration, int pDirection, Color pColor){
		this.setBackground(new Color(0,0,0,0));
		color = pColor;
		start = new Point(600, 500);
		defaultDirection = pDirection;
		turns = getIteration(pIteration);
		this.setPreferredSize(new Dimension(width + 50, height + 50));
	}
}
