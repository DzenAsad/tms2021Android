
import java.util.Map;
import java.util.TreeMap;

public class Lesson9 {
    public static void main(String[] args) {

    }


    private void countWords(String string){
        String[] formattedData = string.split("\\W+");
        Map<String, Integer> tmp = new TreeMap<>();
        for (String str: formattedData){
            tmp.put(str, tmp.get(str) + 1);
        }
    }
}
