package com.company;

import java.util.Arrays;

class Post {
    //Atributos da classe Post
    private String textoPost;
    private Amigo quemCurtiu[];
    private int qtdCurtidas;

    //Construtor da classe Post
    public Post(String textoPost) {
        this.textoPost = textoPost;
        this.qtdCurtidas = 0;
    }

    //Funcao para receber curtida, atualizando o contador e o array dos amigos que curtiram o post
    public void recebeCurtida(Amigo a) {
        this.quemCurtiu[qtdCurtidas] = a;
        this.qtdCurtidas++;
    }

    public String retornaNomesQueCurtiram() {
        String retorno = null;
        for (Amigo a: quemCurtiu)
            if (a != null)
                retorno = retorno + a;
            else
                break;
        return retorno + "\n";
        //Verificar impressão se com o nome apenas ou se todos os dados de amigo
    }

    // Retorno da classe
    public String toString() {
        return this.textoPost + ": " + this.qtdCurtidas + " curtidas";
    }

}
class Amigo {
    //Atributos da classe Amigo
    private String nome;

    //Construtor da classe Amigo
    public Amigo(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome;
    }

    public String postar(Post p) {
        //p.
        return null;
    }

    public String curtir(Post p) {
        //p.
        return null;
    }
}

class Rede {
    private int qtdAmigos;

    //Construtor da classe
    public Rede() {

    }
}


class testePrint {

    public static void main(String[] args) {
        Amigo fulano = new Amigo("Fulano");
        System.out.println(fulano);
    }
}
