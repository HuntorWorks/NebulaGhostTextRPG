package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Room;

import java.util.Scanner;
public class GameManager {

    private Scanner scanner = new Scanner(System.in);
    private boolean isGameRunning;

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
            var exit = commandManager.parseMovement(input, currentRoom);
            roomManager.navigateToRoom(currentRoom, exit);
        }
        //roomManager.loadRoom(roomManager.getCurrentActiveRoom());
    }
    public void quit() {
        isGameRunning = false;
        System.exit(0);
    }
}