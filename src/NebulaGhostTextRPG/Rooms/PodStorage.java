package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.*;
import NebulaGhostTextRPG.Data.StoryRegistry;
import NebulaGhostTextRPG.Rooms.RoomObjects.WallTerminal;

public class PodStorage extends Room {

    public PodStorage(RoomState roomState, Exits... exits){
        super(roomState, exits);
        this.description = StoryRegistry.POD_STORAGE_DESC;
        this.roomName = "Cryo-Pod Storage";
        generateRoomObjects();
    }

    private void generateRoomObjects() {
        RoomObject wallTerminal = new WallTerminal(
                "Wall Terminal",
                "{TEMP DESC}",
                InteractionType.INVESTIGATE,
                InteractionType.HACK
        );
        this.roomObjects.add(wallTerminal);
    }

}
