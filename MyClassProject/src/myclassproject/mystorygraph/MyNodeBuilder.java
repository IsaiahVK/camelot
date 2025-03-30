package myclassproject.mystorygraph;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;


public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	//Isaiah Kushner
	@BuilderMethod
	public void rootActions() {
		var root = get(MyNodeLabels.root.toString());
		root.add(new CreateAll(List.of(tavern, townSquare, ResidenceOffice, bedroom, diningHall, sword))
				.add(new CreateCharacterSequence(knight)).add(new CreateCharacterSequence(player))
				.add(new SetPosition(knight, tavern, "Barrel"))
				.add(new SetPosition(player, tavern))
				.add(new Face(knight, player))
				.add(new Draw(knight, sword))
				.add(new SetCameraFocus(player))
				.add(new ShowMenu()));
	}
	@BuilderMethod
	public void atTavernActions() {
		var node = get(MyNodeLabels.atTavern.toString());
		node.add(new HideMenu()).add(new EnableInput());
	}
	//Davis Voelkel
	@BuilderMethod
	public void knightTalkActions() {
		var node = get(MyNodeLabels.knightTalk.toString());
		node.add(new DialogSequence(player, knight, List.of("What do you seek from the great and wise knight, young lad?"),
				List.of("What's your advice?", "Watch this swordsmanship!")));
	}
	@BuilderMethod
	public void askForAdviceActions() {
		var node = get(MyNodeLabels.askForAdvice.toString());
		node.add(new DialogSequence(player, knight, List.of("It takes many years of training to hone your skills, young one. If you can prove your worth, you can catapault through the ranks."),
				List.of("How do I prove my worth?")));
	}
	//David Paul
	@BuilderMethod
	public void showOffSwordsmanshipActions() {
		var node = get(MyNodeLabels.showOffSwordsmanship.toString());
		node.add(new Draw(player, sword)).add(new Dance(player));
	}
	@BuilderMethod
	public void thankTheKnightActions() {
		var node = get(MyNodeLabels.thankTheKnight.toString());
		node.add(new DialogSequence(player, knight, List.of("Oh, you're welcome. Now move along."), List.of("Yes sir!")))
		.add(new Exit(player, tavernBackDoor, true)).add(new Enter(player, townSquareDoor, true))
		.add(new SetPosition(player, townSquare));
	}
	@BuilderMethod
	public void atTownSquareActions() {
		var node = get(MyNodeLabels.atTownSquare.toString());
		//actions for this node will come in next checkpoint
	}
}
