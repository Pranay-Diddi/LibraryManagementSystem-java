public class LibMem {
    private String name;
    private String id;
    private String position;

    public LibMem(String name, String id, String pos) {
        this.name = name;
        this.id = id;
        this.position = pos;
    }

    public String getPosition() {
        return this.position;
    }

    public void printDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("User Id: " + this.id);
        System.out.println("Position: " + this.position);
    }
}