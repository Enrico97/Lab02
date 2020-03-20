package it.polito.tdp.alien.model;

public class word {
	
	private String alienWord;
	private String translate;
	
	
	/**
	 * costruttore classe word
	 * @param alienWord = parola aliena
	 * @param translate = traduzione
	 */
	
	
	public word(String alienWord, String translate) {
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
		return translate;
	}


	public void setTranslate(String translate) {
		this.translate = translate;
	}

}
