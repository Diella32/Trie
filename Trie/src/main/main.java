package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import Trie.PD.Trie;

public class main {
	public static void main(String[] args) {
		String fileUsed = "john1.txt";
		Trie elementUsed = new Trie();
		StringBuilder builderUsed = new StringBuilder(); 
		
		try {
	         FileReader fileReader =  new FileReader(fileUsed);
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         
	         String line;
	         int location = 0;
	         String wordUsed ="";
	         
	         while((line = bufferedReader.readLine())!= null) {
	        	 builderUsed.append(line).append("\n");
	        	 
	        	 for(int i =0; i<line.length(); i++) {
	        		 char characterUsed = line.charAt(i); 
	        		 
	        		 if (characterUsed == ' ' || characterUsed == ',' || characterUsed == '?' || characterUsed == '.' || characterUsed == '!'  || characterUsed ==  '"') {
	        			 if(wordUsed.length() >0) {
	        				 elementUsed.insert(wordUsed);
	        				 wordUsed = ""; 
	        			 }
	        		 }
	        		 else {
	        			wordUsed += characterUsed; 
	        		 }
	        		 location++; 
	        	 }
	        	 location++; 
	         }
	}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Trie Test");
		System.out.println(elementUsed.search("Word"));
	}
		
		
//		JFrame frameUsed = new JFrame(" ");
//		frameUsed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frameUsed.setSize(550, 550);
//		frameUsed.add(new SearchPanel(elementUsed, builderUsed.toString()));
//		frameUsed.setVisible(true); 
//				
//}
}
