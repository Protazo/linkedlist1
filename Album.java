import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String nombre;
    String artista;
    ArrayList<Cancion> canciones = new ArrayList<Cancion>();

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
    }

    private Cancion findSong(String titulo) {
        for (Cancion cancion : canciones) {
            if (titulo.equals(cancion.getTitulo())) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion) {

        if (findSong(titulo) == null) {
            Cancion nuevaCancion = new Cancion(titulo, duracion);
            canciones.add(nuevaCancion);
            return true;
        } else {
            return false;
        }

    }

    public boolean addToPlaylist(int numeroPista, LinkedList<Cancion> linkedlist) {
        if (canciones.get(numeroPista) != null) {
            linkedlist.add(canciones.get(numeroPista));
            return true;
        }
        return false;
    }

    public boolean addToPlaylist(String titulo, LinkedList<Cancion> linkedlist) {

        if (findSong(titulo) != null) {
            linkedlist.add(findSong(titulo));
            return true;
        }
        return false;
    }

}
