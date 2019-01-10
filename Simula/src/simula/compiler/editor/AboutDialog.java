package simula.compiler.editor;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AboutDialog(JFrame parent) {
		super(parent, "About Portable Simula", true);

		Box b = Box.createVerticalBox();
		b.add(Box.createGlue());

		b.add(new JLabel("   This is a new Simula System created by the"));
		b.add(new JLabel("   Open Source Project 'Portable Simula Revisited'."));
		b.add(new JLabel("               "));

		b.add(new JLabel("   The project was initiated as a response to the lecture"));
		b.add(new JLabel("   held by James Gosling at the 50th anniversary of Simula"));
		b.add(new JLabel("   in Oslo on 27th September, 2017."));
		b.add(new JLabel("               "));

		b.add(new JLabel("   This Simula System is written in Java and compiles to"));
		b.add(new JLabel("   Java code with one exception; the Goto Statement need"));
		b.add(new JLabel("   to be corrected in the byte code."));
		b.add(new JLabel("               "));

//		JLabel link=new JLabel("   More info at https://github.com/portablesimula");
		JLabel link=new JLabel("   More info at https://portablesimula.github.io/github.io/");
		b.add(link);
		if(Desktop.isDesktopSupported()) {
			link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			link.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() > 0) {
						Desktop desktop = Desktop.getDesktop();
//						try { desktop.browse(new URI("https://github.com/portablesimula"));
						try { desktop.browse(new URI("https://portablesimula.github.io/github.io/"));
						} catch (Exception ex) {}
					}
				}
			});
		}

		
		b.add(Box.createGlue());
		getContentPane().add(b, "Center");

		JPanel p2 = new JPanel();
		JButton ok = new JButton("Ok");
		p2.add(ok);
		getContentPane().add(p2, "South");
        setLocationRelativeTo(null); // center the frame on screen


		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				setVisible(false);
			}
		});

		setSize(250+110, 300);
	}
}