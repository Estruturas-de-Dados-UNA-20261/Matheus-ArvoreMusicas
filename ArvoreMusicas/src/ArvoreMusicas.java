public class ArvoreMusicas {

    private No raiz;

    public void inserir(Musica musica) {

        raiz = inserirRec(raiz, musica);
    }

    private No inserirRec(No raiz, Musica musica) {

        if (raiz == null) {

            return new No(musica);
        }

        if (musica.getId() < raiz.musica.getId()) {

            raiz.esquerda = inserirRec(raiz.esquerda, musica);
        }

        else if (musica.getId() > raiz.musica.getId()) {

            raiz.direita = inserirRec(raiz.direita, musica);
        }

        return raiz;
    }

    public Musica buscar(int id) {

        No resultado = buscarRec(raiz, id);

        if (resultado != null) {

            return resultado.musica;
        }

        return null;
    }

    private No buscarRec(No raiz, int id) {

        if (raiz == null || raiz.musica.getId() == id) {

            return raiz;
        }

        if (id < raiz.musica.getId()) {

            return buscarRec(raiz.esquerda, id);
        }

        return buscarRec(raiz.direita, id);
    }

    public void exibirEmOrdem() {

        exibirRec(raiz);
    }

    private void exibirRec(No raiz) {

        if (raiz != null) {

            exibirRec(raiz.esquerda);

            System.out.println(raiz.musica);

            exibirRec(raiz.direita);
        }
    }
}