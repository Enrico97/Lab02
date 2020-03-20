package it.polito.tdp.alien.model;

import java.util.Collection;
import java.util.List;

public class word {
	
	private String alienWord;
	private Collection<String> translate;
	
	
	/**
	 * costruttore classe word
	 * @param alienWord = parola aliena
	 * @param translate = traduzione
	 */
	
	
	public word(String alienWord, Collection<String> translate) {
		super();
		this.alienWord = alienWord;
		this.translate = translate;
	}


	public String getAlienWord() {
		return alienWord;
	}


	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}


	public String getTranslate() {
		String s="";
		for (String ss : translate) {
			s+=ss+"\n";
		}
		return s;
	}

	public void addTranslate(Collection<String> translation) {
		this.translate.addAll(translation);
	}
	

}
