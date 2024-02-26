
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ToyMachine{

    private ArrayList<Toys> toys;
    private LinkedList<Toys> prizeToys;

    public ToyMachine() {
        toys = new ArrayList<>();
        prizeToys = new LinkedList<>();

    }


    public void add(Toys e){

        toys.add(e);

    }

    public void changeFrequency(Toys a, double newFrequency) {
        for (Toys toy :toys) {
            if (toy.equals(a)) {
                toy.setFrequency(newFrequency);
        }
        }

    }

    public void getPrize(){
        // Удаляем значения поочередно и записываем их в файл
        try (FileWriter fileWriter = new FileWriter("prize_toys.txt", true)) {
            if (!prizeToys.isEmpty()) {
                Toys prizeToy = prizeToys.pollFirst();
                fileWriter.write("Вы выиграли игрушку - "+ prizeToy.getName() + "\n" );
            }
            else System.out.println("Вы еще не участвовали в розыгрыше, либо он завершен");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private double [] getArrFrequency(){
        double [] fr = new double[toys.size()];
        double sum = 0;
        for (int i = 0; i < toys.size(); i++) {
            fr[i] = toys.get(i).getFrequency() + sum;
            sum = fr[i];
        }
        return fr;


    }



    public void playToGame(){
        if (!toys.isEmpty()) {
            Random random = new Random();
            double [] fr = getArrFrequency();
        double a = random.nextDouble() * fr[fr.length - 1];
        Toys prizeToy = null;
            for (int j =0; j < fr.length;j++){
                if (a < fr[j]) {
                    prizeToy = toys.get(j);
                    break;

                }

            }
        if (prizeToy != null && prizeToy.getQuantity() > 1) {
            prizeToys.add(prizeToy);
            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
        else if (prizeToy != null && prizeToy.getQuantity() == 1) {
            prizeToys.add(prizeToy);
            toys.remove(prizeToy);
        }
        }
        else {
            System.out.println("Автомат пуст, розыгрыш завершен.");
        }
    }




    @Override
    public String toString() {
        return "ToyMachine{" +
                ", toys=" + toys +
                '}';
    }
}
