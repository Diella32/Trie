package main;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import Trie.PD.TrieNode;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

public class SearchPanel extends JPanel {
	private JTextField searchField;
	private JTextArea textArea;
    private JButton searchButton;
    private TrieNode trie;
    private String text;

	public SearchPanel(TrieNode trie, String text) {
		this.trie = trie;
		this.text = text;
		
		setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());
        searchField = new JTextField();
        searchButton = new JButton("Search");
        searchButton.addActionListener(e -> onSearch());
        panel.add(searchField, BorderLayout.CENTER);
        panel.add(searchButton, BorderLayout.EAST);
		
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText(text);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setPreferredSize(new Dimension(800, 600));
        
        searchField.requestFocusInWindow();
	}

	private void onSearch() {
		String word = searchField.getText().trim();
		if (word.isEmpty()) {
			return;
		}
		int[] locations = new int[1];
		if (trie.search(word, locations) != null) {
			int location = locations[0];
			textArea.select(location, location + word.length());
			textArea.requestFocusInWindow();
		} else {
			JOptionPane.showMessageDialog(this, "Word not found");
			searchField.requestFocusInWindow();
		}
	}

}

//public class SearchPanel extends JPanel {
//	private JTextField textField;
//	private JTextArea textArea;
//    private JTextField searchField;
//    private JButton searchButton;
//    private TrieNode trie;
//    private String text;
//
//	/**
//	 * Create the panel.
//	 */
//	public SearchPanel() {
//		
//		textField = new JTextField();
//		add(textField);
//		textField.setColumns(10);
//		
//		 this.trie = trie;
//	     this.text = text;
//	        
//		setTitle("john1.txt");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        JPanel panel = new JPanel(new BorderLayout());
//        searchField = new JTextField();
//        searchButton = new JButton("Search");
//        searchButton.addActionListener(e -> onSearch());
//        panel.add(searchField, BorderLayout.CENTER);
//        panel.add(searchButton, BorderLayout.EAST);
//		
//        textArea = new JTextArea();
//        textArea.setEditable(false);
//        textArea.setText(text);
//
//        add(panel, BorderLayout.NORTH);
//        add(new JScrollPane(textArea), BorderLayout.CENTER);
//
//        pack();
//        setLocationRelativeTo(null);
//        setVisible(true);
//        
//		JButton Searchbtn = new JButton("Search");
//		Searchbtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				textField.setText(text);
//
//				// get the highlighter from the textArea
//				Highlighter highlighter = textField.getHighlighter();
//
//				// create a painter with the color
//				HighlightPainter painter = 
//				  new DefaultHighlighter.DefaultHighlightPainter(Color.yellow);
//
//				// set a highlight with locations and painter to highlighter
//				try {
//				     highlighter.addHighlight(startLocation, endLocation, painter );
//				}
//				catch (BadLocationException ex) {}
//
//				//set caret to top of the text area
//				textField.setCaretPosition(0);
//
//			}
//		});
//		 private void onSearch() {
//		        String word = searchField.getText().trim();
//		        if (word.isEmpty()) {
//		            return;
//		        }
//		        int[] locations = new int[1];
//		        if (trie.search(word, locations)) {
//		            int location = locations[0];
//		            textArea.select(location, location + word.length());
//		        } else {
//		            JOptionPane.showMessageDialog(this, "Word not found");
//		        }
//		        add(Searchbtn);
//		
//	}
//
//}
