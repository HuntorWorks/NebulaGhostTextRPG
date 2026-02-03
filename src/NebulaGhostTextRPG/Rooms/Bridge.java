package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class Bridge extends Room {
    public Bridge(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.BRIDGE_DESC;
        this.roomName = "Bridge";
    }
}
