package myclassproject.mystorygraph;

import com.entities.*;
import com.enums.*;

public final class MyStoryEntities {
	//Create an instance of Character, Place, Furniture, and Item classes 
	//for each of the characters, places, furniture, and items in your story
	//Make that instance public static final
	//e.g. public static final Characters player = new Characters("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	//You can access these instances in your EdgeBuilder and NodeBuilder classes by importing:
	//import static myclassproject.mystorygraph.MyStoryEntities.*;
	public static final Characters player = new Characters("Player", BodyTypes.H, Clothing.LightArmour, HairStyle.Long, Colors.Black, 5);
	public static final Characters knight = new Characters("Knight", BodyTypes.F, Clothing.HeavyArmour, HairStyle.Short_Full, Colors.Black, 10);
	public static final Place tavern = new Place("Tavern", PlaceTypes.Tavern);
	public static final Place townSquare = new Place("Town Square", PlaceTypes.City);
	public static final Place residenceOffice = new Place("Residence Office", PlaceTypes.Blacksmith);
	public static final Place bedroom = new Place("Bedroom", PlaceTypes.CastleBedroom);
	public static final Place diningHall = new Place("Dining Hall", PlaceTypes.DiningRoom);
	public static final Place hallway = new Place("Hallway", PlaceTypes.Hallway);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Furniture tavernBackDoor = new Furniture(tavern, FurnitureTypes.Backdoor);
	public static final Furniture townSquareDoor = new Furniture(townSquare, FurnitureTypes.BrownHouseDoor);
	public static final Furniture residenceOfficeDoor = new Furniture(residenceOffice, FurnitureTypes.Door);
	public static final Characters friend1 = new Characters("Friend1",BodyTypes.E,Clothing.Noble,HairStyle.Ponytail,Colors.Blonde,5);
	public static final Characters friend2 = new Characters("Friend2",BodyTypes.B,Clothing.Merchant,HairStyle.Spiky,Colors.Brown,5);
	public static final Place veyltharManor = new Place("Veylthar Manor",PlaceTypes.AlchemyShop);
	public static final Place solaraKeep = new Place("Eryndor Hall",PlaceTypes.Dungeon);
	public static final Place clubFair = new Place("Club Fair",PlaceTypes.GreatHall);
	public static final Characters oldLady = new Characters("Old Lady", BodyTypes.G, Clothing.Noble, HairStyle.Short, Colors.Gray, 5);
	public static final Item roomKey= new Item("Room Key",ItemTypes.BlueKey);
	public static final Item dragonfireDumpling = new Item("Dragonfire Dumpling", ItemTypes.Apple);
	public static final Item roastedBoar = new Item("Roasted Boar", ItemTypes.ChickenLeg);
	public static final Item meatPies = new Item("Meat Pies",ItemTypes.Bread);
	public static final Item mysteriousScroll = new Item("Mysterious Scroll", ItemTypes.Scroll);
	public static final Item bladeOfChaos = new Item("Blade of Chaos", ItemTypes.Sword);
	public static final Item wandOfPrimordialPasssion = new Item("Wand of Primordial Passion", ItemTypes.LitTorch);
	public static final Furniture bedroomDoor = new Furniture(bedroom, FurnitureTypes.Door);
	public static final Furniture bedroomTable = new Furniture(bedroom, FurnitureTypes.Table);
	public static final Furniture diningHallDoor = new Furniture(diningHall, FurnitureTypes.Door);
	public static final Furniture diningTable = new Furniture(diningHall, FurnitureTypes.Table);
	public static final Furniture clubFairDoor = new Furniture(clubFair, FurnitureTypes.Gate);
	public static final Furniture bed = new Furniture(bedroom, FurnitureTypes.Bed);
}
