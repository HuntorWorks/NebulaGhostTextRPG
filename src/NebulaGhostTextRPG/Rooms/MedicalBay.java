package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class MedicalBay extends Room {
    public MedicalBay(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.MEDICAL_BAY_DESC;
        this.roomName = "Medical Bay";
    }
}
