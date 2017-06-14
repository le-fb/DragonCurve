import java.awt.Color;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DrachenGui jake = new DrachenGui(new Dragon(16, 1, new Color(181,0,0)));
		jake.AddDragon(new Dragon(16,2, new Color(0,0,0)));
		jake.AddDragon(new Dragon(16,3, new Color(19,0,170)));
		jake.AddDragon(new Dragon(16,0, new Color(0,0,0)));
	}

}
