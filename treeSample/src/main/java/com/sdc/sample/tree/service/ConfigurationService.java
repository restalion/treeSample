package com.sdc.sample.tree.service;

import com.sdc.sample.tree.vo.ModelTree;
import com.sdc.sample.tree.vo.Tree;
import java.util.List;

public class ConfigurationService {

	public boolean match(ModelTree model, Tree tree) {
		
		if (tree.hasChilds()) {
			return(matchModelChilds(model.getModelChilds(), tree.getChilds()));
		} else {
			return model.includes(tree.getNode()); 
		}
	}
	
	private boolean matchModelChilds(List<ModelTree> listModel, List<Tree> childs) {
		boolean out = true;
		for (ModelTree model : listModel) {
			for (Tree child : childs) {
				out = model.includes(child.getNode());
				if (!out) break;
			}
			if (!out) break;
		}
		return out;
	}
}
