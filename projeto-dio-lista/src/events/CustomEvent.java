package events;

public class CustomEvent extends Event {
    private String name;

    public CustomEvent(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Nome Personalizado";
    }

    public String getName() {
        return name;
    }
}