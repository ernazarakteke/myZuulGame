public enum CommandWord {
    GO("go"),ITEMS("items"),BACK("back"), TAKE("take"), DROP("drop"), LOOK("look"), EAT("eat"), QUIT("quit"), HELP("help"), UNKNOWN("?");

    private String commandString;

    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }

    public String toString()
    {
        return commandString;
    }
}
