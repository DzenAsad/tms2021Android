package by.teachmeskills.robot.hands;

public class SonyHand implements IHand {
    private int price;

    public SonyHand(int price) {
        this.price = price;
    }

    @Override
    public void upHand() {
        System.out.println("Машет рука Sony");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
