package com.company;

/**
 * CEDERJ
 * Curso Superior de Tecnologia em Sistemas de Computação
 * Disciplina: Programação Orientada a Objetos
 * AD1 2021.1
 * Aluno: Daniel Gustavo Braz Rocha   Matricula:20113050368    Polo:Pirai
 */

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

    /**
     * Métodos da classe Post
     */

    //Método para receber curtida, atualizando o contador e o array dos amigos que curtiram o post
    public void recebeCurtida(Amigo a) {
        this.quemCurtiu[qtdCurtidas] = a;
        this.qtdCurtidas++;
    }

    //Método para retornar a quantidade de curtidas do Post
    public int getLikes() {
        return this.qtdCurtidas;
    }

    //Método para retornar uma String com o nome dos que curtiram o Post, separados por espaço
    public String retornaNomesQueCurtiram() {
        String retorno = "";
        for (Amigo a: quemCurtiu) {
            if (a != null) {
                retorno = retorno + a.getAmigoNome() + " ";
            }
            else {
                break;
            }
        }
        return retorno + "\n";
        //Verificar impressão se com o nome apenas ou se todos os dados de amigo
    }

    // Método que retorna um resumo com os posts (para concatenação)
    public String getPostsInline() {
        return this.textoPost + ": " + this.qtdCurtidas + " curtidas";
    }

    // Método que retorna a String de representação da classe Post
    public String toString() {
        return this.textoPost + ": " + this.qtdCurtidas + " curtidas" + "\n";
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

    /**
     * Métodos da classe Amigo
     */

    //Método para um Amigo postar um Post
    public void postar(Post p) {
        this.meusPosts[qtdPosts] = p;
        this.qtdPosts++;
        //System.out.println(this.nome + "postou o post" + p );

    }

    //Método para um Amigo curtir um Post
    public void curtir(Post p) {
        p.recebeCurtida(this);
        //System.out.println(this.nome + "curtiu o post" + p );
    }

    //Método para retornar o Post que tenha o maior número de curtidas
    public Post retornaPostMaisCurtido() {
        Post retorno = null;
        int maior = 0;
        for (Post p: meusPosts) {
            if (p != null) {
                if (p.getLikes() > maior)
                    retorno = p;
            } else {
                break;
            }
        }
        return retorno;
    }

    //Método para retornar o nome do Amigo
    public String getAmigoNome() {
        return this.nome;
    }

    // Método que retorna a String de representação da classe Amigo (usado para a timeline)
    public String toString() {
        if (this.qtdPosts != 0) {
            String retorno = this.nome + " :" + "\n";
            for (Post p: meusPosts)
                if (p != null){
                    retorno = retorno + p.getPostsInline() + "\n";
                }
                else {
                    break;
                }
            return retorno;
        }
        else {
            return this.nome + " :" + "\n";
        }
    }
}

class Rede {
    //Atributos da classe Rede
    private int qtdAmigos;
    private Amigo amigosNaRede[];
    private static short MAX_FRIENDS = 1000;

    //Construtor da classe Rede
    public Rede() {
        this.amigosNaRede = new Amigo[MAX_FRIENDS];
        this.qtdAmigos = 0;
    }

    /**
     * Métodos da classe Rede
     */

    //Método para adicionar Amigo a Rede
    public void adicionarAmigo(Amigo a) {
        this.amigosNaRede[qtdAmigos] = a;
        this.qtdAmigos++;
        //System.out.println(a.getAmigoNome() + " foi adicionado a rede");
    }

    //Método que imprime a timeline da classe
    public String timeline() {
        String retorno = "";
        for (Amigo a: amigosNaRede) {
            if (a != null){
                retorno = retorno + a;
            }
            else {
                break;
            }
        }
        return retorno;
    }

    // Método que retorna a String de representação da classe Post
}


class testePrint {

    public static void main(String[] args) {
        Amigo fulano = new Amigo("Fulano");
        Amigo ciclano = new Amigo("Ciclano");
        Amigo beltrano = new Amigo("Beltrano");
        Amigo outrano = new Amigo("Outrano");
        Rede paraiso = new Rede();
        paraiso.adicionarAmigo(fulano);
        paraiso.adicionarAmigo(ciclano);
        paraiso.adicionarAmigo(beltrano);
        Post bomdia = new Post("Bom dia!");
        Post boatarde = new Post("Boa tarde!");
        Post boanoite = new Post("Boa noite!");
        Post helloworld = new Post("Hello World!");
        Post olatodos = new Post("Olá Todos!");
        fulano.postar(bomdia);
        fulano.postar(boatarde);
        ciclano.postar(boanoite);
        ciclano.postar(olatodos);
        ciclano.postar(helloworld);
        beltrano.curtir(helloworld);
        fulano.curtir(helloworld);
        outrano.curtir(helloworld);
        beltrano.curtir(bomdia);
        beltrano.curtir(boatarde);
        beltrano.curtir(boanoite);
        fulano.curtir(boanoite);
        System.out.println("Timeline:");
        System.out.println(paraiso.timeline());
        System.out.println("Post mais curtido de um usuário:");
        Post maiscurtido = ciclano.retornaPostMaisCurtido();
        System.out.println(maiscurtido);
        System.out.println("Quem curtiu: " +
                maiscurtido.retornaNomesQueCurtiram());

    }
}
