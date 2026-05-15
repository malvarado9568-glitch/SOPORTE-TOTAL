public class TicketFactory {
    public static Ticket crearTicket(String tipo) {
        if (tipo.equalsIgnoreCase("Hardware")) {
            return new TicketHardware();
        }
        return null;
    }
}