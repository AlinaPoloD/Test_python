import json
import datetime
import time
from typing import List


file_name = "notes.json"
note_id = 0


def interface():

    user_input = None
    while user_input != "5":
        print(
            "Возможные варианты действия:\n"
            "1. Добавление заметки\n"
            "2. Чтение заметки\n"
            "3. Редактирование или удаление заметки\n"
            "4. Выход из программы\n"
        )

        user_input = input("Введите вариант: ")

        while user_input not in ("1", "2", "3", "4"):
            print("Некорректный ввод.")
            user_input = input("Введите вариант: ")
        print()

        match user_input:
            case "1":
                new_note()
            case "2":
                read_note()
            case "3":
                edit_note()
            case "4":
                break

        print()


def file_notes():
    # notes = file_notes()
    try:
        with open(file_name, "r") as file:
            notes = json.load(file)
    except (json.JSONDecodeError, FileNotFoundError):
        with open(file_name, "w") as file:
            json.dump([], file)
        notes = []
        print("Новый файл с заметками создан\n")
    return notes


def new_note():

    notes = file_notes()
    global note_id

    print(
        " Вы действительно хотите создать новую заметку?\n"
        "1. да\n"
        "Любая клавиша -выход в меню\n"
    )
    user_input = input("Введите вариант: ")
    while user_input not in ("1"):
        interface()
    title = input("Введите название заголовка: ")
    text = input("Введите тело заметки: ")

    note_id += 1
    timestamp = datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")
    edit_time = timestamp
    note = {
        "id": note_id,
        "title": title,
        "text": text,
        "timestamp": timestamp,
        "edit_time": edit_time,
    }
    notes.append(note)
    with open(file_name, "w") as file:
        json.dump(notes, file, indent=4)
    print(f"Заметка успешно сохранена - id: {note ['id']}")


def read_note():

    try:
        with open(file_name, "r") as file:
            notes = json.load(file)
            print(
                "Возможные варианты действия:\n"
                "1. Поиск заметки по id\n"
                "2. Вывод заметки по дате \n"
                "3. Вывод всех заметок\n"
                "Любая клавиша -выход в меню\n"
            )
            user_input = input("Введите вариант: ")
            while user_input not in ("1", "2", "3"):
                interface()

            print()

            match user_input:
                case "1":
                    id = int(input("Введите id: "))
                    for note in notes:
                        if note["id"] == id:
                            print(
                                f"ID: {note['id']}, Заголовок: {note['title']}, Текст: {note['text']}, Время создания: {note['timestamp']}, Время последнего изменения: {note['edit_time']}"
                            )
                            break
                    else:
                        print("Заметка с указанным ID не найдена.")
                case "2":
                    filter_date = input("Введите дату создания в формате 2024-02-19: ")
                    count = 0

                    for note in notes:
                        timest = note["timestamp"]
                        date = time.strptime(timest, "%Y-%m-%d %H:%M:%S")
                        formatted_date = time.strftime("%Y-%m-%d", date)

                        if formatted_date == filter_date:
                            count += 1
                            print(
                                f"ID: {note['id']}, Заголовок: {note['title']}, Текст: {note['text']}, Время создания: {note['timestamp']}, Время последнего изменения: {note['edit_time']}"
                            )
                    if count == 0:
                        print("нет заметок с такой датой создания")

                case "3":
                    for note in notes:
                        print(
                            f"ID: {note['id']}, Заголовок: {note['title']}, Текст: {note['text']}, Время создания: {note['timestamp']}, Время последнего изменения: {note['edit_time']}"
                        )
            print()

    except (json.JSONDecodeError, FileNotFoundError):
        print("Файла с заметками не сущетсвует\n")


def edit_note():

    user_input = None
    try:
        with open(file_name, "r+") as file:
            notes = json.load(file)

        print(
            "Возможные варианты действия:\n"
            "1. Редактирование заметки\n"
            "2. Удаление заметки\n"
            "Введите любую цифру для выхода обратно в меню\n"
        )

        user_input = input("Введите вариант: ")

        while user_input not in ("1", "2"):
            interface()

        match user_input:
            case "1":

                print(
                    "1. Режим редактирования заметки\n"
                    "Введите любую клавишу (не 1) для выхода обратно в меню\n"
                )

                user_input = input("Введите вариант: ")
                while user_input not in ("1"):
                    interface()

                if user_input == "1":
                    id = int(input("Напишите id заметки, которую вы хотите изменить: "))
                    for note in notes:
                        if note["id"] == id:
                            new_title = input("Введите заголовок: ")
                            note["title"] = new_title
                            new_text = input("Введите текст заметки: ")
                            note["text"] = new_text
                            new_time = datetime.datetime.now().strftime(
                                "%Y-%m-%d %H:%M:%S"
                            )
                            note["edit_time"] = new_time
                            note = {
                                "id": id,
                                "title": new_title,
                                "text": new_text,
                                "edit_time": new_time,
                            }
                            break
                    else:
                        print("Заметка с указанным ID не найдена.")

                    with open(file_name, "w") as file:
                        json.dump(notes, file, indent=4)

                else:
                    interface()

            case "2":
                print(
                    "1. Режим удаления заметки\n"
                    "Введите любую клавишу (не 1) для выхода обратно в меню\n"
                )

                user_input = input("Введите вариант: ")
                while user_input not in ("1"):
                    interface()
                new_notes = []
                count = 0
                if user_input == "1":
                    id = int(input("Напишите id заметки, которую вы хотите удалить: "))
                    for note in notes:
                        if note["id"] != id:
                            new_notes.append(note)

                        else:
                            count += 1
                    if count == 0:
                        print("Заметки с таким id нет")

                    with open(file_name, "w") as file:
                        json.dump(new_notes, file, indent=4)

                else:
                    interface()
    except (json.JSONDecodeError, FileNotFoundError):
        print("Файла с заметками не сущетсвует\n")


def main():
    interface()


if __name__ == "__main__":
    main()
