package by.teachmeskills.robot;

import by.teachmeskills.robot.fabric.RobotFabric;
import by.teachmeskills.robot.fabric.Fabric;
import by.teachmeskills.robot.fabric.hand.RandomHandsFabric;
import by.teachmeskills.robot.fabric.head.RandomHeadsFabric;
import by.teachmeskills.robot.fabric.leg.RandomLegsFabric;
import by.teachmeskills.robot.hands.IHand;
import by.teachmeskills.robot.heads.IHead;
import by.teachmeskills.robot.legs.ILeg;

import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */


        Fabric<IHead> headFabric = new RandomHeadsFabric();
        Fabric<IHand> handFabric = new RandomHandsFabric();
        Fabric<ILeg> legFabric = new RandomLegsFabric();


        Robot robot1 = new RobotFabric(
                headFabric.buildSomething(),
                handFabric.buildSomething(),
                legFabric.buildSomething()).buildSomething();

        Robot robot2 = new RobotFabric(
                headFabric.buildSomething(),
                handFabric.buildSomething(),
                legFabric.buildSomething()).buildSomething();

        Robot robot3 = new RobotFabric(
                headFabric.buildSomething(),
                handFabric.buildSomething(),
                legFabric.buildSomething()).buildSomething();

        MostExpensiveRobot mostExpensiveRobot = new MostExpensiveRobot();
        List<Robot> myRobots = Arrays.asList(robot1, robot2, robot3);
        System.out.println(mostExpensiveRobot.getMostExpensive(myRobots).getPrice());

        System.out.println(robot1.getPrice());
        System.out.println(robot2.getPrice());
        System.out.println(robot3.getPrice());

    }
}
