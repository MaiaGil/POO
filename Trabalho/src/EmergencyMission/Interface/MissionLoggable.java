package EmergencyMission.Interface;
import EmergencyMission.Mission;

public interface MissionLoggable {
    void addMission(Mission var1);
    EmergencyMission[] getMissions();
}
