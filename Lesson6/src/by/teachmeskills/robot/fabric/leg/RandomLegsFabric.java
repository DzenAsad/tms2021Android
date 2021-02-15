package by.teachmeskills.robot.fabric.leg;

import by.teachmeskills.robot.fabric.Fabric;
import by.teachmeskills.robot.legs.*;

import java.util.Random;

public class RandomLegsFabric implements Fabric<ILeg> {
    @Override
    public ILeg buildSomething() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                return new SamsungLeg(random.nextInt(101));
            case 1:
                return new SonyLeg(random.nextInt(101));
            case 2:
                return new ToshibaLeg(random.nextInt(101));
        }
        return null;
    }
}
