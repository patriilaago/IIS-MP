package uo.mp.lab03.socialnetwork.model;

import java.io.PrintStream;

import uo.mp.lab.util.check.ArgumentChecks;

public class Image extends Post{

	private String caption;
	private String fileName;
	
	public Image(String theUser, String theCaption, String theFileName) {
		super(theUser);
		setCaption(theCaption);
		setFileName(theFileName);
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		ArgumentChecks.isTrue(!caption.isBlank() && caption!=null,"The caption cannot be null or blank");
		this.caption = caption;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		ArgumentChecks.isTrue(!fileName.isBlank() && fileName!=null,"The filename cannot be null or blank");
		this.fileName = fileName;
	}

	@Override
	public void print(PrintStream out) {
		super.print(out);
		out.println("Caption: "+getCaption());
		out.println("Filename: "+getFileName());
	}
	
	
}
