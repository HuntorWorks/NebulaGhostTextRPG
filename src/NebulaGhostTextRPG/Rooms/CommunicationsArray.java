package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class CommunicationsArray extends Room {
    public CommunicationsArray(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.COMMS_ARRAY_DESC;
        this.roomName = "Communications Array";
    }
}
