package NebulaGhostTextRPG.Base;

public enum InteractionType {
    SEARCH(" [SEARCH] "),
    INVESTIGATE(" [INVESTIGATE] "),
    SALVAGE(" [SALVAGE] "),
    HACK(" [HACK] "),
    REPAIR (" [REPAIR] "),
    LEAVE (" [LEAVE] "),
    CRAFT (" [CRAFT] "),
    INVENTORY_ACTION (" [INVENTORY_ACTION] "),
    SKILLS (" [SKILLS] "),
    QUEST_LIST (" [QUEST_LIST] ");

    private final String interactionName;

    InteractionType(String interactionName){ this.interactionName = interactionName; }
    public String getInteractionName() {
        return this.interactionName;
    }
}
