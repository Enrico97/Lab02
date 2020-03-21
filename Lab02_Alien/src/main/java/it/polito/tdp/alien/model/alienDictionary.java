package it.polito.tdp.alien.model;

import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class alienDictionary {
	
	Set <word> dizionario = new LinkedHashSet<>();
	Set <String> traduzione1 = new HashSet<>();


	public Collection<word> getDizionario() {
		return dizionario;
	}
	
	public boolean equals(String alienWord) {
		for (word w : dizionario) {
			if (w.getAlienWord().compareTo(alienWord)==0)
				return true;
		}
		return false;
	}

	public void addWord (String alienWord, List<String> traduzione) {
		boolean errato=false;
		if (this.equals(alienWord)==false) {
			if (alienWord.matches("[a-zA-Z]*")==false) {
				throw new InvalidParameterException();
				}
			for (int i = traduzione.size()-1; i >= 0; i--) {
				if(traduzione.get(i).matches("[a-zA-Z]*")==false) {
					errato=true;
					traduzione.remove(traduzione.get(i));}
			}
			if (traduzione.size()!=0) {
				traduzione1.addAll(traduzione);
				word parola = new word (alienWord, traduzione1);
				dizionario.add(parola);}
			if (errato == true)
				throw new IllegalStateException();
		}
		else {
			for (int i = traduzione.size()-1; i >= 0; i--) {
				if(traduzione.get(i).matches("[a-zA-Z]*")==false) {
					errato=true;
					traduzione.remove(traduzione.get(i));}
			}
			for (word w : dizionario) {
				if (w.getAlienWord().compareTo(alienWord)==0)
					w.addTranslate(traduzione);
			}
			if (errato == true)
				throw new IllegalStateException();
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
