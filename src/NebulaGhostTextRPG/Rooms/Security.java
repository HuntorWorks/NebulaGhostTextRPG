package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class Security extends Room {
    public Security(RoomState roomState, Exits... exit) {
        super(roomState, exit);
        this.description = StoryRegistry.SECURITY_DESC;
        this.roomName = "Security";
    }
}
