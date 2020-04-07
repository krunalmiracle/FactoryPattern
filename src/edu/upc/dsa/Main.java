package edu.upc.dsa;

public class Main {

    public static void main(String[] args) {
        //Command Factory using singleton instantiation of Command 1
        Command c = CommandFactory.getInstance().getCommand("C1"); // Classloader (C1)

        c.execute();
        c =  CommandFactory.getInstance().getCommand("C1");  // Cache (C1)
        c.execute();
        //Command Factory using singleton instantiation of Command 2
        Command c2 = CommandFactory.getInstance().getCommand("C2"); // Classloader (C2)
        c2.execute();
        c2 =  CommandFactory.getInstance().getCommand("C2");  // Cache (C2)
        c2.execute();
        //Factory with singleton execution directly
        //Command 1
        CommandFactory.getInstance().getCommand("C1").execute();
        //Command 2
        CommandFactory.getInstance().getCommand("C2").execute();
    }
}
