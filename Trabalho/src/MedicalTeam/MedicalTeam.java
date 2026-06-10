package MedicalTeam;
import MedicalTeam.Exceptions.*;

public class MedicalTeam {
    private TeamMember[] teamMembers;
    private int teamMemberCount;
    private int teamMemberId;
    private int numberDoctors;

    public MedicalTeam(int numberTeamMembers) {
        this.teamMembers = new TeamMember[numberTeamMembers];
        this.teamMemberCount = 0;
        this.teamMemberId = 0;
        this.numberDoctors = 0;
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

    public void addTeamMember(String name, int age, boolean isDoctor) throws TeamNeedsDoctorException, Exception{
        if (this.teamMemberCount != this.teamMembers.length){

            if (this.teamMemberCount == this.teamMembers.length - 1 && this.numberDoctors == 0 && !isDoctor){
                throw new TeamNeedsDoctorException();
            }
            
            TeamMember teamMember = new TeamMember(this.teamMemberId, name, age, isDoctor);
            
            teamMembers[this.teamMemberCount] = teamMember;

            if (isDoctor){
                numberDoctors++;
            }
            this.teamMemberCount++;
            this.teamMemberId++;

        } else {
            throw new Exception("Team is full");
        }
    }

    public void updateTeamMember(int id, String name, int age) throws TeamMemberNotFoundException{
        if (getTeamMember(id)) {

            TeamMember member = teamMembers[getTeamMemberPos(id)]; 

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

            if (member.isDoctor()){
                if (numberDoctors == 1){
                    throw new TeamNeedsDoctorException();
                } else {
                    numberDoctors--;
                }
            }

            for (int i = pos; i < this.teamMemberCount-1; i++) {
                this.teamMembers[i] = this.teamMembers[i+1];
            }

            this.teamMemberCount--;
            this.teamMembers[teamMemberCount] = null;

        } else{
            throw new TeamMemberNotFoundException();
        }
    }
}
