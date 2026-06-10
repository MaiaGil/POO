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

    /**
     * Funções gerais
     */

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

    public void deleteVehicle(int id){
        if (getVehicle(id)){
            int pos = getVehiclePos(id);

            for (int i = pos; i < this.vehicleCount-1; i++) {
                this.emergencyVehicles[i] = this.emergencyVehicles[i+1];
            }

            this.vehicleCount--;
            this.emergencyVehicles[this.vehicleCount] = null;

        } else {
            System.out.println("This vehicle is not in the list");
        }
    }


    /*
    * Ambulance
    */

    public void createAmbulance(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        Ambulance ambulance = new Ambulance(this.idVehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        if (this.emergencyVehicles.length == this.vehicleCount){
            maxVehicles();
        }
        
        this.emergencyVehicles[this.vehicleCount] = ambulance; 
        this.vehicleCount++;
        this.idVehicle++;
    }

    public void readAmbulances(){
        for (int i = 0; i < this.vehicleCount; i++) {
            if ( this.emergencyVehicles[i].getType() == VehicleType.AMBULANCE){
                readForAll(i);
            }
        }
    }

    public void updateAmbulance(int id, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        if (getVehicle(id)){
            EmergencyVehicle vehicle = this.emergencyVehicles[getVehiclePos(id)];

            updateForAll(vehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        } else {
            System.out.println("This vehicle is not in the list");
        }
    }


    /*
    * Medical Helicopter
    */

    public void createMedicalHelicopter(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        MedicalHelicopter helicopter = new MedicalHelicopter(this.idVehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        if (this.emergencyVehicles.length == this.vehicleCount){
            maxVehicles();
        }
        
        this.emergencyVehicles[this.vehicleCount] = helicopter; 
        this.vehicleCount++;
        this.idVehicle++;

    };

    public void readMedicalHelicopters(){
        for (int i = 0; i < this.vehicleCount; i++) {
            if ( this.emergencyVehicles[i].getType() == VehicleType.MEDICAL_HELICOPTER){
                readForAll(i);
            };
        };
    };


    /**
     * Rapid response car
     */

    public void createRapidResponseCar(String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional){
        RapidResponseCar rapidResponseCar = new RapidResponseCar(this.idVehicle, manufacturer, incorporationDate, maxSpeed, lastInspection, nextInspection, weight, isOparicional);

        if (this.emergencyVehicles.length == this.vehicleCount){
            maxVehicles();
        }
        
        this.emergencyVehicles[this.vehicleCount] = rapidResponseCar; 
        this.vehicleCount++;
        this.idVehicle++;
    };

    public void readRapidResponseCars(){
        for (int i = 0; i < this.vehicleCount; i++) {
            if ( this.emergencyVehicles[i].getType() == VehicleType.RAPID_RESPONSE_CAR){
                readForAll(i);
            };
        };
    };
}
