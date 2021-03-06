package by.teachmeskills.robot.fabric;

import by.teachmeskills.robot.Robot;
import by.teachmeskills.robot.hands.IHand;
import by.teachmeskills.robot.heads.IHead;
import by.teachmeskills.robot.legs.ILeg;


public class RobotFabric implements Fabric<Robot> {
    private IHead head;
    private IHand hand;
    private ILeg leg;

    public RobotFabric(IHead heads, IHand hands, ILeg legs) {
        this.head = heads;
        this.hand = hands;
        this.leg = legs;
    }

    @Override
    public Robot buildSomething() {
        return new Robot(head, hand, leg);
    }

}
