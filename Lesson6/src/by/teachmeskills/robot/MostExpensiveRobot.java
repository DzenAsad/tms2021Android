package by.teachmeskills.robot;

import java.util.List;

public class MostExpensiveRobot {
    public Robot getMostExpensive(List<Robot> robots){
        Robot mostExpensive = robots.get(0);
        for(Robot next: robots){
            if (mostExpensive.getPrice() < next.getPrice()){
                mostExpensive = next;
            }
        }
        return mostExpensive;
    }
}

