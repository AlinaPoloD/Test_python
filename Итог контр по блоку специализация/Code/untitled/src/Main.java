import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Main {
    private static List<HumanFriends> animals = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = checkNumber(scanner);
            switch (choice) {
                case 1:
                    menuChoiseAnimals();
                    int animalChoise = checkNumber(scanner);

                    if (animalChoise >=1 && animalChoise <=6){
                    addAnimal(animalChoise);
                    }
                    break;
                case 2:
                    showAnimalCommands();
                    break;
                case 3:
                    trainAnimal();
                    break;

                case 4:
                    listAnimalsByBirth();


                    break;
                case 5:
                   System.out.println("Всего животных: " + HumanFriends.getSumCounter());

                    break;
                case 6:
                    System.out.println("Всего вьючных животных: " + PackAnimals.getSumCounter());

                    break;
                case 7:
                    System.out.println("Всего домашних животных: " + Pets.getSumCounter());

                    break;
                case 8:
                        System.out.println(animals.toString());

                    break;
                case 9:
                    System.out.println("Вы вышли из меню");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }




    }

    private static void showMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить новое животное");
        System.out.println("2. Вывести команды которые может делать животное");
        System.out.println("3. Обучить животное новой команде");
        System.out.println("4. Вывести список животных по дате рождения");
        System.out.println("5. Вывести общее количество всех животных");
        System.out.println("6. Вывести общее количество вьючных животных");
        System.out.println("7. Вывести общее количество домашних животных");
        System.out.println("8. Вывести список животных");
        System.out.println("9. Выход");
    }
    private static void addAnimal(int numAnimal){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date (yyyy-mm-dd): ");
        String birthDate = scanner.nextLine();
        while (!isValidDate(birthDate)) {
            System.out.print("Неверный формат даты, введите дату в формате: yyyy-MM-dd: ");
            birthDate = scanner.nextLine();
        }

        switch (numAnimal) {
            case 1:
                animals.add(new Cats(name, birthDate));
                break;
            case 2:
                animals.add(new Dogs(name, birthDate));
                break;
            case 3:
                animals.add(new Hamsters(name, birthDate));
                break;
            case 4:
                animals.add(new Camels(name, birthDate));
                break;
            case 5:
                animals.add(new Donkeys(name, birthDate));
                break;
            case 6:
                animals.add(new Horses(name, birthDate));
                break;
        }
    }

    private static void menuChoiseAnimals() {
        System.out.println("Какое животное вы хотите выбрать, наберите цифру которая соответствует животному:");
        System.out.println("1. Кот");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
        System.out.println("4. Верблюд");
        System.out.println("5. Осел");
        System.out.println("6. Лошадь");
        System.out.println("Любая другая. Я ошибся, не хочу добавлять животное");

    }

    private static void showAnimalCommands () {
        System.out.println("Введите id животного, команды которого вы хотите увидеть: ");
        Scanner scanner = new Scanner(System.in);
        int id = checkNumber(scanner);
        HumanFriends animal = findAnimalById(id);
            if (animal != null) {
                System.out.println("Животное " + animal.getName() + " (" + animal.getType() + ") умеет выполнять команды: " + animal.getCommands());
            } else {
                System.out.println("Животное с таким id не найдено");
            }

    }

    private static HumanFriends findAnimalById(int id) {
        for (HumanFriends animal : animals) {
            if (animal.getId() == id) {
                return animal;
            }
        }
        return null;
    }

    private static void trainAnimal() {

        System.out.println("Введите id животного, которого вы хотите научить: ");
        Scanner scanner = new Scanner(System.in);
        int id = checkNumber(scanner);
        HumanFriends animal = findAnimalById(id);
        if (animal != null) {
            menuCommand();
            int command = checkNumber(scanner);
            switch (command) {

                case 1:

                    animal.addCommand(Command.go);
                    break;
                case 2:
                    animal.addCommand(Command.stop);
                    break;
                case 3:
                    animal.addCommand(Command.run);
                    break;
                case 4:
                    animal.addCommand(Command.comeUp);
                    break;
                case 5:
                    animal.addCommand(Command.standUp);
                    break;
                case 6:
                    animal.addCommand(Command.jump);
                    break;
                case 7:
                    animal.addCommand(Command.walk);
                    break;
                case 8:
                    animal.addCommand(Command.kick);
                    break;
                case 9:
                    animal.addCommand(Command.bray);
                    break;
                case 10:
                    animal.addCommand(Command.sit);
                    break;
                case 11:
                    animal.addCommand(Command.gallop);
                    break;
                default:
                    break;

            }
        } else {
            System.out.println("Животное с таким id не найдено");
        }



        }

    private static void menuCommand() {
        System.out.println("Напишите команду, которой вы хотите обучить животное:");
        System.out.println("1. идти");
        System.out.println("2. остановиться");
        System.out.println("3. бежать");
        System.out.println("4. подойти");
        System.out.println("5. вставать");
        System.out.println("6. прыгать");
        System.out.println("7. гулять");
        System.out.println("8. пинать");
        System.out.println("9. голос");
        System.out.println("10. сидеть");
        System.out.println("11. галлоп");
        System.out.println("Любая другая. Я передумал");

    }

    private static boolean isValidDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false); // Strict parsing
        try {
            //Date date = dateFormat.parse(dateStr);
            String[] parts = dateStr.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);
            if (year < 1980 || year > 2024) {
                return false;
            }

            if (month < 1 || month > 12) {
                return false;
            }

            if (day < 1 || day > 31) {
                return false;
            }
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }


    }
   private static void listAnimalsByBirth(){
       System.out.println("Какой год рождения животного вас интересует?");
       Scanner scanner = new Scanner(System.in);
       int yearBirth = checkNumber(scanner);
       List<HumanFriends> filteredAnimals = new ArrayList<>();

       for (HumanFriends animal : animals) {
           if (animal.getBirthYear() == yearBirth) {
               filteredAnimals.add(animal);

           }
       }
       if (filteredAnimals.size()==0) {
           System.out.println("Животных такого года рождения не найдено");
       }
       else System.out.println(filteredAnimals);



    }

    private static int checkNumber(Scanner scanner) {
        int number = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                String input = scanner.nextLine();
                number = Integer.parseInt(input);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число: ");
            }
        }

        return number;
    }



    }


