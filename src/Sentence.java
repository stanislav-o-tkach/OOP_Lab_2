import java.util.ArrayList;

public class Sentence {
    private final StringBuffer text;

    public Sentence(StringBuffer text) {
        this.text = text;
    }

    public boolean isQuestion() {
        for (int i = text.length() - 1; i >= 0; i--) {
            char c = text.charAt(i);
            if (!Character.isWhitespace(text.charAt(i))) {
                return c == '?';
            }
        }
        return false;
    }

    public ArrayList<StringBuffer> getWords() {
        ArrayList<StringBuffer> words = new ArrayList<>();
        StringBuffer current = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c) || c == '\'' || c == '’') {
                current.append(c);
            } else {
                if (!current.isEmpty()) {
                    words.add(new StringBuffer(current));
                    current = new StringBuffer();
                }
            }
        }

        if (!current.isEmpty()) {
            words.add(current);
        }

        return words;
    }
}