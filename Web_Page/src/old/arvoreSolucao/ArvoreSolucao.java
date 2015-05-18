package old.arvoreSolucao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import lombok.Data;

@SuppressWarnings("hiding")
public @Data class ArvoreSolucao<Node>{

	private Node head;
	
	private ArrayList<ArvoreSolucao<Node>> leafs = new ArrayList<ArvoreSolucao<Node>>();
	
	private ArvoreSolucao<Node> parent = null;
	
	private HashMap<Node, ArvoreSolucao<Node>> locate = new HashMap<Node, ArvoreSolucao<Node>>();
	
	public ArvoreSolucao(Node head){
		this.head = head;
		locate.put(head, this);
	}
	
	public void addLeaf(Node root, Node leaf) {
	    if (locate.containsKey(root)) {
	      locate.get(root).addLeaf(leaf);
	    } else {
	      addLeaf(root).addLeaf(leaf);
	    }
	}
	
	public void remove(){
		int indice = this.getParent().getLeafs().indexOf(this);
		this.getParent().getLeafs().remove(indice);
	}
	
	 public ArvoreSolucao<Node> addLeaf(Node leaf) {
	    ArvoreSolucao<Node> t = new ArvoreSolucao<Node>(leaf);
	    leafs.add(t);
	    t.parent = this;
	    t.locate = this.locate;
	    locate.put(leaf, t);
	    return t;
	 }
	 
	 public ArvoreSolucao<Node> setAsParent(Node parentRoot) {
	    ArvoreSolucao<Node> t = new ArvoreSolucao<Node>(parentRoot);
	    t.leafs.add(this);
	    this.parent = t;
	    t.locate = this.locate;
	    t.locate.put(head, this);
	    t.locate.put(parentRoot, t);
	    return t;
	 }
	 
	  public Node getHead() {
	    return head;
	  }

	  public ArvoreSolucao<Node> getTree(Node element) {
	    return locate.get(element);
	  }
	  

	  public ArvoreSolucao<Node> getParent() {
	    return parent;
	  }

	  public Collection<Node> getSuccessors(Node root) {
	    Collection<Node> successors = new ArrayList<Node>();
	    ArvoreSolucao<Node> tree = getTree(root);
	    if (null != tree) {
	      for (ArvoreSolucao<Node> leaf : tree.leafs) {
	        successors.add(leaf.head);
	      }
	    }
	    return successors;
	  }

	  public Collection<ArvoreSolucao<Node>> getSubTrees() {
	    return leafs;
	  }

	  public static <Node> Collection<Node> getSuccessors(Node of, Collection<ArvoreSolucao<Node>> in) {
	    for (ArvoreSolucao<Node> tree : in) {
	      if (tree.locate.containsKey(of)) {
	        return tree.getSuccessors(of);
	      }
	    }
	    return new ArrayList<Node>();
	  }

	  @Override
	  public String toString() {
		  return printTree(0);
	  }

	  private static final int indent = 2;

	  private String printTree(int increment) {
		  String s = "";
		  String inc = "";
		  for (int i = 0; i < increment; ++i) {
			  inc = inc + " ";
		  }
		  s = inc + head;
		  for (ArvoreSolucao<Node> child : leafs) {
			  s += "\n" + child.printTree(increment + indent);
		  }
		  return s;
	  }
	  
	  public String printWebPage() {
		  String s = "";
		  
		  for (ArvoreSolucao<Node> child : this.getLeafs()) {
			  Node no = child.getHead();
			  
		  }
		  return s;
	  }
	}

		   

