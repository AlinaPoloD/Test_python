public abstract class Pets extends HumanFriends{
    public Pets(String name, String birthdate) {
        super(name, birthdate);
        sumCounter++;
    }
    private static int sumCounter = 0;
    public static int getSumCounter() {
        return sumCounter;
    }



}
