package myclassproject.mystorygraph;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.storygraph.Graph;
import com.storygraph.NodeBuilder;

import myclassproject.mystorygraph.MyNodeLabels;

public class MyGraph extends Graph {

	public MyGraph(MyNodeLabels rootLabel) {
		super(Stream.of(MyNodeLabels.values()).map(z->z.toString()).collect(Collectors.toList()));    
	}
	
	/**
	 * @return A new object of MyNodeBuilder
	 */
	public NodeBuilder getNodeBuilder() {
		return new MyNodeBuilder(nodes);
	}
	
	/**
	 * @return A new object of MyEdgeBuilder
	 */
	public NodeBuilder getEdgeBuilder() {
		return new MyEdgeBuilder(nodes);
	}

}
