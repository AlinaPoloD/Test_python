import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static List<HumanFriends> animals = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    menuAddAnimals();
                    int animalChoise = scanner.nextInt();
                    if (animalChoise >=1 && animalChoise <=6){
                    addAnimal(animalChoise);
                    }
                    else break;
                case 2:
                    //System.out.println("2. Вывести команды которые может делать животное");

                   // showAnimalCommands(scanner);
                    break;
                case 3:
                    //trainAnimal(scanner);
                    //System.out.println("3. Обучить животное новой команде");

                    break;
                case 4:
                    //listAnimalsByBirthDate();
                    //System.out.println("4. Вывести список животных по дате рождения");

                    break;
                case 5:
                   // System.out.println("Total number of animals: " + Animal.getAnimalCount());
                    //System.out.println("5. Вывести общее количество всех животных");

                    break;
                case 6:
                    // System.out.println("Total number of animals: " + Animal.getAnimalCount());
                    //System.out.println("6. Вывести общее количество домашних животных");

                    break;
                case 7:
                    // System.out.println("Total number of animals: " + Animal.getAnimalCount());

                    //System.out.println("7. Вывести общее количество вьючных животных");

                    break;
                case 8:
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
        System.out.println("6. Вывести общее количество домашних животных");
        System.out.println("7. Вывести общее количество вьючных животных");
        System.out.println("8. Выход");
    }
    private static void addAnimal(int numAnimal){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date (yyyy-mm-dd): ");
        String birthDate = scanner.nextLine();


        switch (numAnimal) {
            case 1:
                animals.add(new Cats(name, birthDate));
                break;
            case 2:
                animals.add(new Cats(name, birthDate));
                break;
            case 3:
                animals.add(new Cats(name, birthDate));
                break;
            case 4:
                animals.add(new Cats(name, birthDate));
                break;
            case 5:
                animals.add(new Cats(name, birthDate));
                break;
            case 6:
                animals.add(new Cats(name, birthDate));
                break;
        }
    }

    private static void menuAddAnimals() {
        System.out.println("Какое животное вы хотите выбрать, наберите цифру которая соответствует животному:");
        System.out.println("1. Кот");
        System.out.println("2. Собака");
        System.out.println("3. Хомяк");
        System.out.println("4. Верблюд");
        System.out.println("5. Осел");
        System.out.println("6. Лошадь");
        System.out.println("Любая другая. Я ошибся, не хочу добавлять животное");

    }





    }


