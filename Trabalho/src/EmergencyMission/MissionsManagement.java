package EmergencyMission;

import EmergencyMission.Interface.EmergencyMission;
import EmergencyMission.Interface.MissionLoggable;

public class MissionsManagement implements MissionLoggable{

    private Mission[] missions;
    private int missionId;
    private int missionCount;
    private final int incrementMissions = 10;

    public MissionsManagement(int numberMissions){
        this.missions = new Mission[numberMissions];
        this.missionId = 0;
        this.missionCount = 0;
    }
    
    @Override
    public EmergencyMission[] getMissions() {
        return null;
    }

    @Override
    public void addMission(Mission var1) {

        if (this.missionCount == missions.length){
            Mission[] temp = new Mission[this.missionCount + this.incrementMissions];
            for (int i = 0; i < this.missionCount; i++) {
                temp[i] = this.missions[i];
            }
            this.missions = temp;
        }

        this.missions[this.missionCount] = var1;
        this.missionCount++;
        this.missionId++;
    }

    public void readMissions(){
        if (this.missionCount > 0){
            for (int i = 0; i < this.missionCount; i++) {
                System.out.print(missions[i].getId());
                System.out.print(missions[i].getContextType());
                System.out.print(missions[i].getDescription());
                System.out.print(missions[i].getDurationMinutes());
                System.out.print(missions[i].getEmergencyType());
                System.out.print(missions[i].getStartDate());
                System.out.print(missions[i].getEndDate());
                System.out.print(missions[i].getResponsible());
                System.out.print(missions[i].getTeam());
                System.out.print(missions[i].getVehicle());
            }
        } else {
            //não existem missões
        }
    }

    private int getMissionPos(int id){
        for (int i = 0; i < this.missionCount; i++) {
            if (id == missions[i].getId()) {
                return i;
            }
        }
        return -1;
    }

    private boolean getMission(int id){
        for (int i = 0; i < this.missionCount; i++) {
            if (id == missions[i].getId()) {
                return true;
            }
        }
        return false;
    }

    public void updateMissions(Mission mission){
        if (getMission(mission.getId())){
            int pos = getMissionPos(mission.getId());

            this.missions[pos] = mission;

        } else {
            //Missão não encontrada
        }
    }

    public void deleteMission(Mission mission){
        if (getMission(mission.getId())){
            int pos = getMissionPos(mission.getId());

            for (int i = pos; i < this.missionCount - 1; i++) {
                this.missions[i] = this.missions[i + 1];
            }

            this.missionCount--;
            this.missions[this.missionCount] = null;

        } else {
            //Missão não encontrada
        }
    }


    

}
