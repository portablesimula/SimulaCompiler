package simula.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class TextConsole {
    public static final boolean RENDER_LINE_NUMBERS=false;//true;
//  ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
//  ImageIcon simulaIcon = new ImageIcon("icons/sim.jpg");
    public static final ImageIcon simulaIcon = new ImageIcon("icons/sim2.png");
    
    private JFrame frame;
    private JTextArea textArea;

	public void write(String s) {
		textArea.append(s);
		textArea.setCaretPosition(textArea.getDocument().getLength());
		//RT.BREAK("TextConsole.write: "+s);
//	    textArea.repaint();
	    textArea.update(textArea.getGraphics());
	}
        
    public TextConsole() {
    	frame=new JFrame();
        try { frame.setIconImage(simulaIcon.getImage()); } 
        catch (Exception e) { e.printStackTrace(); }
        frame.setSize(800, 500); // Initial frame size
        frame.setTitle("Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        textArea = new JTextArea();
        int fontSize = 12;
//      textArea.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        textArea.setFont(new Font("TimesRoman", Font.BOLD, fontSize));
        textArea.setText("");
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().setLayout(new BorderLayout()); // the BorderLayout bit makes it fill it automatically
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane);
        frame.getContentPane().add(panel);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        
        frame.setVisible(true);
    }

	private JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");

		// ****************************************************************
		// *** FileMenu: Save File
		// ****************************************************************
		JMenuItem saveFile = new JMenuItem("Save");
		saveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});
		fileMenu.add(saveFile);

		// ****************************************************************
		// *** FileMenu: Close Console
		// ****************************************************************
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doClose();
			}
		});
		fileMenu.addSeparator();
		fileMenu.add(close);
		return (fileMenu);
	}

    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
        	//System.out.println("WINDOW CLOSING EVENT");
           doClose(); 
        }
    }
    
	private void doClose() {
		switch (saveDialog()) {
		    case 0:	saveFile(); // Save file and Exit
		    case 1:	System.exit(0); // No Save and Exit
		    default: // Do nothing
		}
	}
    
	private int saveDialog() {
		Object[] buttons = { "Save", "No Save", "Return" };
		int answer = JOptionPane.showOptionDialog(frame, "Do you want to save the current file ?", "Question",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
		//System.out.println("doClose.saveDialog: answer="+answer);
		return(answer);
	}
	
    private void saveFile() {
        String userDir = System.getProperty("user.home");
        JFileChooser fileChooser = new JFileChooser(userDir +"/SimulaSource");
        int option = fileChooser.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                File openFile = fileChooser.getSelectedFile();
//                frame.setTitle(openFile.getName() + " - " + "SimulaEditor");

                BufferedWriter out = new BufferedWriter(new FileWriter(openFile.getPath()));
               	String text=textArea.getText();
                //System.out.println(text);
                out.write(text);
                out.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

}