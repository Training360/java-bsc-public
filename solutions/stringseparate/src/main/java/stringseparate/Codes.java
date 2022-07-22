package stringseparate;

import java.util.List;

public class Codes {

    public String getCodesStartWithLetter(List<String> codes) {
        StringBuilder sb = new StringBuilder("Betűvel kezdődő kódok: ");
        for (int i = 0; i < codes.size(); i++) {
            char first = codes.get(i).charAt(0);
            if (Character.isAlphabetic(first) && i < codes.size() - 1) {
                sb.append(codes.get(i));
                sb.append(", ");
            } else if (Character.isAlphabetic(first) && i == codes.size() - 1) {
                sb.append(codes.get(i));
            }
        }
        return sb.toString();
    }
}
