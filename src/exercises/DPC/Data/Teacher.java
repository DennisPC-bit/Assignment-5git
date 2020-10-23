package exercises.DPC.Data;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private String initials;
    private List<String> subjects;
    private String main;

    public Teacher(int id, String name, String email, String initials, String main) {
        super(id, name, email);
        this.initials = initials;
        this.main=main;
        subjects = new ArrayList<>();
        addSubjects(main);
    }
    public Teacher(int id, String name, String email){
        super(id,name,email);
    }

    /**
     * Adds a subject to the Teacher
     * @param subject
     */
    public void addSubjects(String subject){
        subjects.add(subject);
    }

    /**
     * Returns Subjects
     * @return
     */
    public String getSubjects(){
        String output = "";
        int i=0;
            for (String subjectss : subjects) {
                output += subjectss;
                i++;
                if(subjects.size()!=i)
                    output+=", ";
            }
        return output;
    }

    public String getInitials() {
        return initials;
    }

    public String toString(Teacher person){
        return person.getId() + " " + person.getName() + " " + person.getEmail() + " " + person.getInitials() + " " + person.getSubjects();
    }
}