public class Hamsters extends Pets {


    public Hamsters(String name, String birthdate) {
        super(name, birthdate);
    }

    @Override
    public void command() {

    }

    @Override
    public String getType() {
        return "Hamster";
    }
}
