package by.teachmeskills.robot.fabric.hand;

import by.teachmeskills.robot.fabric.Fabric;
import by.teachmeskills.robot.hands.*;

import java.util.Random;

public class RandomHandsFabric implements Fabric<IHand> {
    @Override
    public IHand buildSomething() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return new SamsungHand(random.nextInt(101));
            case 1:
                return new SonyHand(random.nextInt(101));
            case 2:
                return new ToshibaHand(random.nextInt(101));
        }
        return null;
    }
}
