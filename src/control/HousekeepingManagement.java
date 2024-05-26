//housekeeping management file 
package control;

import entity.Room;
import entity.CleanState;
import entity.DirtyState;
import entity.OccupiedState;

import java.util.List;
import java.util.stream.Collectors;

public class HousekeepingManagement extends AbstractManagement {
    private static HousekeepingManagement instance;
    private List<Room> rooms;

    private HousekeepingManagement(List<Room> rooms) {
        super("Housekeeping");
        this.rooms = rooms;
    }

    // Singleton pattern: Ensure only one instance of HousekeepingManagement
    public static HousekeepingManagement getInstance(List<Room> rooms) {
        if (instance == null) {
            instance = new HousekeepingManagement(rooms);
        }
        return instance;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is performing housekeeping duties.");
    }

    public List<Room> getCleanAndAvailableRooms() {
        return rooms.stream()
                .filter(room -> room.getState() instanceof CleanState)
                .collect(Collectors.toList());
    }
    
    public void cleanRoom(Room room) {
        room.setState(new CleanState());
        room.applyState();
    }

    public void occupyRoom(Room room) {
        room.setState(new OccupiedState());
        room.applyState();
    }

    public void dirtyRoom(Room room) {
        room.setState(new DirtyState());
        room.applyState();
    }
    
    public void displayRoomStates() {
        rooms.forEach(System.out::println);
    }

    public List<Room> getAvailableRooms() {
        return rooms;
    }

    // Method to display the state of all rooms
//    public void displayRoomStates() {
//        for (Room room : rooms) {
//            System.out.println("Room " + room.getRoomNumber() + " is " + room.getState().getClass().getSimpleName());
//        }
//    }
}
