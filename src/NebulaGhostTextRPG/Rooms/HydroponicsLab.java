package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class HydroponicsLab extends Room {
    public HydroponicsLab(RoomState roomState, Exits... exits) {

        super(roomState, exits);
        this.description = StoryRegistry.HYRDOPONICS_LAB_DESC;
        this.roomName = "Hydroponics Lab";
    }
}
