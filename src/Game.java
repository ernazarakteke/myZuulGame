import java.util.Stack;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game
{
    private Parser parser;
    private Player player;

    private Stack<Room> path;


    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        player = new Player("Ernazar");
        createRooms();
        parser = new Parser();
        path = new Stack<>();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {

        Room topOfMountain, cavesOfBabul, waterfallsOfKuangSi, castleOfAzkaban;
        Room lakeOfSyphera, mountainsOfTaskentou, lostCityOfLagos, icemountainsOfZhangmu;
        Room ruinsOfAlexandria, vulcanoOfQrutas, emptinessOfKira, rocksOfYuggera;
        Room woodsOfJoaoPessoa, bridgesOfFuture, desertOfAlJadida, theBeach;
        Item glasses = new Item("glasses", "glasses of a person", 2,3);
        Item camera = new Item("camera", "camera with scenes of the crash", 3,5);
        Item cookie = new Item("cookie","a magical cookie",0,0);
        Item goblet = new Item("goblet","the goblet of fire",4,5);
        Item throne = new Item("throne","the throne of slytherin",10,5);
        Item mirror = new Item("mirror","the mirror of darkness",3,2);
        Item skeleton = new Item("skeleton","the skeleton of avicena",35,10);
        Item water = new Item("water","4 bottles of water",3,3);
        Item crystal = new Item("crystal","crystal of zhangmu",3,5);
        Item sword = new Item("sword","sword of alexander the great",5,5);
        Item armor = new Item("armor","armor of the great Alexander",15,10);
        Item phone = new Item("phone","phone with valuable information",3,6);
        Item rock = new Item("rock","rock made out of gold",60,20);
        Item elixer = new Item("elixer","1 bottle of elixer of youth",2,4);
        Item bricks = new Item("bricks","bricks made out of graphine",30,10);
        Item table = new Item("table","table made out of graphine",40,10);

        // create the rooms
        topOfMountain = new Room("on the top of the mountain");
        cavesOfBabul = new Room("inside of the caves of Babul");
        waterfallsOfKuangSi = new Room("in the waterfalls of Kuang-Si");
        castleOfAzkaban = new Room("in the castle of Azkaban");
        lakeOfSyphera = new Room("in the lake of Syphera");
        mountainsOfTaskentou = new Room("on the mountains of Taskentou");
        lostCityOfLagos = new Room("in the lost City of Lagos");
        icemountainsOfZhangmu = new Room("climbing on the ice mountains of Zhangmu");
        ruinsOfAlexandria = new Room("in the ruins of Alexandria");
        vulcanoOfQrutas = new Room("in the vulcano of Qrutas");
        emptinessOfKira = new Room("lost in the emptiness of Kira");
        rocksOfYuggera = new Room("on the rocks of Yuggera");
        woodsOfJoaoPessoa = new Room("in the woods of Joao Pessoa");
        bridgesOfFuture = new Room("on the bridges of Future");
        desertOfAlJadida = new Room("in the desert of Al-Jadida");
        theBeach = new Room("on the beach where the help arrived");
        topOfMountain.addItem(camera);
        cavesOfBabul.addItem(cookie);
        waterfallsOfKuangSi.addItem(glasses);
        castleOfAzkaban.addItem(goblet);
        castleOfAzkaban.addItem(throne);
        throne.setMoveable(false);
        mountainsOfTaskentou.addItem(mirror);
        mountainsOfTaskentou.addItem(skeleton);
        skeleton.setMoveable(false);
        lostCityOfLagos.addItem(water);
        icemountainsOfZhangmu.addItem(crystal);
        ruinsOfAlexandria.addItem(sword);
        ruinsOfAlexandria.addItem(armor);
        armor.setMoveable(false);
        rocksOfYuggera.addItem(phone);
        rocksOfYuggera.addItem(rock);
        rock.setMoveable(false);
        woodsOfJoaoPessoa.addItem(elixer);
        bridgesOfFuture.addItem(bricks);
        bricks.setMoveable(false);
        bridgesOfFuture.addItem(table);
        table.setMoveable(false);

        
        // initialise room exits
        topOfMountain.setExit("north",cavesOfBabul);
        topOfMountain.setExit("east",lakeOfSyphera);
        cavesOfBabul.setExit("south",topOfMountain);
        cavesOfBabul.setExit("east",mountainsOfTaskentou);
        cavesOfBabul.setExit("north",waterfallsOfKuangSi);
        waterfallsOfKuangSi.setExit("south",cavesOfBabul);
        waterfallsOfKuangSi.setExit("east",lostCityOfLagos);
        waterfallsOfKuangSi.setExit("north",castleOfAzkaban);
        castleOfAzkaban.setExit("south",waterfallsOfKuangSi);
        castleOfAzkaban.setExit("east",icemountainsOfZhangmu);
        lakeOfSyphera.setExit("west",topOfMountain);
        lakeOfSyphera.setExit("north",mountainsOfTaskentou);
        lakeOfSyphera.setExit("east",ruinsOfAlexandria);
        mountainsOfTaskentou.setExit("north",lostCityOfLagos);
        mountainsOfTaskentou.setExit("east",vulcanoOfQrutas);
        mountainsOfTaskentou.setExit("south",lakeOfSyphera);
        mountainsOfTaskentou.setExit("west",cavesOfBabul);
        lostCityOfLagos.setExit("north",icemountainsOfZhangmu);
        lostCityOfLagos.setExit("east",emptinessOfKira);
        lostCityOfLagos.setExit("south",mountainsOfTaskentou);
        lostCityOfLagos.setExit("west",waterfallsOfKuangSi);
        icemountainsOfZhangmu.setExit("east",rocksOfYuggera);
        icemountainsOfZhangmu.setExit("south",lostCityOfLagos);
        icemountainsOfZhangmu.setExit("west",castleOfAzkaban);
        ruinsOfAlexandria.setExit("north",vulcanoOfQrutas);
        ruinsOfAlexandria.setExit("east",woodsOfJoaoPessoa);
        ruinsOfAlexandria.setExit("west",lakeOfSyphera);
        vulcanoOfQrutas.setExit("north",emptinessOfKira);
        vulcanoOfQrutas.setExit("east",bridgesOfFuture);
        vulcanoOfQrutas.setExit("south",ruinsOfAlexandria);
        vulcanoOfQrutas.setExit("west",mountainsOfTaskentou);
        emptinessOfKira.setExit("north",rocksOfYuggera);
        emptinessOfKira.setExit("east",desertOfAlJadida);
        emptinessOfKira.setExit("south",vulcanoOfQrutas);
        emptinessOfKira.setExit("west",lostCityOfLagos);
        rocksOfYuggera.setExit("east",theBeach);
        rocksOfYuggera.setExit("south",emptinessOfKira);
        rocksOfYuggera.setExit("west",icemountainsOfZhangmu);
        woodsOfJoaoPessoa.setExit("north",bridgesOfFuture);
        woodsOfJoaoPessoa.setExit("west",ruinsOfAlexandria);
        bridgesOfFuture.setExit("north",desertOfAlJadida);
        bridgesOfFuture.setExit("south",woodsOfJoaoPessoa);
        bridgesOfFuture.setExit("west",vulcanoOfQrutas);
        desertOfAlJadida.setExit("north",theBeach);
        desertOfAlJadida.setExit("south",bridgesOfFuture);
        desertOfAlJadida.setExit("west",emptinessOfKira);
        theBeach.setExit("south",desertOfAlJadida);
        theBeach.setExit("west",rocksOfYuggera);



        player.setCurrentRoom(topOfMountain);  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println();
        System.out.println("You are the only person who survived this plane crash, find your way to the beach!!");
        System.out.println("Be aware of what you can take, if it's too heavy it will break an the item will disappear!!! ");
        System.out.println("Type '" + CommandWord.HELP.toString() + "' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                return false;
            case HELP:
                printHelp();
                break;
            case GO:
                wantToQuit = goRoom(command);
                break;
            case TAKE:
                take(command);
                break;
            case DROP:
                dropItem(command);
                break;
            case LOOK:
                look();
                break;
            case EAT:
                eat(command);
                break;
            case ITEMS:
                System.out.println(player.getLongDescription());
                break;
            case BACK:
                goBack(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            default:
        }

        return wantToQuit;
    }

    private void look() {
        printLocationInfo();
    }



    private void eat(Command command) {
        if(!command.hasSecondWord())
        {
            System.out.println("You have eaten and are not hungry anymore");
            return;
        }

        if(command.getSecondWord().equals("cookie"))
        {
            if(player.hasItem("cookie"))
            {
                player.addToWeightLimit(10);
                System.out.println("You can take 10kg more!");
                return;
            }
        }
        System.out.println("I don't know what to eat");
    }

    private void goBack(Command command)
    {
        if (command.hasSecondWord())
        {
            System.out.println("If you want to go back you don't need a second word");
            return;
        }
        if (path.empty())
        {
            System.out.println("There is nowhere to go back");
            return;
        }

        player.setCurrentRoom(path.pop());
        printLocationInfo();
    }



    private void take(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Take what?");
            return;
        }
        String itemName = command.getSecondWord();
        int result = player.take(itemName);
        if (result == Player.ITEM_GONE) {
            printLocationInfo();
        } else if (result == Player.ITEM_NOTPRESENT) {
            System.out.println("There is no item with the name " + itemName);
        } else if (result == 3) {
            System.out.println("You can't take this item anymore, your bag is too heavy.OOOHNOOO "+itemName.toUpperCase()+" FELL AND IS BROKEN!!");
        }else {
            System.out.println("The item with name " + itemName + " is not moveable");
        }
    }

    private void dropItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Drop what?");
            return;
        }
        String itemName = command.getSecondWord();
        Item item = player.drop(itemName);
        if(item!= null)
        {
            player.getCurrentRoom().addItem(item);
            System.out.println("You just dropped "+ item.getName() +" out of your bag!");
            System.out.println();
            printLocationInfo();
        }
    }



    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the island.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   " + parser.getCommandString());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private boolean goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return false;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            path.push(player.getCurrentRoom());
            player.setCurrentRoom(nextRoom);
            printLocationInfo();
            if(player.getCurrentRoom().getDescription().equals("on the beach where the help arrived"))
            {
                System.out.println("You win!");
                System.out.println(player.getScoreDesc());
                return true;
            }
            if(player.getCurrentRoom().getDescription().equals("in the desert of Al-Jadida")||player.getCurrentRoom().getDescription().equals("in the vulcano of Qrutas"))
            {
                System.out.println("You lost!");
                return true;
            }
        }
        return false;
    }


    private void printLocationInfo() {
        System.out.println("Player " + player.getName() + " is " + player.getCurrentRoom().getLongDescription());
        System.out.println();
        System.out.println(player.getLongDescription());
        System.out.println();
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
