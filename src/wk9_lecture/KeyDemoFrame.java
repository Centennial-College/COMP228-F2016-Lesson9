package wk9_lecture;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener {

	private String line1 = "";
	private String line2 = "";
	private String line3 = "";
	private JTextArea textArea;

	public KeyDemoFrame() {
		super("Demonstrating Keystroke events");

		textArea = new JTextArea(10, 15);
		textArea.setText("Press any key on the keyboard to continue...");
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.PINK);
		add(textArea);

		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		line1 = String.format("Key typed: %s", e.getKeyChar());
		setLines2and3(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		line1 = String.format("Key pressed: %s", KeyEvent.getKeyText(e.getKeyCode()));
		setLines2and3(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		line1 = String.format("Key released: %s", KeyEvent.getKeyText(e.getKeyCode()));
		setLines2and3(e);
	}

	private void setLines2and3(KeyEvent e) {
		line2 = String.format("This key is %san action key", (e.isActionKey()) ? "" : "not ");

		String temp = KeyEvent.getKeyModifiersText(e.getModifiers());

		line3 = String.format("Modifier keys pressed :%s", temp.length() > 0 ? temp : "none");

		textArea.setText(String.format("%s%n%s%n%s%n", line1, line2, line3));
	}

}
