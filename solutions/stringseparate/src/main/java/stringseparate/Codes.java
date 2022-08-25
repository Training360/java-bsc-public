package stringseparate;

import java.util.ArrayList;
import java.util.List;

public class Codes {

    public String getCodesStartWithLetter(List<String> codes) {
        List<String> codesStartWithLetter = filterCodesStartsWithLetter(codes);
        StringBuilder sb = new StringBuilder("Betűvel kezdődő kódok: ");
        for (int i = 0; i < codesStartWithLetter.size(); i++) {
            String code = codesStartWithLetter.get(i);
            char first = code.charAt(0);
            if (i < codesStartWithLetter.size() - 1) {
                sb.append(code);
                sb.append(", ");
            } else {
                sb.append(code);
            }
        }
        return sb.toString();
    }

    private List<String> filterCodesStartsWithLetter(List<String> codes) {
        List<String> codesStartWithLetter = new ArrayList<>();
        for (String code : codes) {
            char first = code.charAt(0);
            if (Character.isAlphabetic(first)) {
                codesStartWithLetter.add(code);
            }
        }
        return codesStartWithLetter;
    }
}
