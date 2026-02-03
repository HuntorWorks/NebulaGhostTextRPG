package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;

import java.util.Scanner;
public class GameManager {

    private Scanner scanner = new Scanner(System.in);
    private boolean isGameRunning;

    RoomManager roomManager = new RoomManager();
    DialogueManager dialogueManager = new DialogueManager();

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

            if (input.equalsIgnoreCase("q")) {
                quit();
            } else if (input.equalsIgnoreCase("1")) {
                roomManager.navigateToRoom(roomManager.getCurrentActiveRoom(), Exits.NORTH);
            }
        }
        //roomManager.loadRoom(roomManager.getCurrentActiveRoom());
    }
    public void quit() {
        isGameRunning = false;
        System.exit(0);
    }
}