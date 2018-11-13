package simula.editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;


public class Console {
    private static final boolean RENDER_LINE_NUMBERS=false;//true;
//  ImageIcon simulaIcon = new ImageIcon("icons/simula.png");
//  ImageIcon simulaIcon = new ImageIcon("icons/sim.jpg");
    private static final ImageIcon simulaIcon = new ImageIcon("icons/sim2.png");
    
    private JFrame frame;
    private static JTextPane textPane;

    private StyledDocument doc;
    private Style styleRegular;
    private Style styleWarning;
    private Style styleError;

        
    public Console() {
    	frame=new JFrame();
        try { frame.setIconImage(simulaIcon.getImage()); } 
        catch (Exception e) { e.printStackTrace(); }
        frame.setSize(1000, 1000);
        frame.setTitle("Simula Console");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null); // center the frame on screen
        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.getContentPane().setLayout(new BorderLayout());
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane);
        frame.getContentPane().add(panel);
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        
        doc=new DefaultStyledDocument();
        addStylesToDocument(doc);
        doc.putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
 		textPane.setStyledDocument(doc);

        frame.setVisible(true);
    }

	public void write(String s) { write(s,styleError); }// { write(s,styleRegular); }
	public void writeError(String s) { write(s,styleError); }
	public void writeWarning(String s) { write(s,styleWarning); }

	private void write(String s,Style style) {
		try {
			doc.insertString(doc.getLength(), s, style);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		textPane.setCaretPosition(textPane.getDocument().getLength());
        //frame.setVisible(true);
        //Util.BREAK("Console.write: done s="+s);
	}
    
    private void addStylesToDocument(StyledDocument doc) {
        Style defaultStyle = StyleContext.getDefaultStyleContext().
                        getStyle(StyleContext.DEFAULT_STYLE);
        
        Style regular = doc.addStyle("regular", defaultStyle);
        StyleConstants.setFontFamily(defaultStyle, "Courier New");
 
        Style s = doc.addStyle("warning", regular);
        StyleConstants.setItalic(s, true);
        StyleConstants.setForeground(s,Color.MAGENTA);

        s = doc.addStyle("error", regular);
        StyleConstants.setBold(s, true);
        StyleConstants.setForeground(s,Color.RED);
        
        styleRegular=doc.getStyle("regular");
        styleWarning=doc.getStyle("warning");
        styleError=doc.getStyle("error");
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
        	System.out.println("WINDOW CLOSING EVENT");
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
		System.out.println("doClose.saveDialog: answer="+answer);
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
               	String text=textPane.getText();
                //System.out.println(text);
                out.write(text);
                out.close();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }

}