package stringseparate;

import java.util.Arrays;
import java.util.List;

public class IceCream {

    public static void main(String[] args) {
        List<String> iceCreams = Arrays.asList("csoki", "vanília", "eper", "citrom", "puncs");
        StringBuilder sb = new StringBuilder("Ma kapható: ");
        for (int i = 0; i < iceCreams.size(); i++) {
            sb.append(iceCreams.get(i));
            if (i < iceCreams.size() - 1) {
                sb.append(", ");
            } else {
                sb.append(". Gyerekeknek féláron!");
            }
        }
        System.out.println(sb);
    }
}
