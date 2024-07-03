public abstract class PackAnimals extends HumanFriends {
    private static int sumCounter = 0;


    public PackAnimals(String name, String birthdate) {
        super(name, birthdate);
        sumCounter++;
    }

    public static int getSumCounter() {
        return sumCounter;
    }

}
