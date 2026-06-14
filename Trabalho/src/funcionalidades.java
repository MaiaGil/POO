import EmergencyMission.Enums.ContextType;
import EmergencyMission.Enums.EmergencyType;
import EmergencyMission.Mission;
import EmergencyMission.MissionsManagement;
import MedicalTeam.MedicalTeam;
import MedicalTeam.TeamMember;
import Vehicles.EmergencyVehicle;
import Vehicles.VehicleManagement;
import Vehicles.VehicleType;

public class funcionalidades {
    private VehicleManagement vehicleM;
    private MedicalTeam teamM;
    private MissionsManagement missonM;

    public funcionalidades(VehicleManagement vM, MedicalTeam tM, MissionsManagement mM) {
        this.vehicleM = vM;
        this.teamM = tM;
        this.missonM = mM;
    }

    private Mission[] missionFull(Mission[] missions, int count){
        Mission[] temp = new Mission[count + 10];
        for (int j = 0; j < count; j++) {
            temp[j] = missions[j];
        }
        return temp;
    }

    public void vehiclesIncorporatedYear(int year){
        EmergencyVehicle[] allVehicle = vehicleM.getEmergencyVehicles();

        for (int i = 0; i < allVehicle.length; i++) {
            if (allVehicle[i].getIncorporationDate().getYear() == year){
                System.out.print(allVehicle[i].getId());
                System.out.print(allVehicle[i].getType());
                System.out.print(allVehicle[i].getIncorporationDate() + "\n");
            }
        };

        //Deve-se fazer esta função com em vez de Void ser EmergencyVehicle[]
        //E deve-se dar return a um arrat de veiculos incorporados no ano escolhido, vou fazer em baixo para verem
    }

    public Mission[] getVehicleEmergencies(EmergencyVehicle vehicle){
        Mission[] allMissions = missonM.getMissions();
        Mission[] missions = new Mission[10];
        int count = 0;

        for (int i = 0; i < allMissions.length; i++) {
            if (allMissions[i].getVehicle() == vehicle){
                if ( count == missions.length){
                    missions = missionFull(missions, count);
                }

                missions[count] = allMissions[i];
                count++;
            }
        }

        Mission[] result = new Mission[count];
        for (int i = 0; i < count; i++) {
            result[i] = missions[i];
        }

        return result;
    }

    public double getAverageEmergenciesByVehicleAndType(EmergencyType emergencyType, VehicleType vehicleType) throws Exception{
        Mission[] allMissions = missonM.getMissions();
        Vehicle[] allVehicles = vehicleM.getVehicles();
        int countEmergencies = 0;
        int countVehicles = 0;

        for (int i = 0; i < allMissions.length; i++) {
            if (allMissions[i].getEmergencyType() == emergencyType && allMissions[i].getVehicle().getType() == vehicleType){
                countEmergencies++;
            }
        }

        for (int i = 0; i < allVehicles.length; i++) {
            if (allVehicles[i].getType() == vehicleType) {
                countVehicles++;
            }
        }

        if (countVehicles == 0) {
            throw new Exception("No vehicles of this type found.");
        }

        return (double) countEmergencies / countVehicles;
    }

    public void displayNationalInternationalEmergenciesVehicle(EmergencyVehicle vehicle){
        Mission[] allMissions = missonM.getMissions();
        int countNational = 0;
        int countInternational = 0;
        
        for (int i = 0; i < allMissions.length; i++) {
            if (allMissions[i].getVehicle().equals(vehicle)){ // usar ou .equals() ou == vai dar á mesma coisa, mas é mais correto usar o .equals(), ver o ficheiro EmergencyVehicle
                if (allMissions[i].getContextType() == ContextType.NATIONAL){
                    countNational++;
                } else {
                    countInternational++;
                }
            }
        }

        System.out.println("Number of national emergencies for this vehicle: " + countNational);
        System.out.println("Number of international emergencies for this vehicle: " + countInternational);
    }

    public void endDateVehicle(int endYear){
        // muito parecido com a função vehiclesIncorporatedYear(int year)
    }

    public Mission[] getEmergenciesMember(TeamMember member){
        Mission[] allMissions = missonM.getMissions();
        Mission[] missions = new Mission[10];
        int count = 0;

        for (int i = 0; i < allMissions.length; i++) {

            TeamMember[] membreMission = allMissions[i].getTeam().getTeamMembers();

            for (int j = 0; j < membreMission.length; j++) {
                if (membreMission[j].getId() == member.getId()){
                    
                    if (count == missions.length){
                        missions = missionFull(missions, count);
                    }

                    missions[count] = allMissions[i];
                    count++;
                    break; // A tua otimização perfeita!
                }
            }
        }

        Mission[] result = new Mission[count];
        for (int i = 0; i < count; i++) {
            result[i] = missions[i];
        }

        return result;
    }

    public EmergencyVehicle[] vehiclesEmergencyYear(int minEmergencies, int year){
        Mission[] allMissions = missonM.getMissions();
        EmergencyVehicle[] allVehicle = vehicleM.getEmergencyVehicles();
        
        EmergencyVehicle[] vehicle = new EmergencyVehicle[10];
        int count = 0;

        for ( int i = 0; i < allVehicle.length; i++){
            int countMissionsVehicle = 0;

            for (int j = 0; j < allMissions.length; j++){
                if (allMissions[j].getVehicle().equals(allVehicle[i]) && allMissions[j].getStartDate().getYear() == year) {
                    countMissionsVehicle ++;
                }
            }

            if ( countMissionsVehicle >= minEmergencies){
                if (count == vehicle.length){
                    EmergencyVehicle[] temp = new EmergencyVehicle[count + 10];
                    for (int k = 0; k < count; k++) {
                        temp[k] = vehicle[k];
                    }
                    vehicle = temp;
                }

                vehicle[count] = allVehicle[i];
                count++;

            }
        }

        EmergencyVehicle[] result = new EmergencyVehicle[count];
        for (int i = 0; i < count; i++) {
            result[i] = vehicle[i];
        }

        return result;
    }
}
