package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class ReactorCore extends Room {
    public ReactorCore(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.REACTOR_CORE_DESC;
        this.roomName = "Reactor Core";
    }
}
