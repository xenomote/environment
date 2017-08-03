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

    public String getFullName() {
        return qualifier + " " + name;
    }

    public String getFullName(int number) {
        if (number == 1) {
            return getFullName();
        }

        else {
            return Description.numerate(number) + " " + getPlural();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        else if (obj instanceof Name) {
            Name name = ((Name) obj);
            return
                    getQualifier().equals(name.getQualifier()) &&
                    getName().equals(name.getName()) &&
                    getPlural().equals(name.getPlural());

        }

        return false;
    }

    @Override
    public int hashCode() {
        return getQualifier().hashCode() ^ getName().hashCode() ^ getPlural().hashCode();
    }
}
