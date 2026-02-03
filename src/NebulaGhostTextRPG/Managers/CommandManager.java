package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;

import java.util.List;

public class CommandManager {
    public CommandManager() {

    }

    public Exits parseMovement(String command, Room currentRoom) {
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

        return exitChosen;
    }

    //Error Messages.
    private void invalidNavigationDir() {
        System.out.println("Not a valid exit!");
    }
}
