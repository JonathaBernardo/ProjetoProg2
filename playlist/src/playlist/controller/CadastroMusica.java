package playlist.controller;

import java.util.ArrayList;
import java.util.List;
import playlist.model.Musica;

public class CadastroMusica {

    private final List<Musica> musicaList;

    public CadastroMusica() {
        this.musicaList = new ArrayList<>();
    }

    public boolean adicionarMusica(Musica musica) {
        for (Musica m : musicaList) {
            if (m.getNome().equals(musica.getNome())) {
                System.out.println("Erro: A música já existe na lista.");
                return false;
            }
        }

        musicaList.add(musica);
        return true;
    }

    public List<Musica> listarMusicas() {
        if (!musicaList.isEmpty()) {
            return new ArrayList<>(musicaList);
        } else {
            System.out.println("Lista de músicas vazia.");
            return new ArrayList<>();
        }
    }

    public void atualizarMusica(String nomeAntigo, Musica novaMusica) {
        for (int i = 0; i < musicaList.size(); i++) {
            Musica musica = musicaList.get(i);
            if (musica.getNome().equals(nomeAntigo)) {
                musicaList.set(i, novaMusica);
                break;
            }
        }
    }

    public void removerMusica(String nome) {
        Musica musicaParaRemover = null;
        for (Musica musica : musicaList) {
            if (musica.getNome().equals(nome)) {
                musicaParaRemover = musica;
                break;
            }
        }

        if (musicaParaRemover != null) {
            musicaList.remove(musicaParaRemover);
        } else {
            System.out.println("Música não encontrada na lista.");
        }
    }

    public static void main(String[] args) {
        CadastroMusica cadastro = new CadastroMusica();

        Musica musica1 = new Musica("Amor Proibido", "Calcinha Preta", 2005, "Volume 2", "Forró");
        cadastro.adicionarMusica(musica1);

        Musica musica2 = new Musica("Another Song", "Artist Name", 2023, "Album Name", "Genre");
        cadastro.adicionarMusica(musica2);

        System.out.println("Lista de Músicas:");
        for (Musica musica : cadastro.listarMusicas()) {
            System.out.println(musica);
        }

        Musica novaMusica = new Musica("Nova Música", "Novo Artista", 2021, "Novo Álbum", "Novo Gênero");
        cadastro.atualizarMusica("Amor Proibido", novaMusica);

        System.out.println("\nLista de Músicas Após Atualização:");
        for (Musica musica : cadastro.listarMusicas()) {
            System.out.println(musica);
        }

        cadastro.removerMusica("Another Song");

        System.out.println("\nLista de Músicas Após Remoção:");
        for (Musica musica : cadastro.listarMusicas()) {
            System.out.println(musica);
        }
    }
}