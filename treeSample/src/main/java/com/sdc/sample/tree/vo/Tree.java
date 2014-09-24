package com.sdc.sample.tree.vo;

import java.util.List;

public class Tree {
	private Node node;
	private List<Tree> childs;
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public List<Tree> getChilds() {
		return childs;
	}
	public void setChilds(List<Tree> childs) {
		this.childs = childs;
	}
	
	public boolean hasChilds() {
		return ((childs != null) && (childs.size() > 0)); 
	}
}
