/*
Q4 — Lei de Demeter (leve)
Dado usuario.getEndereco().cidade(), reescreva um método em Usuario
que devolva a cidade sem o main conhecer Endereco. Explique por que
isso ajuda quando Endereco ganhar, por exemplo, um campo bairro.
*/

class Endereco {
    private String cidade;
    private String bairro;

    Endereco(String cidade, String bairro) {
        this.cidade = cidade;
        this.bairro = bairro;
    }

    String cidade() {
        return cidade;
    }

    String bairro() {
        return bairro;
    }
}

class Usuario {
    private String nome;
    private Endereco endereco;

    Usuario(String nome, String cidade, String bairro) {
        this.nome = nome;
        this.endereco = new Endereco(cidade, bairro);
    }

    String getNome() {
        return nome;
    }

    // Em vez de usuario.getEndereco().cidade():
    String cidade() {
        return endereco.cidade();
    }

    String enderecoFormatado() {
        return endereco.cidade() + " — " + endereco.bairro();
    }
}

void main() {
    var usuario = new Usuario("Ana", "Conquista", "Centro");

    // O main fala só com Usuario. Não há getEndereco().
    IO.println(usuario.getNome() + " mora em " + usuario.cidade());
    IO.println(usuario.enderecoFormatado());

    // Por que ajuda se Endereco ganhar bairro (ou mudar o formato)?
    // A cadeia usuario.getEndereco().cidade() espalha a estrutura:
    // o main passa a conhecer Endereco e, na próxima mudança, todo
    // cliente faria getEndereco().bairro() ou montaria a string.
    // Com cidade() / enderecoFormatado() em Usuario, só um método
    // muda quando Endereco ganha campo ou deixa de ser record.
    // O main continua igual — Lei de Demeter: não atravessar o
    // objeto interno.
}
