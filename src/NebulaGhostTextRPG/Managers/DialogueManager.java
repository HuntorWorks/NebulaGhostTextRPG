package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Room;

import java.io.IOException;

public class DialogueManager {
    private boolean isOption;
    public DialogueManager() {
        this.isOption = false;
    }

    public void showRoomDialogue(Room room) {
        System.out.println(room.getRoomName());
        showRoomOptions(room);
    }

    public void showRoomOptions(Room room) {
        StringBuilder roomOptionsSB = new StringBuilder();

        var roomObjects = room.getRoomObjects();
        try {
            for (var object : roomObjects) {
                int index = 1;
                for (var interaction : object.getVisibleInteractions()) {
                    roomOptionsSB.append(index + ") ");
                    roomOptionsSB.append(interaction.getInteractionName());
                    roomOptionsSB.append(" ");
                    roomOptionsSB.append(object.getObjectName());
                    roomOptionsSB.append("\n");
                }
            }
        } catch (RuntimeException e) {
            System.out.println("roomObjects List Error: " + e);
        }
        System.out.println(roomOptionsSB);
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

    public boolean isOption() {
        return this.isOption;
    }
}
