public class Horses extends PackAnimals{

    public Horses(String name, String birthdate) {
        super(name, birthdate);
    }

    @Override
    public void command() {

    }

    @Override
    public String getType() {
        return "Horse";
    }
}
