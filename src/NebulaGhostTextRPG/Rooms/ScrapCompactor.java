package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class ScrapCompactor extends Room {

    public ScrapCompactor (RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.SCRAP_COMPACTOR_DESC;
        this.roomName = "Scrap Compactor";
    }
}
