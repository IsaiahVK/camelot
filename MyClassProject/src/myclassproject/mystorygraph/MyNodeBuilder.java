package myclassproject.mystorygraph;

import static myclassproject.mystorygraph.MyStoryEntities.*;

import java.util.List;
import com.actions.*;
import com.actions.Cast.Spell;
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
		root.add(new CreateAll(List.of(tavern, townSquare, residenceOffice, bedroom, diningHall, hallway, sword, veyltharManor, solaraKeep, clubFair, roomKey, dragonfireDumpling, roastedBoar, meatPies, mysteriousScroll, bladeOfChaos, wandOfPrimordialPasssion))
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
				List.of("Thank you!")));
	}
	//David Paul
	@BuilderMethod
	public void showOffSwordsmanshipActions() {
		var node = get(MyNodeLabels.showOffSwordsmanship.toString());
		node.add(new HideDialog()).add(new Draw(player, sword)).add(new Dance(player));
	}
	@BuilderMethod
	public void thankTheKnightActions() {
		var node = get(MyNodeLabels.thankTheKnight.toString());
		node.add(new DialogSequence(player, knight, List.of("Oh, you're welcome. Now move along."), List.of("Yes sir!")));
	}
	@BuilderMethod 
	public void leaveTavernActions() {
		var node = get(MyNodeLabels.leaveTavern.toString());
		node.add(new HideDialog())
		.add(new Exit(player, tavernBackDoor, true)).add(new Enter(player, townSquareDoor, true))
		.add(new SetPosition(player, townSquare));
	}
	//Isaiah Kushner
	@BuilderMethod
	public void atTownSquareActions() {
		var node = get(MyNodeLabels.atTownSquare.toString());
		node.add(new CreateCharacterSequence(friend1)).add(new CreateCharacterSequence(friend2)).add(new SetPosition(friend1, townSquare, "EastEnd"))
		.add(new SetPosition(friend2, townSquare, "EastEnd")).add(new Face(friend1, player)).add(new Face(friend2, player))
		.add(new DialogSequence(player, friend1, List.of("Hey! Are you ready for the knight academy?"), List.of("So excited!")));
	}
	@BuilderMethod
	public void friendResponseActions() {
		var node = get(MyNodeLabels.friendResponse.toString());
		node.add(new DialogSequence(player, friend1, List.of("What house did you get?"), List.of("Veylthar Manor", "Solara Keep")));
	}
	@BuilderMethod
	public void velytharManorActions() {
		var node = get(MyNodeLabels.velytharManor.toString());
		node.add(new DialogSequence(player, friend1, List.of("Velythar Manor is the house of magicians and prophets. Harry Houdini founded the house to continue his legacy. We get to be roommates and embark on this journey together!"), List.of("See you later! I'm going to get my key.")));
	}
	@BuilderMethod
	public void solaraKeepActions() {
		var node = get(MyNodeLabels.solaraKeepActions.toString());
		node.add(new DialogSequence(player, friend1, List.of("Solara Keep is the house of aspiring knights and war mongers. Warriors of the Keep are known to be the protectors of these lands. I'm in Veylthar Manor."), List.of("Oh, it sucks so much that we can't be roommates. I guess I will see you later. I'm heading to grab my key.")))
		.add(new Exit(player, townSquareDoor, true)).add(new Enter(player, residenceOfficeDoor, true))
		.add(new SetPosition(player, residenceOffice));
	}
	@BuilderMethod
	public void atResidenceOfficeActions() {
		var node = get(MyNodeLabels.atResidenceOffice.toString());
		node.add(new HideDialog()).add(new CreateCharacterSequence(oldLady)).add(new SetPosition(oldLady, residenceOffice, "AlchemistTable"))
		.add(new Face(oldLady, player)).add(new Draw(oldLady, roomKey))
		.add(new DialogSequence(player, oldLady, List.of("Here is your room key, young lad. Enjoy your stay."), List.of("Thank you, ma' am.")))
		.add(new Draw(player, roomKey));
	}
	@BuilderMethod
	public void atRoomActions() {
		var node = get(MyNodeLabels.atRoom.toString());
		node.add(new HideDialog()).add(new Exit(player, residenceOfficeDoor, true)).add(new Enter(player, bedroomDoor, true))
		.add(new SetPosition(player, bedroom)).add(new SetPosition(mysteriousScroll, bedroomTable));
	}
	@BuilderMethod
	public void readScrollActions() {
		var node = get(MyNodeLabels.readScroll.toString());
		node.add(new NarrationSequence("There are many paths to greatness. The one you currently walk may make you happy momentarily, but not forever. You have the potential to be legendary or fade into the shadows of mediocrity. -The Knight"));
	}
	//Davis Voelkel
	@BuilderMethod
	public void wingItActions() {
		var node = get(MyNodeLabels.wingIt.toString());
		node.add(new HideNarration()).add(new CreateCharacterSequence(friend2)).add(new SetPosition(friend2, bedroom, "Couch"))
		.add(new Face(friend2, player)).add(new DialogSequence(player, friend2, List.of("Do you want to eat in the dining hall or go to the club fair?"), List.of("I'm hungry!", "I want to see some clubs.")));
	}
	@BuilderMethod
	public void atDiningHallActions() {
		var node = get(MyNodeLabels.atDiningHall.toString());
		node.add(new Exit(player, bedroomDoor, true)).add(new Enter(player, diningHallDoor, true)).add(new SetPosition(player, diningHall))
		.add(new SetPosition(dragonfireDumpling,diningTable)).add(new SetPosition(roastedBoar, diningTable)).add(new SetPosition(meatPies, diningTable))
		.add(new WalkTo(player, diningHall, "Table"))
		.add(new HideDialog()).add(new NarrationSequence("You arrive at the dining hall and you have never smelled anything so good! You look at the labels for the dishes and decide to eat one."));
	}
	@BuilderMethod
	public void eatDumplingActions() {
		var node = get(MyNodeLabels.eatDumpling.toString());
		node.add(new Take(player, dragonfireDumpling)).add(new Drink(player));
	}
	@BuilderMethod
	public void eatBoarActions() {
		var node = get(MyNodeLabels.eatBoar.toString());
		node.add(new Take(player, roastedBoar)).add(new Drink(player));
	}
	@BuilderMethod
	public void eatPieActions() {
		var node = get(MyNodeLabels.eatPie.toString()).add(new Drink(player));
		node.add(new Take(player, meatPies)).add(new Drink(player));
	}
	@BuilderMethod
	public void greatTasteActions() {
		var node = get(MyNodeLabels.greatTaste.toString());
		node.add(new NarrationSequence("This is the best food you have ever had. You have never felt more alive and nourished. Your skin glows radiently for a moment. Perhaps this food has magical properties."));
	}
	@BuilderMethod
	public void atClubFairActions() {
		var node = get(MyNodeLabels.atClubFair.toString());
		node.add(new Exit(player, bedroomDoor, true)).add(new Enter(player, clubFairDoor, true)).add(new SetPosition(player, clubFair))
		.add(new SetPosition(friend1, clubFair, "Supplicant")).add(new SetPosition(friend2, clubFair, "LeftFoyer"))
		.add(new WalkTo(player, clubFair, "LeftSupplicant")).add(new WalkTo(friend2, clubFair, "LeftSupplicant"))
		.add(new CreateCharacterSequence(friend1))
		.add(new DialogSequence(player, friend1, List.of("Hey! Want to join the archery club? It's a ton of fun!"),
				List.of("Sure! I love your recurve bow. Sign me up!")));
	}
	//David Paul
	@BuilderMethod
	public void clubFairToDiningHallActions() {
		var node = get(MyNodeLabels.clubFairToDiningHall.toString());
		node.add(new Exit(player, clubFairDoor, true)).add(new Enter(player, diningHallDoor, true)).add(new SetPosition(player, diningHall))
		.add(new HideDialog());
	}
	@BuilderMethod
	public void backToBedActions() {
		var node = get(MyNodeLabels.backToBed.toString());
		node.add(new Exit(player, diningHallDoor, true)).add(new Enter(player, bedroomDoor, true)).add(new SetPosition(player, bedroom))
		.add(new WalkTo(player, bed))
		.add(new Sleep(player, bed))
		.add(new NarrationSequence("You are dreaming."));
	}
	@BuilderMethod
	public void atHallwayActions() {
		var node = get(MyNodeLabels.atHallway.toString());
		node.add(new HideNarration()).add(new DialogSequence(player, player, List.of("Envision your future"), List.of("Blade of Chaos", "Wand of Primordial Passion")))
		.add(new SetPosition(player, hallway)).add(new CreateCharacterSequence(knight))
		.add(new SetPosition(knight, hallway, "Center")).add(new Face(knight, player));
	}
	@BuilderMethod
	public void bladeOfChaosActions() {
		var node = get(MyNodeLabels.bladeOfChaos.toString());
		node.add(new NarrationSequence("Wielded by Kratos Ghost of Sparta, this blade is limitless in its destructive capability. It takes a strong will to put them down when the job is done."));
	}
	@BuilderMethod
	public void wandOfPrimordialPassionActions() {
		var node = get(MyNodeLabels.wandOfPrimordialPassion.toString());
		node.add(new NarrationSequence("This legendary wand was used by Merlin himself to purge the dark forces from the lands. This wand allows you to control the four elements of reality as we know it: fire, lightning, water, and earth."));
	}
	@BuilderMethod
	public void useBladeActions() {
		var node = get(MyNodeLabels.useBlade.toString());
		node.add(new Draw(player, bladeOfChaos)).add(new WalkTo(player, knight))
		.add(new Attack(player, knight, true))
		.add(new Attack(player, knight))
		.add(new Kneel(knight))
		.add(new DialogSequence(player, knight, List.of("I yield. You are worthy."), List.of("Thank you for this test.")));
	}
	@BuilderMethod
	public void useWandActions() {
		var node = get(MyNodeLabels.useWand.toString());
		node.add(new Draw(player, wandOfPrimordialPasssion))
		.add(new Cast(player, knight, Spell.red))
		.add(new Cast(player, knight, Spell.blue))
		.add(new Kneel(knight))
		.add(new DialogSequence(player, knight, List.of("I yield. You are worthy."), List.of("Thank you for this test.")));
	}

	
}
