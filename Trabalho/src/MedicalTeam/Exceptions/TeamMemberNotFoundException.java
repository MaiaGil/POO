package MedicalTeam.Exceptions;

public class TeamMemberNotFoundException extends Exception {
    public TeamMemberNotFoundException() {
        // A palavra 'super' chama o construtor da classe mãe (Exception)
        // e entrega-lhe a mensagem para ele tratar dela.
        super("Team member not found");
    }

}
