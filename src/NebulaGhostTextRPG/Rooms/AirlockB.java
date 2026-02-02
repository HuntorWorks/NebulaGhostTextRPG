package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class AirlockB extends Room {

    public AirlockB(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.AIRLOCK_B_DESC;
        this.roomName = "Airlock B";
    }
}
