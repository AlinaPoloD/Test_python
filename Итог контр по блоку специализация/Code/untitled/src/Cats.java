public class Cats extends Pets{


    public Cats(String name, String birthdate) {
        super(name, birthdate);
    }



    @Override
    public String getType() {
        return "Cat";
    }
}
