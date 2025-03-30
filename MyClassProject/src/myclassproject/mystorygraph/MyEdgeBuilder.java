package myclassproject.mystorygraph;

import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.*;

import static myclassproject.mystorygraph.MyStoryEntities.*;

public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method should add the edges of the node one by one. 
	 * These methods must have a BuilderMethod annotation.
	 */
	//Isaiah Kushner
	@BuilderMethod
	public void rootEdges() {
		var root = get(MyNodeLabels.root.toString());
		var choice = new MenuChoice(MenuChoice.Options.Start);
		var nextNode = get(MyNodeLabels.atTavern.toString());
		root.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void atTavernEdges() {
		var node = get(MyNodeLabels.atTavern.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToKnight.toString(), knight, Icons.talk, "Talk to knight");
		var nextNode = get(MyNodeLabels.knightTalk.toString());
		node.add(new Edge(choice, nextNode));
	}
	//Davis Voelkel
	@BuilderMethod
	public void knightTalkEdges() {
		var node = get(MyNodeLabels.knightTalk.toString());
		var choice1 = new DialogChoice("What's your advice?");
		var nextNode1 = get(MyNodeLabels.askForAdvice.toString());
		node.add(new Edge(choice1, nextNode1));
		
		var choice2 = new DialogChoice("Watch this swordsmanship!");
		var nextNode2 = get(MyNodeLabels.showOffSwordsmanship.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	@BuilderMethod
	public void askForAdviceEdges() {
		var node = get(MyNodeLabels.askForAdvice.toString());
		var choice = new DialogChoice("Thank you!");
		var nextNode = get(MyNodeLabels.thankTheKnight.toString());
		node.add(new Edge(choice, nextNode));
	}
	//David Paul
	@BuilderMethod
	public void showOffSwordsmanshipEdge() {
		var node = get(MyNodeLabels.showOffSwordsmanship.toString());
		var choice = new PlayerInteraction(player, MyChoiceLabels.ShowOffSwordsmanship.toString(), knight);
		var nextNode = get(MyNodeLabels.thankTheKnight.toString());
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void thankTheKnightEdge() {
		var node = get(MyNodeLabels.thankTheKnight.toString());
		var choice = new DialogChoice("Yes sir!");
		var nextNode = get(MyNodeLabels.leaveTavern.toString());
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void leaveTavernEdge() {
		var node = get(MyNodeLabels.leaveTavern.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.Leave.toString(), tavernBackDoor, Icons.exit, "Go to town square");
		var nextNode = get(MyNodeLabels.atTownSquare.toString());
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void atTownSquareEdge() {
		var node = get(MyNodeLabels.atTownSquare.toString());
		var choice = new DialogChoice("So excited!");
		var nextNode = get(MyNodeLabels.friendResponse.toString());
		node.add(new Edge(choice, nextNode));
	}
	@BuilderMethod
	public void friendResponseEdge() {
		var node = get(MyNodeLabels.friendResponse.toString());
		var choice1 = new DialogChoice("Veylthar Manor");
		var nextNode1 = get(MyNodeLabels.velytharManor.toString());
		node.add(new Edge(choice1, nextNode1));
		
		var choice2 = new DialogChoice("Solara Keep");
		var nextNode2 = get(MyNodeLabels.solaraKeepActions.toString());
		node.add(new Edge(choice2, nextNode2));
	}
}
