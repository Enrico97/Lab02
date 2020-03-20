package it.polito.tdp.alien.model;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class alienDictionary {
	
	List <word> dizionario = new LinkedList<>();

	public List<word> getDizionario() {
		return dizionario;
	}
	
	public boolean equals(String alienWord) {
		for (word w : dizionario) {
			if (w.getAlienWord().compareTo(alienWord)==0)
				return true;
		}
		return false;
	}

	public void addWord (String alienWord, String translation) {
		if (this.equals(alienWord)==false) {
			if (alienWord.matches("[a-zA-Z]*") && translation.matches("[a-zA-Z]*")) {
				word parola = new word (alienWord, translation);
				dizionario.add(parola);}
			else {
				throw new InvalidParameterException();}
			}
		if (this.equals(alienWord)==true) {
			for (word w : dizionario) {
				if (w.getAlienWord().compareTo(alienWord)==0)
					w.setTranslate(translation);
			}
	}
}
	
	public String translateWord (String alienWord) {
		for (word w : dizionario) {
			if (w.getAlienWord().compareTo(alienWord)==0)
				return w.getTranslate();
	}
		return null;
}
}
