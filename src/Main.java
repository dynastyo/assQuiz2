
import java.util.Random;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();
    static QuizProgress qProgress = new QuizProgress();
    static Question[] questionArray = new Question[5];

    public static void main(String[] args) {
        mainMenu();


    }



    // new comment
    public static void mainMenu() {
        System.out.println("(S)tart oder (Q)uit?");
        String result = sc.next().toUpperCase();
        if (result.equals("S")) {
            qProgress.reset();
            createDefaultQuestions();
            selectQuestion();
        } else if (!result.equals("Q")) {
            System.out.println("nur S oder Q eingeben!");
            mainMenu();
        }
    }

    public static void selectQuestion() {
        int currentQuestion = rnd.nextInt(questionArray.length);
        if (qProgress.getAlreadyAsked().contains(currentQuestion)) selectQuestion();
        qProgress.setQuestionNumber(qProgress.getQuestionNumber() + 1);
        askQuestion(currentQuestion);
    }

    public static void askQuestion(int currentQuestion) {

//        CHOOSE THE QUESTION TO ASK
        System.out.println("Frage Nummer: " + qProgress.getQuestionNumber());
        System.out.println(questionArray[currentQuestion].getQuestion());
        System.out.println("A) " + questionArray[currentQuestion].getAnswerA());
        System.out.println("B) " + questionArray[currentQuestion].getAnswerB());
        System.out.println("C) " + questionArray[currentQuestion].getAnswerC());
        System.out.println("D) " + questionArray[currentQuestion].getAnswerD());
        String userAnswer = sc.next().toUpperCase();
        if (userAnswer.equals(questionArray[currentQuestion].getCorrectAnswer())) {
            System.out.println("Richtig!");
        } else if (!(userAnswer.equals("A") || userAnswer.equals("B") || userAnswer.equals("C") || userAnswer.equals("D"))) {
            System.out.println("nur A,B,C oder D eingeben!");
            askQuestion(currentQuestion);
        } else {
            results();
        }

//        UPDATE qProgress
        qProgress.addAsked(currentQuestion);
        qProgress.setCounterCorrect(qProgress.getCounterCorrect() + 1);
        if (qProgress.getQuestionNumber() < 5) {
            selectQuestion();
        } else results();
    }

    public static void results() {
        System.out.println("------------");
        System.out.println("Spiel beendet");
        System.out.println("Du hast " + qProgress.getCounterCorrect() + " von " + qProgress.getQuestionNumber() + " Fragen richtig beantwortet.");
        System.out.println("------------");
        mainMenu();

    }

    public static void createDefaultQuestions() {
        questionArray[0] = new Question("Was ist Java ebenfalls?", "Eine Insel", "Ein Fluss", "Ein Königreich", "Ein Betriebssystem", "A");
        questionArray[1] = new Question("Der Stack ist ein ...", "... Bereich auf der Festplatte", "... besonders langsamer Speicherbereich", "... Kartenspiel", "... stapelartig organisierter fortlaufender Bereich im RAM", "D");
        questionArray[2] = new Question("Der Heap ist ... ?", "... ist ein besonders schneller Cache", "... ein Speicherbereich, der von der Garbage Collection verwaltet wird und in ihm werden Objekte gespeichert", "... wird vom Betriebssystem verwaltet", "... ist auch nur eine Insel", "B");
        questionArray[3] = new Question("Die Insel Java ist berühmt für ... ?", "Ihre Fischerei", "Ihren Vulkan", "Ihren Kaffee", "Ihre Eishockeymannschaft", "C");
        questionArray[4] = new Question("Welche Zahl ist groesser?", "1", "2", "3", "4", "D");
    }
}
