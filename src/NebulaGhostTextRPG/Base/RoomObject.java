package NebulaGhostTextRPG.Base;

import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;
import java.util.List;

public class RoomObject {
    private String objectName;
    private String objDescription;
    private List<InteractionType> availableInteractions;
    private List<InteractionType> visibleInteractions;
    private boolean hasInteracted;
    private boolean hasInvestigated;

    public RoomObject(String objectName, String objDescription, InteractionType... availableInteractions) {
        this.objectName = objectName;
        this.objDescription = objDescription;
        this.availableInteractions = Arrays.asList(availableInteractions);
        this.hasInteracted = false;
        this.hasInvestigated = false;

    }


    public boolean hasInteracted() {
        return this.hasInteracted;
    }
    public boolean hasInvestigated() { return this.hasInvestigated; }
    public void setHasInteracted(boolean hasInteracted) {
        this.hasInteracted = hasInteracted;
    }

    public String getObjectName() {
        return objectName;
    }
    public String getObjDescription() {
        return objDescription;
    }

    public List<InteractionType> getAvailableInteractions() {
        return availableInteractions;
    }

    public List<InteractionType> getVisibleInteractions() {
        if (!hasInvestigated) {
            return List.of(InteractionType.INVESTIGATE);
        }
        if (this.availableInteractions.contains(InteractionType.INVESTIGATE)) {
            this.availableInteractions.remove(InteractionType.INVESTIGATE);
        }
        return this.availableInteractions;
    }

    public void handleInteraction(InteractionType interactionType) {
        System.out.println("You cannot" + interactionType.getInteractionName() + " " + this.getObjectName());
    }



}
