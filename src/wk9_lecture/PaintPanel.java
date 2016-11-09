package wk9_lecture;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import java.util.ArrayList;

public class PaintPanel extends JPanel {

	private final ArrayList<Point> points = new ArrayList<Point>();

	public PaintPanel() {
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {

				points.add(e.getPoint());
				repaint();
			}

		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		for (Point p : points) {
			g.fillOval(p.x, p.y, 4, 4);
		}
	}

}
