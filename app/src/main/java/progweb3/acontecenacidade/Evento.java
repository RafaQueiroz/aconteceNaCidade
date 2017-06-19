package progweb3.acontecenacidade;

import java.util.Date;
import java.util.Random;

/**
 * Created by KOSMOS00 on 17/05/2017.
 */

public class Evento {
    private String nome;
    private String descricao;
    private Endereco endereco;
    private Date dtInicio;
    private Date dtFim;
    private int idImagem;
    private boolean pgto;
    private double valor;

    public Evento(String nome, String descricao, Endereco endereco, Date dtInicio, Date dtFim, int idImagem, boolean pgto, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.idImagem = idImagem;
        this.pgto = pgto;
        this.valor = valor;
    }

    public Evento(String nome, Date data, int imagen) {
        this.nome = nome;
        this.dtInicio = data;
        this.idImagem = imagen;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public boolean isPgto() {
        return pgto;
    }

    public void setPgto(boolean pgto) {
        this.pgto = pgto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", dtInicio=" + dtInicio +
                ", idImagem=" + idImagem +
                '}';
    }

    private static String nomes[] = {"Evento 1", "Evento 2", "Evento 3"};
    private static Date myDate = new Date();
    private static Date datas[] = { myDate, myDate, myDate};
    private static int imagens[] = {1,2,3};

    public static Evento carrega() {
        return new Evento(nomes[getRandomValue(0, 2)],
                datas[getRandomValue(0, 2)],  imagens[getRandomValue(0, 2)]);
    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
}


