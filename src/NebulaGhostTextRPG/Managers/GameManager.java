package NebulaGhostTextRPG.Managers;

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
            commandManager.parseCommand(input, currentRoom, this);
            roomManager.navigateToRoom(currentRoom, exit);
        }
        //roomManager.loadRoom(roomManager.getCurrentActiveRoom());
    }

    public void setExit(Exits exitChosen) {
        this.exit = exitChosen;
    }

    public void setPlayerOption(String playerOption ){
        this.playerOption = playerOption;
    }

    public void quit() {
        isGameRunning = false;
        System.exit(0);
    }
}