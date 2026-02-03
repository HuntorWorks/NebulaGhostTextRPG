package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class O2System extends Room {
    public O2System(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.O2_SYSTEMS_DESC;
        this.roomName = "O2 System";
    }
}
