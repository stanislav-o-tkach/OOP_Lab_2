import java.util.ArrayList;

void main() {
    Scanner console = new Scanner(System.in);

    TaskCalculation variant = new TaskCalculation();
    variant.getVariant();

    System.out.println("Перевірка тестів:");
    TestProject test = new TestProject();
    test.uniqueWordCorrectness();
    test.sentenceIsQuestion();
    test.getWordsCorrectness();
    System.out.println("Тестування пройшло успішно!\n");

    System.out.println("Введіть текст:");
    String text = console.nextLine();

    StringBuffer textConsole = new StringBuffer(text);

    System.out.println("Введіть довжину слів які потрібно відшукати у питальних реченнях:");

    int lengthToFind = console.nextInt();

    System.out.println("---");

    TextProcess processor = new TextProcess(lengthToFind);

    ArrayList<StringBuffer> finalWords = processor.uniqueWords(textConsole);

    if (finalWords.isEmpty()) {
        System.out.println("Слів, що відповідають критеріям, не знайдено.");
    } else {
        System.out.println("Знайдені слова:");
        for (int i = 0; i < finalWords.size(); i++) {
            System.out.println((i + 1) + ". " + finalWords.get(i));
        }
    }
}