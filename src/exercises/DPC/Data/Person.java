package exercises.DPC.Data;

public abstract class Person {
    private final int id;
    private String name;
    private String email;

    public Person(int id, String name, String email){
        this(id,name);
        this.email=email;
    }

    public Person(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {return this.id;}
    public String getName() {return this.name;}
    public String getEmail() {return this.email;}

    public void setName(String name) {this.name=name;}
    public void setEmail(String email) {this.email=email;}

    public String toString(Person person){
        return person.getId() + " " + person.getName() + " " + person.getEmail();
    }
}
