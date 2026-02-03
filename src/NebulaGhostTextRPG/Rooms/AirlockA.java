package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class AirlockA extends Room {

    public AirlockA(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.AIRLOCK_A_DESC;
        this.roomName = "Airlock A";
    }
}
