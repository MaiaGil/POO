package MedicalTeam.Exceptions;

public class TeamNeedsDoctorException extends Exception{

    public TeamNeedsDoctorException() {
        // A palavra 'super' chama o construtor da classe mãe (Exception)
        // e entrega-lhe a mensagem para ele tratar dela.
        super("Team needs a Doctor");
    }
}
