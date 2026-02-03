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
    private Room podStorage,cargoHold, airlockB, scrapCompactor, security, medicalBay, airlockA, hydroponicsLab, captainsQuarters,reactorCore, o2System, commsArray, observationDeck, bridge;

    public RoomManager() {
        generateRooms();

        setStartingRoom(podStorage);
    }

    public void generateRooms() {
        podStorage = new PodStorage(RoomState.NONE, Exits.NORTH, Exits.EAST);
        cargoHold = new CargoHold(RoomState.NONE, Exits.NORTH, Exits.SOUTH, Exits.WEST);
        airlockB = new AirlockB(RoomState.NONE, Exits.NORTH);
        scrapCompactor = new ScrapCompactor(RoomState.NONE, Exits.EAST, Exits.SOUTH);
        security = new Security(RoomState.NONE, Exits.NORTH, Exits.WEST);
        medicalBay = new MedicalBay(RoomState.DARK, Exits.EAST, Exits.SOUTH, Exits.WEST);
        airlockA = new AirlockA(RoomState.NONE, Exits.EAST);
        hydroponicsLab = new HydroponicsLab(RoomState.NONE, Exits.NORTH, Exits.EAST, Exits.SOUTH, Exits.WEST);
        captainsQuarters = new CaptainsQuarters(RoomState.LOCKED, Exits.SOUTH);
        reactorCore = new ReactorCore(RoomState.NONE, Exits.NORTH, Exits.EAST);
        o2System = new O2System(RoomState.NONE, Exits.WEST);
        commsArray = new CommunicationsArray(RoomState.NONE, Exits.EAST, Exits.WEST);
        observationDeck = new ObservationDeck(RoomState.NONE, Exits.NORTH, Exits.WEST);
        bridge = new Bridge(RoomState.NONE, Exits.SOUTH);

        linkRoom(podStorage, Exits.EAST, cargoHold);
        linkRoom(podStorage, Exits.NORTH, scrapCompactor);

        linkRoom(cargoHold, Exits.NORTH, security);
        linkRoom(cargoHold, Exits.SOUTH, airlockB);
        linkRoom(cargoHold, Exits.WEST, podStorage);

        linkRoom(airlockB, Exits.NORTH, cargoHold);
        linkRoom(airlockA, Exits.EAST, medicalBay);

        linkRoom(scrapCompactor, Exits.SOUTH, podStorage);
        linkRoom(scrapCompactor, Exits.EAST, security);

        linkRoom(security, Exits.NORTH, medicalBay);
        linkRoom(security, Exits.WEST, scrapCompactor);

        linkRoom(medicalBay, Exits.EAST, hydroponicsLab);
        linkRoom(medicalBay, Exits.SOUTH, security);
        linkRoom(medicalBay, Exits.WEST, airlockA);

        linkRoom(hydroponicsLab, Exits.NORTH, captainsQuarters);
        linkRoom(hydroponicsLab, Exits.EAST, commsArray);
        linkRoom(hydroponicsLab, Exits.SOUTH, reactorCore);
        linkRoom(hydroponicsLab, Exits.WEST, medicalBay);

        linkRoom(captainsQuarters, Exits.SOUTH, hydroponicsLab);

        linkRoom(reactorCore, Exits.NORTH, hydroponicsLab);
        linkRoom(reactorCore, Exits.EAST, o2System);

        linkRoom(o2System, Exits.WEST, reactorCore);

        linkRoom(commsArray, Exits.EAST, observationDeck);
        linkRoom(commsArray, Exits.WEST, hydroponicsLab);

        linkRoom(observationDeck, Exits.NORTH, bridge);
        linkRoom(observationDeck, Exits.WEST, commsArray);

        linkRoom(bridge, Exits.SOUTH, observationDeck);
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
