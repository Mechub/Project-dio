import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import events.CustomEvent;
import facade.EventNotificationFacade;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean shouldRestart = true;
            while (shouldRestart) {
                EventNotificationFacade facade = new EventNotificationFacade();
                System.out.println("Bem-vindo! Coloque seu nome na lista:");

                List<String> guests = new ArrayList<>();
                int remainingGuests = 3;
                boolean showEventDetails = true;

                while (remainingGuests > 0) {
                    System.out.print("Digite seu nome: ");
                    String input = scanner.nextLine();

                    String message = input + ", venha comemorar comigo!";
                    System.out.println(message);

                    System.out.println("Confirme sua presença (Digite 'sim' ou 'nao'):");
                    String confirmation = scanner.nextLine();

                    if (confirmation.equalsIgnoreCase("sim")) {
                        if (remainingGuests > 0) {
                            System.out.println("Espero por você.");
                            remainingGuests--;
                            guests.add(input);
                        } else {
                            System.out.println("Você atingiu o limite de convidados confirmados.");
                        }
                    } else if (confirmation.equalsIgnoreCase("nao")) {
                        System.out.println("Talvez no próximo ano.");
                        showEventDetails = false;
                        break;
                    } else {
                        System.out.println("Opção inválida. Digite 'sim' para confirmar ou 'nao' para recusar.");
                    }

                    CustomEvent customEvent = new CustomEvent(input);
                    facade.notify(customEvent);
                }

                if (showEventDetails) {
                    System.out.println("Convidados confirmados:");
                    for (String guest : guests) {
                        System.out.println(guest);
                    }

                    System.out.println("Data do evento: 01/02/2024");
                    System.out.println("Local do evento: Casa de festas: Alegria&Felicidade");
                    System.out.println("Avenida nossa senhora da paz, 34");
                }

                System.out.println("Deseja reiniciar o programa? (Digite 'sim' para reiniciar ou 'nao' para encerrar)");
                String restartInput = scanner.nextLine();
                shouldRestart = restartInput.equalsIgnoreCase("sim");
            }
        }
    }
}