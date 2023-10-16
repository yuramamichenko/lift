import java.util.Random;

public class Human {

    private int previousFloor, goalFloor, id;

    private Building building;

    private String personalDirection, name;

    public Human(Building building, int currentFloor) {
        this.previousFloor = currentFloor;
        this.building = building;
        this.goalFloor = getRandomFloor();
        personalDirection = goalFloor > currentFloor ? "up" : "down";
    }

    public int getRandomFloor() {
        Random random = new Random();
        int randomFloor = random.nextInt(1, building.getFloorsQuantity());
        if (randomFloor == previousFloor) {
            if (previousFloor == 1) {
                return randomFloor + 1;
            } else if (previousFloor == building.getFloorList().size()) {
                return randomFloor - 1;
            } else return randomFloor + 1;
        }
        return randomFloor;
    }

    public void setIdAndName(int id) {
        this.id = id;
        name = previousFloor + "." + id;
    }

    public void setPreviousFloor(int previousFloor) {
        this.previousFloor = previousFloor;
        goalFloor = getRandomFloor();
        personalDirection = goalFloor > previousFloor ? "up" : "down";
    }

    public String getDirection() {
        return personalDirection;
    }

    public int getGoalFloor() {
        return goalFloor;
    }

    @Override
    public String toString() {
        return "Пользователь " + name +
                " (" + previousFloor +
                " >>> " + goalFloor + ") | ";
    }
}
