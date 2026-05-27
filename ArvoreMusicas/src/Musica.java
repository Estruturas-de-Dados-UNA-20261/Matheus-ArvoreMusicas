public class Musica {

    private int id;
    private String nome;
    private String artista;

    public Musica(int id, String nome, String artista) {
        this.id = id;
        this.nome = nome;
        this.artista = artista;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Nome: " + nome +
               " | Artista: " + artista;
    }
}