import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import Trie.PD.Trie;

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
    private Trie trie;
    private String text;

	public SearchPanel(Trie trie, String text) {
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

