import java.awt.*;

public class TestBorderLayout {
	public static void main(String[] args) {
		Frame f = new Frame("Border");
		Button bn = new Button("North");
		Button be = new Button("East");
		Button bw = new Button("West");
		Button bs = new Button("Sounth");
		Button bc = new Button("Center");

		f.setLayout(new BorderLayout());
		f.add(bn,BorderLayout.NORTH);
		f.add(be,BorderLayout.EAST);
		f.add(bw,BorderLayout.WEST);
		f.add(bs,BorderLayout.SOUTH);
		f.add(bc);
		f.pack();
		f.setVisible(true);
	}
}