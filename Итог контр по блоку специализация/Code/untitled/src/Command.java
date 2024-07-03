public enum Command {
    go ("идти"),
    stop("остановиться"),
    run("бежать"),
    SLIP("спать"),
    comeUp("подойти"),
    jump("прыгать"),
    walk("гулять"),
    kick("пинать"),
    bray("голос"),
    sit("сидеть"),
    gallop("галлоп"),
    standUp("вставать");
    private String title;

    Command(String title) {
        this.title = title;
    }
    public String getCommand() {
        return title;
    }


    @Override
    public String toString() {
        return title + '\'';
    }
}

