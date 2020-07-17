package coregamefiles;

public class CurrentRoom {

    //field instantiates room
    private String currentRoom;

    //CTOR
    public CurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String currentRoom) {
        this.currentRoom = currentRoom;
    }
}
