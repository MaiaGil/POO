package Vehicles;
public class VehicleNotFoundException extends Exception {
    
    public VehicleNotFoundException(String message) {
        // A palavra 'super' chama o construtor da classe mãe (Exception)
        // e entrega-lhe a mensagem para ele tratar dela.
        super(message);
    }
}