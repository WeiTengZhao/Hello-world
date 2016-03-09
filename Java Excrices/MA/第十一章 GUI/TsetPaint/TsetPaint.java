import java.awt.*;

public class TsetPaint {
	public static void main(String[] args) {
		new PaintFrame().launchFrame();
	}
}


class PaintFrame extends Frame { 
	public void launchFrame() {
		setBounds(200,200,800,600);
		setVisible(true);
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.green);
		g.fillOval(20,20,30,30);
		g.setColor(Color.red);
		g.fillRect(50,50,60,60);
		g.setColor(Color.black);
		g.drawLine(170,170,680,780);
		g.setColor(c);
	}
}