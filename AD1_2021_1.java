package com.company;

class Post {
    //Atributos da classe Post
    private String textoPost;
    private Amigo quemCurtiu[];
    private int qtdCurtidas;
    private static short MAX_CURTIDAS = 100;

    //Construtor da classe Post
    public Post(String textoPost) {
        this.textoPost = textoPost;
        this.qtdCurtidas = 0;
        this.quemCurtiu = new Amigo[MAX_CURTIDAS];
    }

    //Funcao para receber curtida, atualizando o contador e o array dos amigos que curtiram o post
    public void recebeCurtida(Amigo a) {
        this.quemCurtiu[qtdCurtidas] = a;
        this.qtdCurtidas++;
    }

    //Função para retornar a quantidade de curtidas do Post
    public int getLikes() {
        return this.qtdCurtidas;
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
    private Post meusPosts[];
    private int qtdPosts;
    private static short MAX_POSTS = 100;

    //Construtor da classe Amigo
    public Amigo(String nome) {
        this.nome = nome;
        this.qtdPosts = 0;
        this.meusPosts = new Post[MAX_POSTS];
    }

    public void postar(Post p) {
        this.meusPosts[qtdPosts] = p;
        this.qtdPosts++;
        System.out.println(this.nome + "postou o post" + p );

    }

    public void curtir(Post p) {
        p.recebeCurtida(this);
        System.out.println(this.nome + "curtiu o post" + p );
    }

    public Post retornaPostMaisCurtido() {
        Post retorno = null;
        int maior = 0;
        for (Post p: meusPosts)
            if (p.getLikes() > maior)
                retorno = p;
        return retorno;
        //Verificar o retorno se está correto
    }

    public String toString() {
        return "Meu nome é" + this.nome + ", e tenho " + this.qtdPosts;
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
