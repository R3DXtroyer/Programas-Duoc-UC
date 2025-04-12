package exp_s5_rene_alfaro;
import java.util.Scanner;

public class Exp_s5_Rene_Alfaro {
    //variables estaticas
    private static final double DESCUENTO_ESTUDIANTE = 10.0;
    private static final double DESCUENTO_ADULTO_MAYOR = 15.0;
    private static final double PRECIO_BASE_VIP = 100000.0;
    private static final double PRECIO_BASE_PLATEA = 70000.0;
    private static final double PRECIO_BASE_GENERAL = 50000.0;
    private static double ingresosTotales = 0.0;
    private static int totalEntradasVendidas = 0;
    
    //Variables de instancia para una entrada
    private int numeroEntrada;
    private String ubicacionEntrada;
    private double precioFinalEntrada;
    
    public static void main(String[] args){
        Exp_s5_Rene_Alfaro teatro = new Exp_s5_Rene_Alfaro();
        teatro.mostrarMenu();
    }
    
    //Metodo para mostrar el menu
    public void mostrarMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;
            
            while (!salir) {
                System.out.println ("\n");
                System.out.println ("1. Venta de entradas");
                System.out.println ("2. Promociones");
                System.out.println ("3. Busqueda de entradas");
                System.out.println ("4. Eliminacion de entradas");
                System.out.println ("5. Salir");
                System.out.println ("Seleccione una opcion: ");
                
                int opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        venderEntrada(scanner);
                        break;
                    case 2:
                        mostrarPromociones();
                        break;
                    case 3:
                        buscarEntrada(scanner);
                        break;
                    case 4:
                        eliminarEntrada(scanner);
                        break;
                    case 5:
                        System.out.println ("Gracias por usar el sistema del Teatro Moro!");
                        salir = true;
                        break;
                    default:
                        System.out.println ("Opcion no valida.porfavor intente nuevamente");
                }
            }
        }
    }
    
    //Metodo para vender una entrada
    private void venderEntrada(Scanner scanner) {
        System.out.println ("\nPlano del Teatro");
        System.out.println ("a) Zona Vip: $100000");
        System.out.println ("b) Zona Platea: $70000");
        System.out.println ("c) Zona General: $50000");
        System.out.println ("seleccione su ubicacion (A, B, C):");
        char zona = scanner.next().toUpperCase().charAt(0);
        int precioBase = 0;
        
        System.out.print("Eres estudiante? (s/n): ");
        String respuestaEstudiante = scanner.next();
        boolean estudiante = respuestaEstudiante.equalsIgnoreCase("s");
    
        System.out.println ("Eres adulto mayor? (s/n): ");
        String respuestaAdultoMayor = scanner.next();
        boolean adultoMayor = respuestaAdultoMayor.equalsIgnoreCase("s");
    
        double descuento = calcularDescuento(estudiante, adultoMayor);
        precioFinalEntrada = precioBase - (precioBase * descuento / 100);
    
        numeroEntrada++;
        totalEntradasVendidas++;
        ingresosTotales += precioFinalEntrada;
        
        System.out.println ("Entrada vendida: Numero " + numeroEntrada + ", Ubicacion " + ubicacionEntrada +
                ",Precio Final: $" + precioFinalEntrada);
    }
    
    //Metodo para determinar el precio base segun la ubicacion
    private double determinarPrecioBase(String ubicacion) {
        switch (ubicacion.toLowerCase()) {
            case "vip":
                return PRECIO_BASE_VIP;
            case "platea":
                return PRECIO_BASE_PLATEA;
            case "general":
                return PRECIO_BASE_GENERAL;
            default:
                System.out.println ("ubicacion no valida. se asignara el precio base General.");
                return PRECIO_BASE_GENERAL; 
        }
    }
    
    //Metodo para calcular el descuento
    private double calcularDescuento (boolean estudiante, boolean adultoMayor) {
        if (adultoMayor) {
            return DESCUENTO_ADULTO_MAYOR;
        } else if (estudiante) {
            return DESCUENTO_ESTUDIANTE;
        } else {
            return 0.0;
        }
    }
    
    // Metodo para mostrar promociones
    private void mostrarPromociones() {
        System.out.println ("\n Promociones");
        System.out.println ("1. descuento del 10% para estudiantes.");
        System.out.println ("2. descuento del 15% para adultos mayores.");
        System.out.println ("3. compra de multiples entradas: Consulta en taquilla!");
    }

    // Metodo para buscar una entrada
    private void buscarEntrada (Scanner scanner) {
        System.out.print ("Ingrese el numero de la entrada a buscar: ");
        int numeroBuscado = scanner.nextInt();
        
        if (numeroBuscado == numeroEntrada) {
            System.out.println ("Entrada encontra: Numero " + numeroEntrada + ", Ubicacion: " + ubicacionEntrada +
                    ", Precio Final: $" + precioFinalEntrada);
        } else {
            System.out.println ("no se encontro ninguna entrada con el numero proporcionado.");
        }
    }

    // Metodo para eliminar una entrada
    private void eliminarEntrada (Scanner scanner) {
        System.out.print ("Ingrese el numero de la entrada a eliminar: ");
        int numeroEliminar = scanner.nextInt();
        
        if (numeroEliminar == numeroEntrada) {
            numeroEntrada = 0;
            ubicacionEntrada = null;
            precioFinalEntrada = 0.0;
            System.out.println ("Entrada eliminada correctamente.");
        } else {
            System.out.println ("no se encontro ninguna entrada con el numero proporcionado.");
        }
    }
}
