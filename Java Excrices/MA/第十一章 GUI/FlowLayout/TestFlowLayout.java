import java.awt.*;

public class TestFlowLayout {
	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		Button b1 = new Button("����");
		Button b2 = new Button("�¸�");
		Button b3 = new Button("����");
		f.setLayout(new FlowLayout());
		f.setSize(800,600);
		f.add(b1);
		f.add(b3);
		f.add(b2);
		f.setVisible(true);
	}
}