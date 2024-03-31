import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class CommandWords
{
    private HashMap<String, CommandWord> validCommands = new HashMap<>();

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        for(CommandWord command : CommandWord.values())
        {
            if(command != CommandWord.UNKNOWN)
            {
                validCommands.put(command.toString(),command);
            }
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    public CommandWord getCommandWord(String aString) {
        if (!isCommand(aString)) return CommandWord.UNKNOWN;
        return validCommands.get(aString);
    }

    public String getCommandString() {
        String returnString = "";
        for(String command : validCommands.keySet()) returnString += command + " ";
        return returnString;
    }

    public String getCommandString(CommandWord commandWord)
    {
        for(String commandString : validCommands.keySet())
        {
            if(validCommands.get(commandString).equals(commandWord))
            {
                return commandString;
            }
        }
        return null;
    }
}
