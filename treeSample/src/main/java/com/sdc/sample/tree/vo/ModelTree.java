package com.sdc.sample.tree.vo;

import java.util.List;

public class ModelTree {
	private List<Node> modelNodes;
	private List<ModelTree> modelChilds;
	
	public boolean includes(Node node) {
		boolean include = false;
		for (Node actualNode :  modelNodes) {
			include = actualNode.equals(node);
			if (include) break;
		}
		return include;
	}

	public List<Node> getModelNodes() {
		return modelNodes;
	}

	public void setModelNodes(List<Node> modelNodes) {
		this.modelNodes = modelNodes;
	}
	
	public List<ModelTree> getModelChilds() {
		return modelChilds;
	}

	public void setModelChilds(List<ModelTree> modelChilds) {
		this.modelChilds = modelChilds;
	}
	
}
