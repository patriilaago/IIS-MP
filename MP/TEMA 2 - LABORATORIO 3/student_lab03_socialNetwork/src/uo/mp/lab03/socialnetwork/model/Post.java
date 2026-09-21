package uo.mp.lab03.socialnetwork.model;

import java.io.PrintStream;
import java.util.ArrayList;

import uo.mp.lab.util.check.ArgumentChecks;

public class Post {

	private String user;
	private ArrayList <String> comments;
	private int likes;
	private boolean print;
	
	Post(String theUser) {
		setUser(theUser);
		setComments(new ArrayList<String>());
		setPrint(false);
		setLikes(0);
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		ArgumentChecks.isTrue(!user.isBlank() && user!=null,"The user cannot be null or blank");
		this.user = user;
	}

	public ArrayList <String> getComments() {
		return comments;
	}

	public void setComments(ArrayList <String> comments) {
		this.comments = comments;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		ArgumentChecks.isTrue(likes>=0,"The number of likes cannot be lower than 0");
		this.likes = likes;
	}

	public boolean getPrint() {
		return print;
	}

	public void setPrint(boolean print) {
		this.print = print;
	}

	public void print(PrintStream out) {
		out.println("User: "+getUser());
		out.println("Likes: "+getLikes());
		out.println("Comments: "+getComments());
		if(getPrint()==true) {
			out.println("Printed: YES");
		}
		else {
			out.println("Printed: NO");
		}
	}

}
