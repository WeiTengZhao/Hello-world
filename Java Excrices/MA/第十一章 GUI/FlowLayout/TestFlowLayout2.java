import java.awt.*;

public class TestFlowLayout2 {
	public static void main(String[] args) {
		Frame f = new Frame("FlowLayout");
		Button b1 = new Button("����");
		Button b2 = new Button("�¸�");
		Button b3 = new Button("����");
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