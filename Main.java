import java.util.*;

public class Main {
    public static void main() {
        ArrayList<Album> albumes = new ArrayList<Album>();
        Album citiOfEvil = new Album("citiOfEvil", "Avenged Sevenfold");
        Album MasterOfPuppets = new Album("MasterOfPuppets", "Metallica");
        albumes.add(citiOfEvil);
        albumes.add(MasterOfPuppets);

        citiOfEvil.addSong("Beast and the Harlot", 5.44);
        citiOfEvil.addSong("Burt it Down", 4.59);
        citiOfEvil.addSong("Blinded in Chains", 6.34);
        citiOfEvil.addSong("Bat Country", 5.12);
        citiOfEvil.addSong("Trashed and Scattered", 5.52);
        citiOfEvil.addSong("Seize the Day", 5.34);
        citiOfEvil.addSong("Sidewinder", 7.02);
        citiOfEvil.addSong("The Wicked End", 7.10);
        citiOfEvil.addSong("Strength of the World", 9.15);
        citiOfEvil.addSong("Betrayed", 6.46);
        citiOfEvil.addSong("M.I.A", 8.46);

        MasterOfPuppets.addSong("Battery", 5.12);
        MasterOfPuppets.addSong("Master of Puppets", 8.35);
        MasterOfPuppets.addSong("The Thing That Should Not Be", 6.36);
        MasterOfPuppets.addSong("Welcome Home (Sanitarium)", 6.27);
        MasterOfPuppets.addSong("Disposable Heroes", 8.17);
        MasterOfPuppets.addSong("Leper Messiah", 5.40);
        MasterOfPuppets.addSong("Orion", 8.27);
        MasterOfPuppets.addSong("Damage, Inc", 5.32);

        LinkedList<Cancion> listaReproduccion = new LinkedList<Cancion>();

        citiOfEvil.addToPlaylist(4, listaReproduccion);
        citiOfEvil.addToPlaylist("M.I.A", listaReproduccion);
        MasterOfPuppets.addToPlaylist(2, listaReproduccion);
        MasterOfPuppets.addToPlaylist("Orion", listaReproduccion);
        citiOfEvil.addToPlaylist("Sidewinder", listaReproduccion);
        citiOfEvil.addToPlaylist("Seize the Day", listaReproduccion);

        play(listaReproduccion);




    }

    public static void play(LinkedList<Cancion> listaReproduccion) {
        ListIterator<Cancion> lista = listaReproduccion.listIterator();

        Scanner scan = new Scanner(System.in);

        imprimirMenu();
        int opcion = 0;
        boolean paraDelante = true;
        do {

            try {

                int tamanyoLista = listaReproduccion.size();


                if (lista.hasNext()) {
                    Cancion actual = lista.next();
                    System.out.println("\nAhora está sonando: " + actual.titulo + "\n");
                    lista.previous();
                } else if (lista.hasPrevious()){
                    Cancion actual = lista.previous();
                    System.out.println("\nAhora está sonando: " + actual.titulo + "\n");
                    lista.next();
                }

                System.out.printf("Escribe la opción: ");
                opcion = scan.nextInt();

                if (opcion < 0 || opcion > 6) {
                    opcion = 5;
                }

                switch (opcion) {

                    case 0 -> {
                        System.out.println("Sales de la lista");
                    }

                    case 1 -> {
                        if (tamanyoLista > 1) {
                            if (paraDelante) {
                                if (lista.hasNext()) {
                                    lista.next();
                                    if (!lista.hasNext()) {
                                        lista.previous();
                                        System.out.println("Ya no hay más canciones");
                                    }
                                }
                            }
                            if (!paraDelante) {
                                if (lista.hasPrevious()) {
                                    lista.previous();
                                } else {
                                    System.out.println("Ya no hay más canciones");
                                }
                            }

                        }
                    }

                    case 2 -> {
                        if (tamanyoLista > 1) {
                            if (paraDelante) {
                                if (lista.hasPrevious()) {
                                    lista.previous();

                                } else {
                                    System.out.println("Ya no hay más canciones");
                                }
                            }
                            if (!paraDelante) {
                                if (lista.hasNext()) {
                                    lista.next();
                                    if (!lista.hasNext()) {
                                        lista.previous();
                                        System.out.println("Ya no hay más canciones");

                                    }
                                }
                            }

                        }
                    }

                    case 3 -> System.out.println("\nSe repite la canción");

                    case  4 -> {
                        imprimirLista(listaReproduccion);
                    }

                    case 5 -> imprimirMenu();

                    case 6 -> {
                        if (tamanyoLista == 1) {
                            throw new Exception();
                        }
                        if (lista.hasPrevious()) {
                            lista.remove();
                            System.out.println("Se ha borrado la canción");
                            lista.previous();
                        } else {
                            lista.remove();
                            System.out.println("Se ha borrado la canción");
                            lista.next();
                        }

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Solo números del 0 al 6");
            } catch (NoSuchElementException e) {
                System.out.println("No hay más canciones");
                opcion = 5;
            } catch (Exception e) {
                System.out.println("Sales del sistema");
                break;
            }
        } while (opcion != 0);

    }

    public static void imprimirLista(LinkedList<Cancion> listaReproduccion) {
        ListIterator<Cancion> lista = listaReproduccion.listIterator();
        while (lista.hasNext()) {
            System.out.println(lista.next());
        }
    }

    public static void imprimirMenu() {
        System.out.println("Este es el menú de opciones: ");
        System.out.println("0. Salir de la lista de reproducción.");
        System.out.println("1. Reproducir siguiente canción en la lista.");
        System.out.println("2. Reproducir la canción previa de la lista.");
        System.out.println("3. Repetir la canción actual.");
        System.out.println("4. Imprimir la lista de canciones en la playlist.");
        System.out.println("5. Volver a imprimir el menú.");
        System.out.println("6. Eliminar canción de la lista.");

    }
}
