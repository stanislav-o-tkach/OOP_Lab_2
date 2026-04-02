import java.util.ArrayList;

public class TextProcess {
    private final int targetLength;

    public TextProcess(int targetLength) {
        this.targetLength = targetLength;
    }

    public ArrayList<StringBuffer> uniqueWords(StringBuffer fullText) {
        ArrayList<StringBuffer> result = new ArrayList<>();
        StringBuffer sentenceBuffer = new StringBuffer();

        for (int i = 0; i < fullText.length(); i++) {
            char c = fullText.charAt(i);
            sentenceBuffer.append(c);

            if (isEndOfSentence(c)) {
                Sentence sentence = new Sentence(new StringBuffer(sentenceBuffer));

                if (sentence.isQuestion()) {
                    ArrayList<StringBuffer> words = sentence.getWords();

                    for (StringBuffer word : words) {
                        StringBuffer normalized = normalize(word);

                        if (normalized.length() == targetLength && !contains(result, normalized)) {
                            result.add(normalized);
                        }
                    }
                }
                sentenceBuffer = new StringBuffer();
            }
        }
        return result;
    }

    private boolean isEndOfSentence(char c) {
        return c == '.' || c == '?' || c == '!';
    }

    private StringBuffer normalize(StringBuffer word) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLetter(c) || c == '\'' || c == '’') {
                result.append(Character.toLowerCase(c));
            }
        }
        return result;
    }

    private boolean contains(ArrayList<StringBuffer> list, StringBuffer target) {
        for (StringBuffer item : list) {
            if (equalsBuffer(item, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean equalsBuffer(StringBuffer a, StringBuffer b) {
        if (a.length() != b.length()) {
            return false;
        }


        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}