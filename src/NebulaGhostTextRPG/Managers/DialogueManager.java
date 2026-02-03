package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Room;

import java.io.IOException;

public class DialogueManager {
    public DialogueManager() {

    }

    public void showRoomDialogue(Room room) {
        System.out.println(room.getRoomName());
    }

    public void showRoomNavigation(Room room) {
        StringBuilder navSb = new StringBuilder();
        var exits = room.getExits();

        navSb.setLength(0);
        for (var exit : exits) {
            navSb.append(exit.getDisplayName());
        }
        System.out.println(navSb);
    }
}
