package exercises.DPC.Gui;

import exercises.DPC.Data.Person;
import exercises.DPC.Data.Student;
import exercises.DPC.Data.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PeopleManager {
    /**
     * Adds some data to the lists
     */
    public PeopleManager(){
        addPersonToList(100,"Hans Nielsen"," hni@easv.dk");

        addPersonToList(101,"Niels Hansen", "nha@easv.dk");

        addPersonToList(102,"Ib Boesen","ibo@easv.dk");

        addTeacherToList(502,"Bent H. Pedersen","bhp@easv.dk","bhp","Programming");

        addStudentsToList(105,"Bo Ibsen", "bib@easv.dk","CS",8.5);
    }

List<Person> people = new ArrayList<>();
List<Teacher> teachersList = new ArrayList<>();
List<Student> studentList = new ArrayList<>();

public void addPersonToList(int id, String name, String email){
    people.add(new Student(id,name,email));
}

    public int uniqueNumber(int i) {
        for (Person person : people){
            if(i== person.getId())
                i++;
        }
        return i;
    }
    /**
     * Adds a Teacher to the teacher list
     * @param id
     * @param name
     * @param email
     * @param initials
     * @param main
     */
    public void addTeacherToList(int id, String name, String email, String initials, String main){
    teachersList.add(new Teacher(id,name,email,initials,main));
    people.add(new Teacher(id,name,email));
}

    /**
     * Adds a Student to the student list
     * @param id
     * @param name
     * @param email
     * @param education
     * @param gradeAVG
     */
    public void addStudentsToList(int id, String name, String email, String education, double gradeAVG){
    studentList.add(new Student(id,name,email,education,gradeAVG));
    people.add(new Student(id,name,email));
}

    /**
     * Checks if the person exists and deletes the person if it exists
     * @param input <- id# or name
     * @return <- tells user that the person was deleted or does nothing if the person doesnt exist
     */
    public String removePerson(String input) {
        try {
                people.removeIf(person -> person.getId() == Integer.parseInt(input));
                teachersList.removeIf(person -> person.getId() == Integer.parseInt(input));
                studentList.removeIf(person -> person.getId() == Integer.parseInt(input));
                return "Person with number: " + input + " has been deleted.";
        } catch (NumberFormatException exception) {
                people.removeIf(person -> person.getName().equals(input));
                teachersList.removeIf(person -> person.getName().equals(input));
                studentList.removeIf(person -> person.getName().equals(input));
                return "Person with name: " + input + " has been deleted.";
    }
}

    /**
     * Fetches one persons data
     * @param input <- A Persons ID
     * @return <- A Persons data
     */
    public String getPersonsInfo(String input){
    for(Teacher person : teachersList)
        try{
            if(Integer.parseInt(input)== person.getId()){
                return person.toString(person);
            }
        }
        catch (NumberFormatException exception){
            if(person.getName().equals(input)){
                return person.toString(person);
            }
        }
    for(Student person : studentList)
        try{
            if(Integer.parseInt(input)== person.getId()){
                return person.toString(person);
            }
        }
        catch (NumberFormatException exception){
            if(person.getName().equals(input)){
                return person.toString(person);
            }
        }
    for (Person person : people){
        try{
            if(Integer.parseInt(input)== person.getId()){
                return person.toString(person);
            }
        }
        catch (NumberFormatException exception){
            if(person.getName().equals(input)){
                return person.toString(person);
            }
        }
    }
    return "";
}

    /**
     * Prints info in arrays
     */
    public void printPeoplesInfo() {
    System.out.printf("%n%4s%20s%20s%n","####","Name","Email");
    people.sort(Comparator.comparingInt(Person::getId));
    for (Person person : people) {
        System.out.printf("%4d", person.getId());
        System.out.printf("%20s", person.getName());
        System.out.printf("%20s", person.getEmail());
        System.out.printf("%n");
    }
    }

    public void printTeachersInfo(){
    teachersList.sort(Comparator.comparingInt(Person::getId));
        System.out.printf("%n%4s%20s%20s%10s%1s%-15s", "####", "Name", "Email", "Initials","", "Main");
    for(Teacher teacher: teachersList)
        System.out.printf("%n%4d%20s%20s%10s%1s%-15s", teacher.getId(), teacher.getName(), teacher.getEmail(), teacher.getInitials(),"", teacher.getSubjects());
        System.out.printf("%n");
}

    public void printStudentsInfo(){
    studentList.sort(Comparator.comparingInt(Person::getId));
        System.out.printf("%n%4s%20s%20s%10s%15s", "####", "Name", "Email", "Education", "GradeAVG");
        for(Student student: studentList)
            System.out.printf("%n%4d%20s%20s%10s%15s", student.getId(), student.getName(), student.getEmail(), student.getEducation(), student.getGradeAVG());
        System.out.printf("%n");
    }
}
