package game.description;

public class Name {
    private String qualifier;
    private String name;
    private String plural;

    public Name(String qualifier, String name, String plural) {
        this.qualifier = qualifier;
        this.name = name;
        this.plural = plural;
    }

    public String getQualifier() {
        return qualifier;
    }

    public String getName() {
        return name;
    }

    public String getPlural() {
        return plural;
    }

    public String getQualifiedName() {
        return qualifier + " " + name;
    }
}
