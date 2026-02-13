import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static void main() {
        ArrayList<Album> albumes = new ArrayList<Album>();
        Album citiOfEvil = new Album("citiOfEvil", "Avenged Sevenfold");
        Album album2 = new Album("Walking the fallen", "Avenged sevenfold");
        albumes.add(citiOfEvil);
        albumes.add(album2);

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

        citiOfEvil.addSong("Under a glass moon", 7.03);

        album2.addSong("Unholy confessions", 4.44);
        album2.addSong("Remenissions", 6.07);
        album2.addSong("Second Heartbeat", 7.00);



        LinkedList<Cancion> listaReproduccion = new LinkedList<Cancion>();
        album1.addToPlaylist(1, listaReproduccion);
        album2.addToPlaylist(2, listaReproduccion);
        album2.addToPlaylist("Unholy confessions", listaReproduccion);
    }
}
