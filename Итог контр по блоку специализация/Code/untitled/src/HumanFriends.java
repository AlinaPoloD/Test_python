import java.util.Date;
import java.util.List;

public abstract class HumanFriends {

    private int id;
    protected String name;
    private static int counter = 0;
    protected String birthdate;

    private static int sumCounter = 0;
    private List<String> commands;


    public HumanFriends(String name, String birthdate) {
        sumCounter++;
        id = ++counter;
        this.name = name;
        this.birthdate =birthdate;
        this.commands.add("спать");

    }

    public abstract void command();


    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public String getBirthdate() {
        return birthdate;
    }
    public abstract String getType();

    public static int getSumCounter() {
        return sumCounter;
    }

    public void setCommands(String command) {
        commands.add(command);
    }
}


