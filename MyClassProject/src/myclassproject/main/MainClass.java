package myclassproject.main;

import com.storygraph.Story;

import myclassproject.mystorygraph.MyGraph;
import myclassproject.mystorygraph.MyNodeLabels;
public class MainClass {

	//This is the start of your program
	public static void main(String[] args) {
		//Create an object of your story class.
		var story = new Story();
		//Simply call run.
		story.Run(new MyGraph(MyNodeLabels.root));
	}

}
