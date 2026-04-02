import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TestProject {

    @Test
    public void sentenceIsQuestion() {
        StringBuffer text1 = new StringBuffer();
        StringBuffer text2 = new StringBuffer();

        text1.append("    Як  Справи?  ");
        text2.append("  Немає поля, то буде воля. ");

        Sentence sentence1 = new Sentence(text1);
        Sentence sentence2 = new Sentence(text2);

        assertTrue(sentence1.isQuestion(), "Перевірку на знаходження питального речення провалено!!!");
        assertFalse(sentence2.isQuestion(), "Перевірку на знаходження питального речення провалено!!!");
    }

    @Test
    public void getWordsCorrectness() {
        StringBuffer text = new StringBuffer();

        text.append("  Минуле, ! озвися.., де тиЇ?");

        Sentence sentence = new Sentence(text);

        String resultArray = "[Минуле, озвися, де, тиЇ]";


        assertEquals(resultArray, sentence.getWords().toString(), "Перевірку на отримання слів з тексту провалено!!!");
    }

    @Test
    public void uniqueWordCorrectness() {
        StringBuffer text = new StringBuffer("Ви знаєте, як липа шелестить липа? У місячні ночі! Вони все бачать крізь тумани?");
        TextProcess process = new TextProcess(4);

        ArrayList<StringBuffer> actual = process.uniqueWords(text);

        assertEquals(2, actual.size(), "Перевірку на знаходження унікальних слів провалено");
    }
}