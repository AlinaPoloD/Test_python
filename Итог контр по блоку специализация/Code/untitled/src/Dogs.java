public class Dogs extends Pets{


    public Dogs(String name, String birthdate) {
        super(name, birthdate);
    }

    @Override
    public void command() {

    }

    @Override
    public String getType() {
        return "Dog";
    }
}
