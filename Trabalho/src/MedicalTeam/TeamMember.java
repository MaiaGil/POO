package MedicalTeam;

public class TeamMember {
    private final int id;
    private String name;
    private int age;
    private boolean isDoctor;

    public TeamMember(int id, String name, int age, boolean isDoctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isDoctor = isDoctor; 
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDoctor(boolean isDoctor) {
        this.isDoctor = isDoctor;
    }
    
}
