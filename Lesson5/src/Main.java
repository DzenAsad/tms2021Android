import com.home.HeavyTransport;
import com.home.LightTransport;

public class Main {
    public static void main(String[] args) {
        LightTransport lightTransport = new LightTransport(100,
                100,
                1500,
                "Audi",
                4,
                10,
                "Sedan",
                4);
        lightTransport.doSomeInfo(2);
        System.out.println(lightTransport);

        HeavyTransport heavyTransport = new HeavyTransport(1000,
                90,
                10000,
                "MAN",
                6,
                50,
                10000);
        heavyTransport.tryLoadCargo(3000);
        heavyTransport.tryLoadCargo(13000);
        System.out.println(heavyTransport);

    }
}
