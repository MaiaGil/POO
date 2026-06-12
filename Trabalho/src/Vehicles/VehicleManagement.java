package Vehicles;
import java.time.LocalDate;

public class VehicleManagement {
    private EmergencyVehicle[] emergencyVehicles;
    private int vehicleCount;
    private int idVehicle;
    private final int incrementVehicles = 10;


    public VehicleManagement(int numberVehicle) {
        this.emergencyVehicles = new EmergencyVehicle[numberVehicle];
        this.vehicleCount = 0;
        this.idVehicle = 0;
    }

    public EmergencyVehicle[] getEmergencyVehicles(){
        EmergencyVehicle[] vehicles = new EmergencyVehicle[this.vehicleCount];
        for (int i = 0; i < this.vehicleCount; i++) {
            vehicles[i] = this.emergencyVehicles[i];
        }
        return vehicles;
    }

    /**
     * Funções gerais
     */

    private void createForAll(EmergencyVehicle vehicle){
        if (this.emergencyVehicles.length == this.vehicleCount){
            maxVehicles();
        }
        
        this.emergencyVehicles[this.vehicleCount] = vehicle; 
        this.vehicleCount++;
        this.idVehicle++;
    }

    private void maxVehicles(){
        EmergencyVehicle[] temp = new EmergencyVehicle[this.emergencyVehicles.length + this.incrementVehicles]; 

        for (int i = 0; i < this.emergencyVehicles.length; i++) {
            temp[i] = this.emergencyVehicles[i];
        }

        this.emergencyVehicles = temp;
    }

    private boolean getVehicle(int id){
        for (int i = 0; i < this.vehicleCount; i++) {
            if (this.emergencyVehicles[i].getId() == id){
                return true;
            }
        }
        return false;
    }

    private int getVehiclePos(int id){
        for (int i = 0; i < this.vehicleCount; i++) {
            if (this.emergencyVehicles[i].getId() == id){
                return i;
            }
        }
        return -1;
    }

    private void updateForAll(EmergencyVehicle vehicle, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
            if (manufacturer != null && !manufacturer.trim().isEmpty()){
                vehicle.setManufacturer(manufacturer);
            }

            if (incorporationDate != null){
                vehicle.setIncorporationDate(incorporationDate);
            }

            if (maxSpeed > 0){
                vehicle.setMaxSpeed(maxSpeed);
            }

            if (lastInspection != null){
                vehicle.setLastInspection(lastInspection);
            }

            if (nextInspection != null){
                vehicle.setNextInspection(nextInspection);
            }

            if (weight > 0){
                vehicle.setWeight(weight);
            }

            vehicle.setOparicional(isOparicional);
    }

    public void readForAll(int i){
        System.out.print(emergencyVehicles[i].getId());
        System.out.print(emergencyVehicles[i].getIncorporationDate());
        System.out.print(emergencyVehicles[i].getLastInspection());
        System.out.print(emergencyVehicles[i].getNextInspection());
        System.out.print(emergencyVehicles[i].getManufacturer()); 
        System.out.print(emergencyVehicles[i].getMaxSpeed());
        System.out.print(emergencyVehicles[i].getWeight());
        System.out.print("\n");
    }

    public void deleteVehicle(int id) throws VehicleNotFoundException{
        if (getVehicle(id)){
            int pos = getVehiclePos(id);

            for (int i = pos; i < this.vehicleCount-1; i++) {
                this.emergencyVehicles[i] = this.emergencyVehicles[i+1];
            }

            this.vehicleCount--;
            this.emergencyVehicles[this.vehicleCount] = null;

        } else {
            throw new VehicleNotFoundException("Erro: This vehicle is not available.");
        }
    }

    /*
    * Ambulance
    */

    public void createAmbulance(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        Ambulance ambulance = new Ambulance(this.idVehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        createForAll(ambulance);
    }

    public void readAmbulances(){
        for (int i = 0; i < this.vehicleCount; i++) {
            if ( this.emergencyVehicles[i].getType() == VehicleType.AMBULANCE){
                readForAll(i);
            }
        }
    }

    public void updateAmbulance(int id, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional) throws VehicleNotFoundException{
        if (getVehicle(id)){
            EmergencyVehicle vehicle = this.emergencyVehicles[getVehiclePos(id)];

            updateForAll(vehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        } else {
            throw new VehicleNotFoundException("Erro: This vehicle is not available.");
        }
    }


    /*
    * Medical Helicopter
    */

    public void createMedicalHelicopter(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        MedicalHelicopter helicopter = new MedicalHelicopter(this.idVehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        createForAll(helicopter);
    };

    public void readMedicalHelicopters(){
        for (int i = 0; i < this.vehicleCount; i++) {
            if ( this.emergencyVehicles[i].getType() == VehicleType.MEDICAL_HELICOPTER){
                readForAll(i);
            };
        };
    };

    public void updateMedicalHelicopter(int id, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional) throws VehicleNotFoundException{
        if (getVehicle(id)){
            EmergencyVehicle vehicle = this.emergencyVehicles[getVehiclePos(id)];

            updateForAll(vehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        } else {
            throw new VehicleNotFoundException("Erro: This vehicle is not available.");
        }
    }


    /**
     * Rapid response car
     */

    public void createRapidResponseCar(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        RapidResponseCar rapidResponseCar = new RapidResponseCar(this.idVehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        createForAll(rapidResponseCar);
    };

    public void readRapidResponseCars(){
        for (int i = 0; i < this.vehicleCount; i++) {
            if ( this.emergencyVehicles[i].getType() == VehicleType.RAPID_RESPONSE_CAR){
                readForAll(i);
            };
        };
    };

    public void updateRapidResponseCars(int id, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional) throws VehicleNotFoundException{
        if (getVehicle(id)){
            EmergencyVehicle vehicle = this.emergencyVehicles[getVehiclePos(id)];

            updateForAll(vehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        } else {
            throw new VehicleNotFoundException("Erro: This vehicle is not available.");
        }
    }
}
