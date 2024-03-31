import java.util.ArrayList;

public class Player {
    public static final int ITEM_GONE = 0;
    public static final int ITEM_NOTPRESENT = 1;
    public static final int ITEM_NOTMOVEABLE = 2;
    private String name;
    private Room currentRoom;


    private ArrayList<Item> bag = new ArrayList<>();

    private int weight;

    private int maxWeight = 15;

    private int finaleScore;

    public Player(String name) {
        this.name = name;
        weight = 0;
        finaleScore = 0;
    }

    public String getName() {
        return name;
    }

    public boolean hasItem(String name)
    {
        for(Item item : bag)
        {
            if(item.getName().equals(name))
            {
                return true;
            }
        }
        return false;
    }

    public String getScoreDesc()
    {
        return "Your finaleScore is " + finaleScore;
    }

    public boolean canITakeItem(Item item)
    {
        return  weight + item.getWeight() <= maxWeight;
    }

    public ArrayList<Item> getBag()
    {
        return bag;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addToWeightLimit(int increase)
    {
        maxWeight += increase;
    }


    public int take(String name) {
        if (currentRoom.hasItem(name)) {
            Item item = currentRoom.getItem(name);
            if (item!=null) {
                if (!item.isMoveable()) return ITEM_NOTMOVEABLE; // is niet moveable
                if(!canITakeItem(item)) return 3;
                weight += item.getWeight();
                finaleScore += item.getScore();
                bag.add(item);
            }
            return ITEM_GONE; // is gelukt
        }
        return ITEM_NOTPRESENT; // bestaat niet
    }

    public Item drop(String name) {
        for(int i = 0; i< bag.size();i++)
        {
            if(bag.get(i).getName().equals(name))
            {
                Item remItem = bag.get(i);
                bag.remove(i);
                weight -= remItem.getWeight();
                finaleScore -= remItem.getScore();
                return remItem;
            }
        }
        System.out.println("You don't have this item in your bag!");
        return null;
    }

    public String getLongDescription() {
        String returnString = "Player " + name + " has following items in his bag:";
        for (Item i : bag) {
            returnString += System.lineSeparator() + "  " + i.getItemDescription();
        }
        returnString += "\nYou bag is "+ weight + "kg heavy. ";
        returnString += "\nThe max weight you can take is "+ maxWeight + "kg!";
        return returnString;
    }
}
