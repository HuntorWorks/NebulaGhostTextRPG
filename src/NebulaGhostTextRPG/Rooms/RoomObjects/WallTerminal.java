package NebulaGhostTextRPG.Rooms.RoomObjects;

import NebulaGhostTextRPG.Base.InteractionType;
import NebulaGhostTextRPG.Base.RoomObject;

public class WallTerminal extends RoomObject {
    public WallTerminal(String objectName, String objDescription, InteractionType... availableInteractions) {
        super(objectName, objDescription, availableInteractions);
    }

    @Override
    public void handleInteraction(InteractionType interactionType) {
        switch (interactionType) {
            case HACK: {
                if (!this.hasInvestigated()) {
                    return;
                }
                System.out.println("You Hacked The Terminal");
            }
            case INVESTIGATE: {
                System.out.println("You investigated the Terminal.");
            }
            default:
                super.handleInteraction(interactionType);
        }
    }
}
