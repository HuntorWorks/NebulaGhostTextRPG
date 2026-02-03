package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;

import java.util.List;

public class CommandManager {
    public CommandManager() {

    }

    public void parseCommand(String command, Room currentRoom, GameManager gameManager) {
        if (command.matches("[A-Za-z]")) {
            if (command.equalsIgnoreCase("q")) {
                gameManager.quit();
            }
            parseMovement(command, currentRoom, gameManager);
        }
        if (command.matches("0-15")) {
            parseOption(command, gameManager);
        }

    }
    private void parseOption(String command, GameManager gameManager) {
        //OPTIONS.
        String playerOption = "";
        gameManager.setPlayerOption(playerOption);
    }

    private void parseMovement(String command, Room currentRoom, GameManager gameManager) {
        Exits exitChosen = null;
        List<Exits> availableExits = currentRoom.getExits();

        // read command
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

        gameManager.setExit(exitChosen);
    }

    //Error Messages.
    private void invalidNavigationDir() {
        System.out.println("[ERROR]: Not a valid exit!");
    }
    private void invalidOption() {
        System.out.println("[ERROR]: Not a valid option!");
    }
}
