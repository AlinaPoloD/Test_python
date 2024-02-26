
//Стараемся применять ООП и работу с файлами.
//Если какой-то пункт не изучали и не знаете, как сделать, то можете
//сделать своим способом. Например, у кого в курсе не было ООП, то
//применяем списки\массивы\словари
//Желательный функционал программы:
//● Возможность организовать розыгрыш игрушек.

//С помощью метода выбора призовой игрушки – мы получаем
//эту призовую игрушку и записываем в список\массив.
//Это список призовых игрушек, которые ожидают выдачи.
//Еще у нас должен быть метод – получения призовой игрушки.
//После его вызова – мы удаляем из списка\массива первую
//игрушку и сдвигаем массив. А эту игрушку записываем в
//текстовый файл.
//Не забываем уменьшить количество игрушек
public class Main {
    public static void main(String[] args) {



       Toys doll = new Toys("Кукла",2, 0.2);
        Toys bear = new Toys("Медведь",3, 0.5);
        Toys ball = new Toys("Мяч",5, 0.8);

        ToyMachine toyMachine = new ToyMachine();
        toyMachine.add(doll);
        toyMachine.add(ball);
        toyMachine.add(bear);
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.changeFrequency(doll, 0.9);
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.playToGame();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();
     toyMachine.getPrize();




        }
    }