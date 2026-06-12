package MedicalTeam;
import MedicalTeam.Exceptions.TeamMemberNotFoundException;
import MedicalTeam.Exceptions.TeamNeedsDoctorException;

public class MedicalTeam {
    private TeamMember[] teamMembers;
    private int teamMemberCount;
    private int teamMemberId;
    private int numberDoctors;
    private boolean hasResponsible;

    public MedicalTeam(int numberTeamMembers) {
        this.teamMembers = new TeamMember[numberTeamMembers];
        this.teamMemberCount = 0;
        this.teamMemberId = 0;
        this.numberDoctors = 0;
        this.hasResponsible = false;
    }

    public TeamMember[] getTeamMembers(){
        TeamMember[] allTeamMembers = new TeamMember[this.teamMemberCount];
        for ( int i = 0; i < this.teamMemberCount; i++){
            allTeamMembers[i] = this.teamMembers[i];
        }
        return allTeamMembers;
    }

    private boolean getTeamMember(int id){
        for (int i = 0; i < this.teamMemberCount; i++) {
            if (this.teamMembers[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    private int getTeamMemberPos(int id){
        for (int i = 0; i < this.teamMemberCount; i++) {
            if (this.teamMembers[i].getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void addTeamMember(String name, int age, String job) throws TeamNeedsDoctorException, Exception{
        if (this.teamMemberCount != this.teamMembers.length){

            if (this.teamMemberCount == this.teamMembers.length - 1 && this.numberDoctors == 0){
                throw new TeamNeedsDoctorException();
            }
            
            TeamMember teamMember = new TeamMember(this.teamMemberId, name, age, job);
            
            this.teamMembers[this.teamMemberCount] = teamMember;
            this.teamMemberCount++;
            this.teamMemberId++;

        } else {
            throw new Exception("Team is full");
        }
    }

    public void addDoctor(String name, int age, String job, boolean isResponsible) throws Exception{
        if (this.teamMemberCount != this.teamMembers.length){

            if (this.teamMemberCount == this.teamMembers.length - 1 && this.numberDoctors == 0 && !isResponsible){
                isResponsible = true;
            };

            if (isResponsible ) {
                if (!this.hasResponsible){
                    this.hasResponsible = true;
                } else {
                    //exception The team can not have 2 responsible
                }
            };
            
            Doctor doctor = new Doctor(this.teamMemberId, name, age, isResponsible);
            
            this.teamMembers[this.teamMemberCount] = doctor;
            this.teamMemberCount++;
            this.teamMemberId++;
            this.numberDoctors++;

        } else {
            throw new Exception("Team is full");
        }
    }

    public void readTeamMembers() throws Exception{
        if (this.teamMemberCount != 0){
            for (int i = 0; i < this.teamMemberCount; i++) {
                System.out.print(this.teamMembers[i].getId());
                System.out.print(this.teamMembers[i].getName());
                System.out.print(this.teamMembers[i].getAge());
                System.out.print(this.teamMembers[i].getJob());
            }
        } else {
            throw new Exception("There are no team members in this team");
        }
    }

    public void updateTeamMember(int id, String name, int age) throws TeamMemberNotFoundException{
        if (getTeamMember(id)) {

            TeamMember member = this.teamMembers[getTeamMemberPos(id)]; 

            if (name != null && !name.trim().isEmpty()){
                member.setName(name);
            }
            if (age > 0){
                member.setAge(age);
            }

        } else{
            throw new TeamMemberNotFoundException();
        }
    }

    public void deleteTeamMember(int id) throws TeamMemberNotFoundException, TeamNeedsDoctorException{
        if (getTeamMember(id)) {
            int pos = getTeamMemberPos(id);

            TeamMember member = teamMembers[pos]; 

            // Lembrar do instanceof, pois é usado por um array pais para saber o tipo de filho
            if (member instanceof Doctor) {
                Doctor doc = (Doctor) member;

                if (this.numberDoctors == 1) {
                    throw new TeamNeedsDoctorException();
                } else {
                    if (doc.isResponsible()) {
                        this.hasResponsible = false; 
                    }
                    
                    this.numberDoctors--;
                }
            }

            for (int i = pos; i < this.teamMemberCount-1; i++) {
                this.teamMembers[i] = this.teamMembers[i+1];
            }

            this.teamMemberCount--;
            this.teamMembers[this.teamMemberCount] = null;

        } else{
            throw new TeamMemberNotFoundException();
        }
    }
}
