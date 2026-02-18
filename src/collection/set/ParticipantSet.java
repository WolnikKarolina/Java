package collection.set;

import java.util.HashSet;
import java.util.Set;

public class ParticipantSet {
    public static void main(String[] args) {

        Set<Participant> participants = new HashSet<>();
        participants.add(new Participant("Karolina", Participant.Priority.HIGH, 1));
        participants.add(new Participant("Basia", Participant.Priority.MODERATE, 2));
        participants.add(new Participant("Aneta", Participant.Priority.HIGH, 3));
        participants.add(new Participant("Karolina", Participant.Priority.HIGH, 4));

        for (Participant participant : participants) {
            System.out.println(participant);

        }

    }
}
