package NebulaGhostTextRPG.Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class Room {
    protected String description;
    protected String roomName;
    protected List<Exits> availableExitsList;
    protected List<RoomObject> roomObjects = new ArrayList<>();

    public Room(RoomState roomState, Exits... exits) {
        this.availableExitsList = Arrays.asList(exits);
    }

    public List<Exits> getExits() {
        return availableExitsList;
    }

    public List<RoomObject> getRoomObjects() { return roomObjects; }

    public String getRoomName(){
        return roomName;
    }

    public void loadRoom(){
        System.out.println(this.description);
    }
}
