package NebulaGhostTextRPG.Base;

public enum Exits {
    NORTH("[N]orth "),
    EAST("[E]ast "),
    SOUTH("[S]outh "),
    WEST("[W]est ");

    private final String displayName;

    Exits(String displayName) {
       this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

}
