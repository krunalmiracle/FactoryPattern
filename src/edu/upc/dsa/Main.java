package edu.upc.dsa;

public class Main {

    public static void main(String[] args) {
        Command command = CommandFactory.getInstance().getCommand("C1");
        command.execute();
    }
}
