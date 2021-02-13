package by.teachmeskills.robot.fabric.head;

import by.teachmeskills.robot.fabric.SomeFabric;
import by.teachmeskills.robot.heads.*;

import java.util.Random;

public class HeadsFabric implements SomeFabric<IHead> {

    @Override
    public IHead buildSomething() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return new SamsungHead(random.nextInt(101));
            case 1:
                return new SonyHead(random.nextInt(101));
            case 2:
                return new ToshibaHead(random.nextInt(101));
        }
        return null;
    }
}
