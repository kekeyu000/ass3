package ass3.mygame2;


import java.util.ArrayList;

public class RoomCreation {

    private ArrayList<Room> allRoomInGame = new ArrayList();

    private ItemCreation itemCreation;

    public RoomCreation() {
        itemCreation = new ItemCreation();
        createRooms();
    }
    
    
    private void createRooms() {

        Room castle, kitchen, frontGate;

        castle = new Room("castle", "You are at the castle", false);
        kitchen = new Room("kitchen", "The kitchen door has a shape of a heart", false);
        frontGate = new Room("frontGate", "There is a giant ogre", true);
        

        castle.setExit("east", kitchen);
        castle.setExit("south", frontGate);
        frontGate.setExit("north", castle);
        frontGate.setExit("east-north",kitchen);// add exit from frontGate to kitchen.
        kitchen.setExit("west", castle);// add exit from kitchen to castle.
        kitchen.setExit("west-south",frontGate);// add exit from kitchen to frontGate
        
        
        castle.addItemInRoom(itemCreation.getItem("excaliburSword"));
        castle.addItemInRoom(itemCreation.getItem("key"));
        kitchen.addItemInRoom(itemCreation.getItem("frontGateKey"));
        kitchen.addItemInRoom(itemCreation.getItem("item2"));//add item2 in kitchen
        frontGate.addItemInRoom(itemCreation.getItem("item1"));// add item1 in frontGate

        allRoomInGame.add(castle);
        allRoomInGame.add(frontGate);
        allRoomInGame.add(kitchen);

    }

    public Room getRoom(String stringRoom) {
        Room roomToReturn = null;
        for (Room room : allRoomInGame) {
            if (room.getName().contains(stringRoom)) {
                roomToReturn = room;
            }
        }
        return roomToReturn;
    }

}
