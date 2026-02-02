package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class CargoHold extends Room {
    public CargoHold(RoomState roomState, Exits... exits){
        super(roomState, exits);
        this.description = StoryRegistry.CARGO_HOLD_DESC;
        this.roomName = "Cargo Hold";
    }

    @Override
    public void loadRoom() {
        super.loadRoom();
    }
}
