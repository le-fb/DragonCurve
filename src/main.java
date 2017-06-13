import java.awt.Color;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrachenGui jake = new DrachenGui(new Dragon(11, 1, new Color(255,0,0)));
		jake.AddDragon(new Dragon(11,2, new Color(0, 255, 0)));
		jake.AddDragon(new Dragon(11,3, new Color(0,0,255)));
		jake.AddDragon(new Dragon(11,0, new Color(255,100,255)));

	}

}
