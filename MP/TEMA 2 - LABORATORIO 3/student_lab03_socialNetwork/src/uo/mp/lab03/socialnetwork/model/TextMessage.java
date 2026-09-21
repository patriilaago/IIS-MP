package uo.mp.lab03.socialnetwork.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class TextMessage extends Post{

	//Characters == message
	private String characters;
	
	public TextMessage(String theUser, String characters) {
		super(theUser);
		setCharacters(characters);
	}

	public String getCharacters() {
		return characters;
	}

	public void setCharacters(String characters) {
		ArgumentChecks.isTrue(!characters.isBlank() && characters!=null,"The characters cannot be null or blank");
		this.characters = characters;
	}

	@Override
	public void print(PrintStream out) {
		super.print(out);
		out.println("Characters: "+getCharacters());
	}

}
