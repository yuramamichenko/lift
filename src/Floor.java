import java.util.ArrayList;
import java.util.List;

public class Floor {

    private int floorNumber;
    private List<Human> humanOnFloorList = new ArrayList<>();

    public Floor(Building building, int floorNumber, int maxHumanOnFloor) {
        this.floorNumber = floorNumber;
        int index = 0;
        for (int i = 0; i < (Math.random() * maxHumanOnFloor); i++) {
            Human human = new Human(building, floorNumber);
            human.setIdAndName(++index);
            humanOnFloorList.add(human);
        }
    }

    public List<Human> getHumanOnFloorList() {
        return humanOnFloorList;
    }
}
