package MedicalTeam;

public class TeamMember {
    private final int id;
    private String name;
    private int age;
    private String job;

    public TeamMember(int id, String name, int age, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job; 
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getJob() {
        return this.job;
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

    public void setJob(String job) {
        this.job = job;
    }
    
}
