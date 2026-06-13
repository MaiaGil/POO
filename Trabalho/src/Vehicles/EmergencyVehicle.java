package Vehicles;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class EmergencyVehicle implements Serializable {
   private String manufacturer;
   private LocalDate incorporationDate;
   private LocalDate lastInspection;
   private LocalDate nextInspection;
   private double weight;
   private double maxSpeed;
   private boolean isOparicional;
   private int id;
   private VehicleType type;

   public EmergencyVehicle(int id, String manufacturer, LocalDate incorporationDate, double maxSpeed, LocalDate lastInspection, LocalDate nextInspection, double weight, boolean isOparicional, VehicleType type) {
      this.manufacturer = manufacturer;
      this.incorporationDate = incorporationDate;
      this.maxSpeed = maxSpeed;
      this.lastInspection = lastInspection;
      this.nextInspection = nextInspection;
      this.weight = weight;
      this.isOparicional = isOparicional;
      this.id = id;
      this.type = type;
   }

   @Override //Feito com AI
    public boolean equals(Object obj) {
        // 1. Otimização: Somos literalmente a mesma peça na memória?
        if (this == obj) {
            return true;
        }
        
        // 2. Proteção: O objeto que me passaram está vazio ou é de uma classe diferente?
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        
        // 3. Cast: Como já sabemos que o 'obj' é um EmergencyVehicle, fazemos o Cast
        EmergencyVehicle outroVeiculo = (EmergencyVehicle) obj;
        
        // 4. A Comparação Real: Dois veículos são iguais se tiverem o mesmo ID
        return this.id == outroVeiculo.id;
    }

   public String getManufacturer() {
      return this.manufacturer;
   }

   public LocalDate getIncorporationDate() {
      return this.incorporationDate;
   }

   public double getMaxSpeed() {
      return this.maxSpeed;
   }

   public LocalDate getLastInspection() {
      return lastInspection;
   }

   public LocalDate getNextInspection() {
      return nextInspection;
   }

   public double getWeight() {
      return weight;
   }

   public boolean isOparicional() {
      return isOparicional;
   }

   public int getId(){
      return this.id;
   }

   public VehicleType getType(){
      return this.type;
   }

   public void setManufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
   }

   public void setIncorporationDate(LocalDate incorporationDate) {
      this.incorporationDate = incorporationDate;
   }

   public void setLastInspection(LocalDate lastInspection) {
      this.lastInspection = lastInspection;
   }

   public void setNextInspection(LocalDate nextInspection) {
      this.nextInspection = nextInspection;
   }

   public void setWeight(double weight) {
      this.weight = weight;
   }

   public void setMaxSpeed(double maxSpeed) {
      this.maxSpeed = maxSpeed;
   }

   public void setOparicional(boolean isOparicional) {
      this.isOparicional = isOparicional;
   }

}