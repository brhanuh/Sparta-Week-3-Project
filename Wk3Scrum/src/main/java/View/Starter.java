package View;


import Controller.ControllerClass;

public class Starter {

    public static void start() {
        ControllerClass cc = new ControllerClass();
        cc.printEmployeesToConsole();
        cc.searchByLastName();

    }

}
