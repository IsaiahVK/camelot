
package myclassproject.mystorygraph;

import java.util.List;

import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.*;

import static myclassproject.mystorygraph.MyStoryEntities.*;
import static myclassproject.mystorygraph.MyChoiceLabels.*;

public class MyEdgeBuilder extends NodeBuilder {
	/**
	 * Initializes the list of story graph nodes.
	 * @param list A list of all story graph nodes.
	 */
	public MyEdgeBuilder(List<Node> list) {
		super(list);
	}

	// Isaiah Kushner
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

	// Davis Voelkel
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

	// David Paul
	@BuilderMethod
	public void showOffSwordsmanshipEdge() {
		var node = get(MyNodeLabels.showOffSwordsmanship.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.ThankKnight.toString(), knight, Icons.talk, "Thank the knight");
		var nextNode = get(MyNodeLabels.thankTheKnight.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void thankTheKnightEdge() {
		var node = get(MyNodeLabels.thankTheKnight.toString());
		var choice = new DialogChoice("Yes sir!");
		var nextNode = get(MyNodeLabels.atTownSquare.toString());
		node.add(new Edge(choice, nextNode));
	}


	@BuilderMethod
	public void atTownSquareEdge() {
		var node = get(MyNodeLabels.atTownSquare.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToFriend.toString(), friend1, Icons.talk, "Talk to Ella");
		var nextNode = get(MyNodeLabels.friendTalk.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void friendTalkEdge() {
		var node = get(MyNodeLabels.friendTalk.toString());
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

	//Isaiah Kushner

	@BuilderMethod
	public void velytharManorEdge() {
		var node = get(MyNodeLabels.velytharManor.toString());
		var choice = new DialogChoice("See you later! I'm going to get my key.");
		var nextNode = get(MyNodeLabels.atResidenceOffice.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void solaraKeepActionsEdge() {
		var node = get(MyNodeLabels.solaraKeepActions.toString());
		var choice = new DialogChoice("Oh it sucks so much that we can't be roommates. I guess I will see you later. I'm heading to grab my key.");
		var nextNode = get(MyNodeLabels.atResidenceOffice.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void atResidenceOfficeEdge() {
		var node = get(MyNodeLabels.atResidenceOffice.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkToLady.toString(), oldLady, Icons.talk, "Talk to residence manager");
		var nextNode = get(MyNodeLabels.ladyTalk.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void ladyTalkEdge() {
		var node = get(MyNodeLabels.ladyTalk.toString());
		var choice = new DialogChoice("Thank you ma' am.");
		var nextNode = get(MyNodeLabels.atRoom.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	

	@BuilderMethod
	public void atRoomEdge() {
		var node = get(MyNodeLabels.atRoom.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.PickUpScroll.toString(), mysteriousScroll, Icons.openscroll, "Read the mysterious scroll");
		var nextNode = get(MyNodeLabels.readScroll.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void readScrollEdge() {
		var node = get(MyNodeLabels.readScroll.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.scrollDone.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void scrollDone() {
		var node = get(MyNodeLabels.scrollDone.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.WingIt.toString(), friend2, Icons.talk, "Talk to Corey");
		var nextNode = get(MyNodeLabels.wingIt.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void wingItEdge() {
		var node = get(MyNodeLabels.wingIt.toString());
		var choice1 = new DialogChoice("I'm hungry!");
		var nextNode1 = get(MyNodeLabels.atDiningHall.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("I want to see some clubs.");
		var nextNode2 = get(MyNodeLabels.bedroomToClub.toString());
		node.add(new Edge(choice2, nextNode2));
	}
	
	@BuilderMethod
	public void atDiningHallEdge() {
		var node = get(MyNodeLabels.atDiningHall.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.chooseEat.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void chooseEatEdge() {
		var node = get(MyNodeLabels.chooseEat.toString());
		var choice1 = new PlayerInteraction(MyChoiceLabels.DragonfireDumpling.toString(), dragonfireDumpling, Icons.apple, "Eat Dragonfire Dumpling");
		var nextNode1 = get(MyNodeLabels.eatDumpling.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new PlayerInteraction(MyChoiceLabels.RoastedBoar.toString(), roastedBoar, Icons.apple, "Eat Roasted Boar");
		var nextNode2 = get(MyNodeLabels.eatBoar.toString());
		node.add(new Edge(choice2, nextNode2));

		var choice3 = new PlayerInteraction(MyChoiceLabels.MeatPies.toString(), meatPies, Icons.apple, "Eat Meat Pies");
		var nextNode3 = get(MyNodeLabels.eatPie.toString());
		node.add(new Edge(choice3, nextNode3));
	}



	@BuilderMethod
	public void eatDumplingEdge() {
		var node = get(MyNodeLabels.eatDumpling.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.diningToClub.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void eatBoarEdge() {
		var node = get(MyNodeLabels.eatBoar.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.diningToClub.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void eatPieEdge() {
		var node = get(MyNodeLabels.eatPie.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.diningToClub.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void diningToClubEdge() {
		var node = get(MyNodeLabels.diningToClub.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkAtClub.toString(), friend3, Icons.talk, "Talk to Alireza");
		var nextNode = get(MyNodeLabels.atClubFair.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void bedroomToClubEdge() {
		var node = get(MyNodeLabels.bedroomToClub.toString());
		var choice = new PlayerInteraction(MyChoiceLabels.TalkAtClub.toString(), friend3, Icons.talk, "Talk to Alireza");
		var nextNode = get(MyNodeLabels.atClubFair.toString());
		node.add(new Edge(choice, nextNode));
	}
	
	@BuilderMethod
	public void atClubFairEdge() {
		var node = get(MyNodeLabels.atClubFair.toString());
		var choice = new DialogChoice("Sure! I love your recurve bow. Sign me up!");
		var nextNode = get(MyNodeLabels.backToBed.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void backToBedEdge() {
		var node = get(MyNodeLabels.backToBed.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.atHallway.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void atHallwayEdge() {
		var node = get(MyNodeLabels.atHallway.toString());
		var choice1 = new DialogChoice("Blade of Chaos");
		var nextNode1 = get(MyNodeLabels.bladeOfChaos.toString());
		node.add(new Edge(choice1, nextNode1));

		var choice2 = new DialogChoice("Wand of Primordial Passion");
		var nextNode2 = get(MyNodeLabels.wandOfPrimordialPassion.toString());
		node.add(new Edge(choice2, nextNode2));
	}

	@BuilderMethod
	public void bladeOfChaosEdge() {
		var node = get(MyNodeLabels.bladeOfChaos.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.useBlade.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void wandOfPrimordialPassionEdge() {
		var node = get(MyNodeLabels.wandOfPrimordialPassion.toString());
		var choice = new CloseNarrationChoice();
		var nextNode = get(MyNodeLabels.useWand.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void useBladeEdge() {
		var node = get(MyNodeLabels.useBlade.toString());
		var choice = new DialogChoice("Thank you for this test.");
		var nextNode = get(MyNodeLabels.endGame.toString());
		node.add(new Edge(choice, nextNode));
	}

	@BuilderMethod
	public void useWandEdge() {
		var node = get(MyNodeLabels.useWand.toString());
		var choice = new DialogChoice("Thank you for this test.");
		var nextNode = get(MyNodeLabels.endGame.toString());
		node.add(new Edge(choice, nextNode));
	}
}
