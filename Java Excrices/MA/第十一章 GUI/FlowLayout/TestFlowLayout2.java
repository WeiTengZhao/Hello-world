import java.awt.*;

public class TestFlowLayout2 {
	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		Button b1 = new Button("込込");
		Button b2 = new Button("限限");
		Button b3 = new Button("煉煉");
		FlowLayout l = new FlowLayout(FlowLayout.CENTER,20,40);
		f.setLayout(l);
		f.setSize(800,600);
		f.setLocation(200,300);
		f.setBackground(new Color(203,221,203) );
		f.add(b1);
		f.add(b3);
		f.add(b2);
		f.setVisible(true);
	}
}