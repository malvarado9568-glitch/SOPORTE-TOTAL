import java.util.ArrayList;
import java.util.List;

public class GestorTickets {
    // Lista de observadores (Técnicos) a notificar
    private List<IObservador> observadores = new ArrayList<>();

    public void agregarObservador(IObservador observador) {
        observadores.add(observador);
    }

    public void notificarObservadores(String mensaje) {
        for (IObservador obs : observadores) {
            obs.actualizar(mensaje);
        }
    }

    public void crearNuevoTicket(String tipo) {
        System.out.println("\n=== SOLICITUD DE NUEVO TICKET ===");
        
        // Uso del Patrón Factory
        Ticket nuevoTicket = TicketFactory.crearTicket(tipo);
        
        if (nuevoTicket != null) {
            nuevoTicket.mostrarDetalles();
            // Uso del Patrón Observer
            notificarObservadores("Se ha creado un nuevo ticket de tipo " + tipo);
        } else {
            System.out.println("Error: Tipo de ticket no soportado.");
        }
    }

    // Método Main para probar el sistema
    public static void main(String[] args) {
        GestorTickets gestor = new GestorTickets();
        
        // Creamos técnicos (Observadores)
        Tecnico tecnico1 = new Tecnico("Ana Lopez");
        Tecnico tecnico2 = new Tecnico("Carlos Perez");
        
        // Suscribimos a los técnicos al gestor
        gestor.agregarObservador(tecnico1);
        gestor.agregarObservador(tecnico2);
        
        // Simulamos la creación de un ticket de hardware
        gestor.crearNuevoTicket("Hardware");
    }
}