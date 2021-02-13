package by.teachmeskills.robot;

import by.teachmeskills.robot.fabric.RandomRobotFabric;
import by.teachmeskills.robot.fabric.SomeFabric;
import by.teachmeskills.robot.fabric.hand.HandsFabric;
import by.teachmeskills.robot.fabric.head.HeadsFabric;
import by.teachmeskills.robot.fabric.leg.LegsFabric;
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


        SomeFabric<IHead> headFabric = new HeadsFabric();
        SomeFabric<IHand> handFabric = new HandsFabric();
        SomeFabric<ILeg> legFabric = new LegsFabric();


        Robot robot1 = new RandomRobotFabric(
                headFabric.buildSomething(),
                handFabric.buildSomething(),
                legFabric.buildSomething()).buildSomething();

        Robot robot2 = new RandomRobotFabric(
                headFabric.buildSomething(),
                handFabric.buildSomething(),
                legFabric.buildSomething()).buildSomething();

        Robot robot3 = new RandomRobotFabric(
                headFabric.buildSomething(),
                handFabric.buildSomething(),
                legFabric.buildSomething()).buildSomething();


        List<Robot> myRobots = Arrays.asList(robot1, robot2, robot3);
        System.out.println(robot1.getMostExpensive(myRobots).getPrice());

        System.out.println(robot1.getPrice());
        System.out.println(robot2.getPrice());
        System.out.println(robot3.getPrice());

    }
}
