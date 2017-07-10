package progweb3.acontecenacidade.modelo;

import com.google.gson.Gson;

public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private Boolean logado;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getLogado() {
        return logado;
    }
    public void setLogado(Boolean logado) {
        this.logado = logado;
    }
}
