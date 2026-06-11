package EmergencyMission;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import EmergencyMission.Enums.ContextType;
import EmergencyMission.Enums.EmergencyType;
import EmergencyMission.Interface.EmergencyMission;
import MedicalTeam.MedicalTeam;
import MedicalTeam.TeamMember;
import Vehicles.EmergencyVehicle;

public class Mission implements EmergencyMission{

    private final int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EmergencyType emergencyType;
    private ContextType contextType;
    private String description;
    private EmergencyVehicle vehicle;
    private MedicalTeam team;
    private TeamMember responsible;

    public Mission(int id, LocalDateTime startDate, LocalDateTime endDate, EmergencyType emergencyType, ContextType contextType, String description, EmergencyVehicle emergencyVehicle, MedicalTeam medicalTeam, TeamMember responsible) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.emergencyType = emergencyType;
        this.contextType = contextType;
        this.description = description;
        this.vehicle = emergencyVehicle;
        this.team = medicalTeam;
        this.responsible = responsible;
    }

    @Override
    public int getDurationMinutes() {
        if (this.startDate == null || this.endDate == null) {
            return 0;
        }

       long minutos = ChronoUnit.MINUTES.between(this.startDate, this.endDate);
        
        return (int) minutos;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public EmergencyType getEmergencyType() {
        return this.emergencyType;
    }

    public void setEmergencyType(EmergencyType emergencyType) {
        this.emergencyType = emergencyType;
    }

    public ContextType getContextType() {
        return this.contextType;
    }

    public void setContextType(ContextType contextType) {
        this.contextType = contextType;
    }

    public EmergencyVehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(EmergencyVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public MedicalTeam getTeam() {
        return this.team;
    }

    public void setTeam(MedicalTeam team) {
        this.team = team;
    }

    public TeamMember getResponsible() {
        return this.responsible;
    }

    public void setResponsible(TeamMember responsible) {
        this.responsible = responsible;
    }
}
