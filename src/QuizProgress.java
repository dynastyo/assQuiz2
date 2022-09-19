import java.util.ArrayList;

public class QuizProgress {
    private int questionNumber, counterCorrect;
    private ArrayList<Integer> alreadyAsked = new ArrayList<>();

    public QuizProgress() {
    }

    public QuizProgress(int questionNumber, int counterCorrect, ArrayList<Integer> alreadyAsked) {
        this.questionNumber = questionNumber;
        this.counterCorrect = counterCorrect;
        this.alreadyAsked = alreadyAsked;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public int getCounterCorrect() {
        return counterCorrect;
    }

    public void setCounterCorrect(int counterCorrect) {
        this.counterCorrect = counterCorrect;
    }

    public ArrayList<Integer> getAlreadyAsked() {
        return alreadyAsked;
    }

    public void setAlreadyAsked(ArrayList<Integer> alreadyAsked) {
        this.alreadyAsked = alreadyAsked;
    }

    public void addAsked(int currentQuestion) {
        alreadyAsked.add(currentQuestion);
    }

    public void reset() {
        questionNumber = 0;
        counterCorrect = 0;
        alreadyAsked.clear();
    }
}
