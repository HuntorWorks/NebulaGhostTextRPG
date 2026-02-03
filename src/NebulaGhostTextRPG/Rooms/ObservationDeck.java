package NebulaGhostTextRPG.Rooms;

import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Data.StoryRegistry;

public class ObservationDeck extends Room {
    public ObservationDeck(RoomState roomState, Exits... exits) {
        super(roomState, exits);
        this.description = StoryRegistry.OBSERVATION_DECK_DESC;
        this.roomName = "Observation Deck";
    }
}
