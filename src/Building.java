import java.util.HashMap;
import java.util.Map;

public class Building {
    public static void main(String[] args) {
        Building building = new Building(9, 3);
        new Thread(new Elevator(building, 2, 1000)).start();
    }

    private int floorsQuantity;
    private Map<Integer, Floor> floorList = new HashMap<>();

    public Building(int floorsQuantity, int maxHumanOnFloor) {
        this.floorsQuantity = floorsQuantity;
        for (int i = 1; i <= floorsQuantity; i++) {
            floorList.put(i, new Floor(this, i, maxHumanOnFloor));
        }
        System.out.println(floorsQuantity + "-floorBuilding created.");
    }

    public Map<Integer, Floor> getFloorList() {
        return floorList;
    }

    public int getFloorsQuantity() {
        return floorsQuantity;
    }
}
