package uo.mp.lab03.socialnetwork.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab.util.check.ArgumentChecks;
import uo.mp.lab03.socialnetwork.model.Post;

public class SocialNetwork {

	private List<Post> posts = new ArrayList<>();
	
	List<Post> getPosts(){
		return posts;
	}
	
	public void addPost(Post thePost) {
		ArgumentChecks.isTrue(thePost!=null, "The post you want to add cannot be null");
		if(!posts.contains(thePost)) {
			posts.add(thePost);
		}
	}
	
	public void listAllPosts(PrintStream out) {
		for(Post post: posts) {
			post.print(out);
			out.println();
		}
	}
	
	/**
	 * 
	 * @param theUser user we want to search for its posts
	 * @return
	 * @throws IllegalArgumentException in case the user is null or blank
	 */
	public List<Post> findPostByUser(String theUser){
		ArgumentChecks.isTrue(!theUser.isBlank() && theUser!=null, "The user you want to search for its posts cannot be null or blank");
		List<Post> user_posts = new ArrayList<>();
		for(Post post : posts) {
			if(post.getUser().equals(theUser)) {
				user_posts.add(post);
			}
		}
		return user_posts;
	}
}
