package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.CommandResult;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;

import java.util.Scanner;
public class GameManager {

    private Scanner scanner = new Scanner(System.in);
    private boolean isGameRunning;
    private Exits exit;
    private String playerOption;

    RoomManager roomManager = new RoomManager();
    DialogueManager dialogueManager = new DialogueManager();
    CommandManager commandManager = new CommandManager();

    public GameManager() {
        isGameRunning = true;
    }

    public void run() {
        roomManager.generateRooms();

        while (isGameRunning) {
            Room currentRoom = roomManager.getCurrentActiveRoom();
            dialogueManager.showRoomDialogue(currentRoom);
            dialogueManager.showRoomNavigation(currentRoom);

            String input = scanner.next();
            CommandResult result = commandManager.parseCommand(input, currentRoom);
            if (result.exit != null && roomManager.isNavigating()) {
                roomManager.navigateToRoom(currentRoom, exit);
            }
            if (result.playerOption != null && dialogueManager.isOption()) {
                //handle option logic here.
            }
        }
        //roomManager.loadRoom(roomManager.getCurrentActiveRoom());
    }

    public void quit() {
        isGameRunning = false;
        System.exit(0);
    }
}