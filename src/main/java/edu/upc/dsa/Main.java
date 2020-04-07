package edu.upc.dsa;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
public class Main {

    //Implementing Log4j
    static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        //COnfiguring Log4j
        //Configure logger
        BasicConfigurator.configure();
        logger.debug("Debug Test Message!");
        logger.info("Info Test Message");
        logger.warn("warning  Test Message!");
        logger.error("error Test Message");
        //Command Factory using singleton instantiation of Command 1
        Command c = CommandFactory.getInstance().getCommand("C1"); // Classloader (C1)
        logger.debug("Classloader C1 execution!");
        c.execute();
        c =  CommandFactory.getInstance().getCommand("C1");  // Cache (C1)
        logger.debug("Cached C1 execution!");
        c.execute();
        //Command Factory using singleton instantiation of Command 2
        Command c2 = CommandFactory.getInstance().getCommand("C2"); // Classloader (C2)
        logger.debug("Classloader C2 execution!");
        c2.execute();
        c2 =  CommandFactory.getInstance().getCommand("C2");  // Cache (C2)
        logger.debug("Cached C2 execution!");
        c2.execute();
        //Factory with singleton execution directly
        //Command 1
        logger.debug("C1 execution directly!");
        CommandFactory.getInstance().getCommand("C1").execute();
        //Command 2
        logger.debug("C2 execution directly!");
        CommandFactory.getInstance().getCommand("C2").execute();
    }
}
