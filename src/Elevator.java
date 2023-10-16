import java.util.ArrayList;
import java.util.List;

public class Elevator implements Runnable {

    private Building building;

    private int maxCapacity, passFloorsTillStop;

    private String direction = "up";

    private List<Human> humanList = new ArrayList<>();

    public Elevator(Building building, int maxCapacity, int passFloorsTillStop) {
        this.building = building;
        this.maxCapacity = maxCapacity;
        this.passFloorsTillStop = passFloorsTillStop;
    }

    @Override
    public void run() {
        int i = 1;
        int count = 0;
        int peopleTransported = 0;
        while (true) {

            if (i == building.getFloorList().size()) {
                direction = "down";
            }
            if (i == 1) {
                direction = "up";
            }

            if (++count == passFloorsTillStop) {
                System.out.println("Лифт проехал " + passFloorsTillStop + " этажей и перевёз " + peopleTransported + " пользователей");
                return;
            }

            System.out.println(String.valueOf(i) + " этаж");

            List<Human> onFloor = building.getFloorList().get(i).getHumanOnFloorList();

            List<Human> stopList = new ArrayList<>();

            if (humanList.size() > 0) {
                for (Human human : new ArrayList<>(humanList)) {
                    if (human.getGoalFloor() == i) {
                        System.out.println(human + " покинул Лифт");

                        peopleTransported++;
                        humanList.remove(human);
                        human.setPreviousFloor(i);
                        onFloor.add(onFloor.size(), human);
                        stopList.add(human);
                    }
                }
            }


            for (Human human : new ArrayList<>(onFloor)) {
                if (human.getDirection().equals(direction)) {
                    if (humanList.size() < maxCapacity) {

                        if (!stopList.contains(human)) {
                            humanList.add(human);
                            System.out.println(human + " зашел в Лифт");
                            onFloor.remove(human);
                        }
                    }
                }
            }
            System.out.println("Лифт загружен на " + humanList.size() + " / " + maxCapacity);
            System.out.println();

            if (direction.equals("up")) {
                i++;
            } else {
                i--;
            }
        }
    }
}
