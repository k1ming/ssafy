package com.ssafy.happyhouse.dto;

public class JoinPostsMembers {
	
	private Posts posts;
	private Members members;
	
	
	public JoinPostsMembers() {
		super();
	}
	public JoinPostsMembers(Posts posts, Members members) {
		super();
		this.posts = posts;
		this.members = members;
	}
	public Posts getPosts() {
		return posts;
	}
	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	@Override
	public String toString() {
		return "JoinPostsMembers [posts=" + posts + ", members=" + members + "]";
	}
	
}
