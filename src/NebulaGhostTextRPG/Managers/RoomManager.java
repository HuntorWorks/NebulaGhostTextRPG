package NebulaGhostTextRPG.Managers;

import NebulaGhostTextRPG.Base.Room;
import NebulaGhostTextRPG.Base.Exits;
import NebulaGhostTextRPG.Base.RoomState;
import NebulaGhostTextRPG.Rooms.*;

import java.util.HashMap;

public class RoomManager {

    private Room currentActiveRoom;
    private HashMap<Room, HashMap<Exits, Room>> masterMap = new HashMap<>();

    //ROOMS
    private Room podStorage,cargoHold, airlockB, scrapCompactor, security;
//    private Room cargoHold;
//    private Room airlockB;
//    private Room scrapCompactor;

    public RoomManager() {
        generateRooms();

        setStartingRoom(podStorage);
    }

    public void generateRooms() {
        podStorage = new PodStorage(RoomState.NONE, Exits.NORTH, Exits.EAST);
        cargoHold = new CargoHold(RoomState.NONE, Exits.NORTH, Exits.EAST, Exits.WEST);
        airlockB = new AirlockB(RoomState.NONE, Exits.NORTH);
        scrapCompactor = new ScrapCompactor(RoomState.NONE, Exits.EAST, Exits.SOUTH);
        security = new Security(RoomState.NONE, Exits.SOUTH, Exits.WEST, Exits.NORTH);

        linkRoom(podStorage, Exits.EAST, cargoHold);
        linkRoom(podStorage, Exits.NORTH, scrapCompactor);
        linkRoom(cargoHold, Exits.NORTH, security);
        linkRoom(cargoHold, Exits.SOUTH, airlockB);
        linkRoom(cargoHold, Exits.WEST, podStorage);
    }

    private void linkRoom(Room currentRoom, Exits exit, Room room) {
        if (masterMap.get(currentRoom) == null) {
            //doesn't exist
            HashMap<Exits, Room> tempExits = new HashMap<>();
            tempExits.put(exit, room);
            masterMap.put(currentRoom, tempExits);
        } else {
            // Does exist..
            masterMap.get(currentRoom).put(exit, room);
        }
    }

    private void setStartingRoom(Room startingRoom) {
        this.currentActiveRoom = startingRoom;
    }

    public void loadRoom(Room roomToLoad) {
        roomToLoad.loadRoom();
    }

    public Room getCurrentActiveRoom() {
        return currentActiveRoom;
    }

    public void navigateToRoom(Room fromRoom, Exits direction) {
        try {
            Room nextRoom = masterMap.get(fromRoom).get(direction);
            nextRoom.loadRoom();
            this.currentActiveRoom = nextRoom;
        } catch (Exception e) {
            System.out.println("[ERROR]: " + fromRoom.getRoomName() + " not linked!");
        }
    }

    private boolean isValidNavigation(Exits exit, Room room) {
        return room.getExits().contains(exit) ? true : false;
    }

}
