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
	public static final Place greatHall = new Place("Great Hall", PlaceTypes.GreatHall);
	public static final Place office = new Place("Office", PlaceTypes.Library);
	public static final Place bedroom = new Place("Bedroom", PlaceTypes.CastleBedroom);
	public static final Place campus = new Place("Campus", PlaceTypes.Camp);
	public static final Place diningHall = new Place("Dining Hall", PlaceTypes.DiningRoom);
	public static final Place dragonsDen = new Place("Dragon's Den", PlaceTypes.AlchemyShop);
	public static final Place hallway = new Place("Hallway", PlaceTypes.Hallway);
	public static final Item sword = new Item("Sword", ItemTypes.Sword);
	public static final Furniture tavernBackDoor = new Furniture(tavern, FurnitureTypes.Backdoor);
	public static final Furniture townSquareDoor = new Furniture(townSquare, FurnitureTypes.BrownHouseDoor);
}
