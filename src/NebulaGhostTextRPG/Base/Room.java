package NebulaGhostTextRPG.Base;

import java.util.Arrays;
import java.util.List;


public abstract class Room {
    protected String description;
    protected String roomName;
    protected List<Exits> availableExitsList;

    public Room(RoomState roomState, Exits... exits) {
        this.availableExitsList = Arrays.asList(exits);
    }

    public List<Exits> getExits() {
        return availableExitsList;
    }

    public String getRoomName(){
        return roomName;
    }

    public void loadRoom(){
        System.out.println(this.description);
    }
}
