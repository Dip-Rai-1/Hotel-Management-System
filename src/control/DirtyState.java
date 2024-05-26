package entity;

public class DirtyState implements RoomState {
    @Override
    public void handle() {
        System.out.println("The room is dirty.");
    }
}
