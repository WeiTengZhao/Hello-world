import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MyMouseAdapterGenetic {
	public static void main(String[] args) {
		new MyFrame("Draw");
	}
}

class MyFrame extends Frame {
	ArrayList <Point> points = null;
	MyFrame (String s) {
		super(s);
		points = new ArrayList();
		setBounds(200,200,800,600);
		setLayout(null);
		setBackground(new Color(204,204,255));
		setVisible(true);
		addMouseListener(new Monitor());
	}
	public void paint(Graphics g) {
		//Color c = new Color(g.getColor());
		Iterator <Point> i = points.iterator();
		while(i.hasNext()) {
			Point p = (Point) i.next();
			g.setColor(Color.BLUE);
			g.fillOval(p.x,p.y,30,30);
		}
	}
	void addPoint(Point p) {
		points.add(p);
	}
}

class Monitor extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			MyFrame f = (MyFrame)e.getSource();
			f.addPoint(new Point(e.getX(),e.getY()));
			f.repaint();
		}
}