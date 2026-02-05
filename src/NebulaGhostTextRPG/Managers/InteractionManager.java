package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.InteractionType;
import NebulaGhostTextRPG.Base.RoomObject;

public class InteractionManager {

    public InteractionManager() {
        
    }

    public void interact(RoomObject interactedObject, InteractionType interactionType) {
        interactedObject.handleInteraction(interactionType);
    }
}
