package wk9_lecture;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseDetailsFrame extends JFrame {

	private String details;
	private final JLabel statusBar;

	public MouseDetailsFrame() {
		super("Mouse Clicks and Buttons");

		statusBar = new JLabel("Click the mouse!");
		add(statusBar, BorderLayout.SOUTH);

		// registering the MouseClickHandler to the JFrame
		this.addMouseListener(new MouseClickHandler());
	}

	private class MouseClickHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int xPos = e.getX();
			int yPos = e.getY();

			// right btn is meta button because it provides meta/contextual data
			// depending on where u click
			if (e.isMetaDown()) {
				details = "Right mouse button ";
			}
			// middle button
			else if (e.isAltDown()) {
				details = "Center mouse button ";
			} else {
				details = "Left mouse button ";
			}

			details += String.format("clicked %d time(s)", e.getClickCount());

			statusBar.setText(details);
		}

	}

}
