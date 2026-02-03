package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class CaptainsQuarters extends Room {
    public CaptainsQuarters(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.CAPTAINS_QUATERS_DESC;
        this.roomName = "Captains Quarters";
    }
}
