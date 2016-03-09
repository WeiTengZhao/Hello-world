import java.awt.*;

public class TestFlowLayout {
	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		Button b1 = new Button("込込");
		Button b2 = new Button("限限");
		Button b3 = new Button("煉煉");
		f.setLayout(new FlowLayout());
		f.setSize(800,600);
		f.add(b1);
		f.add(b3);
		f.add(b2);
		f.setVisible(true);
	}
}