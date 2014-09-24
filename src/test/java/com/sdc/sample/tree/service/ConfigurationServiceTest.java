package com.sdc.sample.tree.service;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sdc.sample.tree.vo.ModelTree;
import com.sdc.sample.tree.vo.Node;
import com.sdc.sample.tree.vo.Tree;


public class ConfigurationServiceTest {

	@Test
	public void simpleMatch() {
		ConfigurationService conf = new ConfigurationService();
		assertTrue(conf.match(mountSimpleModel(), mountSimpleTree()));
	}

	@Test
	public void simpleUnMatch() {
		ConfigurationService conf = new ConfigurationService();
		assertFalse(conf.match(mountSimpleModel(), mountSimpleUnmatchTree()));
	}
	
	@Test
	public void oneLevelMatch() {
		ConfigurationService conf = new ConfigurationService();
		assertTrue(conf.match(mountOneLevelModel(), mountOneLevelTree()));
	}
	
	@Test
	public void oneLevelUnMatch() {
		ConfigurationService conf = new ConfigurationService();
		assertFalse(conf.match(mountOneLevelModelUnmatch(), mountOneLevelTree()));
	}
	
	/////////////////////////////////////////////////////////////
	
	private Tree mountSimpleTree() {
		Node one = new Node();
		one.setValue("one");
		
		Tree out = new Tree();
		out.setNode(one);
		
		return out;
	}
	
	private Tree mountSimpleUnmatchTree() {
		Node two = new Node();
		two.setValue("two");
		
		Tree out = new Tree();
		out.setNode(two);
		
		return out;
	}
	
	private ModelTree mountSimpleModel() {

		Node one = new Node();
		one.setValue("one");
		
		List<Node> modelNodes = new ArrayList<Node>();
		modelNodes.add(one);
		
		ModelTree model = new ModelTree();
		model.setModelNodes(modelNodes);
		
		return model;
	}
	
	private Tree mountOneLevelTree() {
		Node one = new Node();
		one.setValue("one");
		Node two = new Node();
		two.setValue("two");
		Node three = new Node();
		two.setValue("three");
		Tree treeTwo = new Tree();
		treeTwo.setNode(two);
		Tree treeThree = new Tree();
		treeThree.setNode(three);
		List<Tree> childs = new ArrayList<Tree>();
		childs.add(treeTwo);
		childs.add(treeThree);
		
		Tree out = new Tree();
		out.setNode(one);
		out.setChilds(childs);
		
		return out;
	}
	
	
	private ModelTree mountOneLevelModel() {

		Node x = new Node();
		x.setValue("x");
		
		Node one = new Node();
		one.setValue("one");
		
		List<Node> modelNodes = new ArrayList<Node>();
		modelNodes.add(one);
		modelNodes.add(x);
		
		ModelTree modelLevel1 = new ModelTree();
		Node two = new Node();
		two.setValue("two");
		Node three = new Node();
		two.setValue("three");
		
		List<Node> modelNodesLevel1 = new ArrayList<Node>();
		modelNodesLevel1.add(two);
		modelNodesLevel1.add(three);
		modelLevel1.setModelNodes(modelNodesLevel1);
		
		ModelTree model = new ModelTree();
		model.setModelNodes(modelNodes);
		List<ModelTree> childs = new ArrayList<ModelTree>();
		childs.add(modelLevel1);
		model.setModelChilds(childs);
		
		return model;
	}

	private ModelTree mountOneLevelModelUnmatch() {

		Node x = new Node();
		x.setValue("x");
		
		Node one = new Node();
		one.setValue("one");
		
		List<Node> modelNodes = new ArrayList<Node>();
		modelNodes.add(one);
		modelNodes.add(x);
		
		ModelTree modelLevel1 = new ModelTree();
		Node two = new Node();
		two.setValue("two");
		
		List<Node> modelNodesLevel1 = new ArrayList<Node>();
		modelNodesLevel1.add(two);
		modelNodesLevel1.add(x);
		modelLevel1.setModelNodes(modelNodesLevel1);
		
		ModelTree model = new ModelTree();
		model.setModelNodes(modelNodes);
		List<ModelTree> childs = new ArrayList<ModelTree>();
		childs.add(modelLevel1);
		model.setModelChilds(childs);
		
		return model;
	}
}
