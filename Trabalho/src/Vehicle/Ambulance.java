import java.time.LocalDate;

public class Ambulance extends EmergencyVehicle {

    public Ambulance(int id, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional) {
        super(id, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional, VehicleType.AMBULANCE);
    }

    @Override
    public LocalDate getIncorporationDate() {
        return super.getIncorporationDate();
    }

    @Override
    public LocalDate getLastInspection() {
        return super.getLastInspection();
    }

    @Override
    public String getManufacturer() {
        return super.getManufacturer();
    }

    @Override
    public double getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public LocalDate getNextInspection() {
        return super.getNextInspection();
    }

    @Override
    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public boolean isOparicional() {
        return super.isOparicional();
    }

    @Override
    public void setIncorporationDate(LocalDate incorporationDate) {
        super.setIncorporationDate(incorporationDate);
    }

    @Override
    public void setLastInspection(LocalDate lastInspection) {
        super.setLastInspection(lastInspection);
    }

    @Override
    public void setManufacturer(String manufacturer) {
        super.setManufacturer(manufacturer);
    }

    @Override
    public void setMaxSpeed(double maxSpeed) {
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public void setNextInspection(LocalDate nextInspection) {
        super.setNextInspection(nextInspection);
    }

    @Override
    public void setOparicional(boolean isOparicional) {
        super.setOparicional(isOparicional);
    }

    @Override
    public void setWeight(double weight) {
        super.setWeight(weight);
    }

    

    
    
}
