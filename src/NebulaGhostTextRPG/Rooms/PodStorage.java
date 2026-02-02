package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.*;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class PodStorage extends Room {

    public PodStorage(RoomState roomState, Exits... exits){
        super(roomState, exits);
        this.description = StoryRegistry.POD_STORAGE_DESC;
        this.roomName = "Cryo-Pod Storage";
    }
}
