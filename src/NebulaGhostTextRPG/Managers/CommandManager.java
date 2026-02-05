package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.CommandResult;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;

import java.util.List;

public class CommandManager {
    CommandResult cmdResult = new CommandResult();
    public CommandManager() {

    }

    public CommandResult parseCommand(String command, Room currentRoom) {
        if (command.matches("[A-Za-z]")) {
            if (command.equalsIgnoreCase("q")) {
                //QUIT
            }
            cmdResult.exit = parseMovement(command, currentRoom);
        }
        if (command.matches("0-15")) {
            cmdResult.playerOption = parseOption(command);
        }
        return cmdResult;
    }
    private String parseOption(String command) {
        //OPTIONS.
        String playerOption = "";
        return playerOption;
    }

    private Exits parseMovement(String command, Room currentRoom) {
        Exits exitChosen = null;
        List<Exits> availableExits = currentRoom.getExits();

        // read command from player
        if (command.equalsIgnoreCase("N") && availableExits.contains(Exits.NORTH)) {
            exitChosen = Exits.NORTH;
        } else if (command.equalsIgnoreCase("E") && availableExits.contains(Exits.EAST)) {
            exitChosen = Exits.EAST;
        } else if (command.equalsIgnoreCase("S") && availableExits.contains(Exits.SOUTH)) {
            exitChosen = Exits.SOUTH;
        } else if (command.equalsIgnoreCase("W") && availableExits.contains(Exits.WEST)){
            exitChosen = Exits.WEST;
        } else {
            invalidNavigationDir();
        }


        return exitChosen;
    }

    //Error Messages.
    private void invalidNavigationDir() {
        System.out.println("[ERROR]: Not a valid exit!");
    }
    private void invalidOption() {
        System.out.println("[ERROR]: Not a valid option!");
    }
}