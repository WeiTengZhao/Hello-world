import java.awt.*;

public class TestFrame {
	public static void main (String[] args) {
		Frame f = new Frame("My First Frame.");
		f.setBounds(300,300,800,600);
		f.setBackground(Color.black);
		f.setResizable(false);//�Ƿ��ܸı䴰���С
		f.setVisible(true);
		
	}
}