package MedicalTeam;

public class Doctor extends TeamMember {
    private boolean isResponsible;
    
    public Doctor(int id, String name, int age, boolean isResponsible) {
        super(id, name, age, "doctor");
        this.isResponsible = isResponsible;
    }

    public boolean isResponsible() {
        return isResponsible;
    }

    public void setResponsible(boolean isResponsible) {
        this.isResponsible = isResponsible;
    }
}
