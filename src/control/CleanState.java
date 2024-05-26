//cleanstate code
//comment added

package entity;

public class CleanState implements RoomState {
    @Override
    public void handle() {
        System.out.println("The room is clean.");
    }
}
