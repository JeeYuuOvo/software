package func2;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("images and other files/input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("images and other files/output.txt");

    }
}
