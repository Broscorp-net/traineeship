import java.util.List;

public class SomeObject {

    private int id;
    private String name;
    private List<String> tags;

    public SomeObject(int id, String name, List<String> tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        SomeObject someObj = (SomeObject) obj;
        if(id != someObj.id)
            return false;
        if(!name.equals(someObj.name))
            return false;
        if(!tags.equals(someObj.tags))
            return false;

        return true;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + name.hashCode();
        result += tags.stream().mapToInt(tag -> tag.hashCode()).sum();
        return result;
    }
}
