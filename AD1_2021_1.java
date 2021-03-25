public class AD1_2021_1 {
    public static void main(String[] args) {
        Amigo fulano = new Amigo("Fulano");
        Amigo ciclano = new Amigo("Ciclano");
        Amigo beltrano = new Amigo("Beltrano");
        Rede paraiso = new Rede();
        paraiso.adicionarAmigo(fulano);
        paraiso.adicionarAmigo(ciclano);
        paraiso.adicionarAmigo(beltrano);
        Post bomdia = new Post("Bom dia!");
        Post boatarde = new Post("Boa tarde!");
        Post boanoite = new Post("Boa noite!");
        fulano.postar(bomdia);
        fulano.postar(boatarde);
        ciclano.postar(boanoite);
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
