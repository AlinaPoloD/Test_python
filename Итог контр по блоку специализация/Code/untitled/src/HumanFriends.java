import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public abstract class HumanFriends {

    private int id;
    protected String name;
    private static int counter = 0;
    protected String birthdate;

    private static int sumCounter = 0;
      private List<Command> commands;


    public HumanFriends(String name, String birthdate) {
        sumCounter++;
        id = ++counter;
        this.name = name;
        this.birthdate =birthdate;
        this.commands = new ArrayList<>();
        this.commands.add(Command.SLIP);

    }

    public List<Command> getCommands() {
        return commands;
    }

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

   public void addCommand(Command command) {
        commands.add(command);


    }
    public int getBirthYear() {
        return Integer.parseInt(birthdate.substring(0, 4));
    }


    @Override
    public String toString() {
        return "\nЖивотное: " +
                "id=" + id +
                ", Имя='" + name + '\'' +
                ", Дата рождения='" + birthdate + '\'' +
                ", команды=" + commands +
                ", относится к классу=" + getType();
    }
}


