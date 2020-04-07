package edu.upc.dsa;
import java.util.HashMap;
public class CommandFactory {

    //Patrón Singleton con Tabla de Hash
    private HashMap<String, Command> MapNameToCommand;
    private static CommandFactory instance;

    private CommandFactory() {
        this.MapNameToCommand = new HashMap<>();
    }

    public static CommandFactory getInstance() {
        if (instance == null) instance = new CommandFactory();
        return instance;
    }

    public Command getCommand(String name) {
        Command command = this.MapNameToCommand.get(name);
        if (command == null) {
            command = getCommand2(name);
            this.MapNameToCommand.put(name, command);
        }
        return command;
    }
    public static Command getCommand2(String name) {
        Command command = null;
        Class clazz = null;
        try {
            clazz = Class.forName("edu.upc.dsa."+name);
            command = (Command) clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return command;
    }
}