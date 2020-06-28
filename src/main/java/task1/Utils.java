package task1;

import java.text.Normalizer;
import java.util.stream.IntStream;

public class Utils {

    public String concatenateWords(String beginning, String ending) {
        return beginning.concat(ending);
    }

    public int computeFactorial(int inputNumber) {
        if (inputNumber < 0){
            throw new IllegalArgumentException("Use only positive numbers for factorial calculation.");
        }
        return IntStream.rangeClosed(1, inputNumber)
                .reduce(1, (int x, int y) -> x * y);
    }

    public String normalizeWord(String word) {
        return Normalizer.normalize(word,Normalizer.Form.NFKD);
    }

}
