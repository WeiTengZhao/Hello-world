import java.awt.*;

public class TestPanel {
	public static void main(String[] args) {
		Frame f = new Frame("Frame with Panel");
		Panel p = new Panel(null);
		f.setBounds(300,300,800,600);
		f.setLayout(null);
		f.setBackground(Color.black);
		
		p.setLayout(null);
		p.setBounds(300,300,400,300);
		p.setBackground(Color.red);

		f.add(p);
		f.setVisible(true);
	}
}