package progweb3.acontecenacidade;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import progweb3.acontecenacidade.modelo.Usuario;

/**
 * Created by KOSMOS00 on 17/05/2017.
 */

public class Evento {
    private Long id;
    private String nome;
    private String descricao;
    private String endereco;
    private Calendar dtInicio;
    private Calendar dtFim;
    private int idImagem;
    private boolean pgto;
    private double valor;
    private Usuario proprietario;

    public Evento(){};

    public Evento(String nome, String descricao, String endereco, Calendar dtInicio,
                  Calendar dtFim, boolean pgto, double valor) {

        this.nome = nome;
        this.descricao = descricao;
        this.endereco = endereco;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.pgto = pgto;
        this.valor = valor;
    }

    public Evento(String nome, Calendar data, int idImagem){
        this.nome = nome;
        this.dtInicio = data;
        this.idImagem = idImagem;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Calendar getDtInicio() {

        return dtInicio;
    }

    public void setDtInicio(Calendar dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Calendar getDtFim() {
        return dtFim;
    }

    public void setDtFim(Calendar dtFim) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Usuario proprietario) {
        this.proprietario = proprietario;
    }

    private static String nomes[] = {"Evento 1", "Evento 2", "Evento 3"};
    private static Calendar datas[] = {Calendar.getInstance(),
            Calendar.getInstance(), Calendar.getInstance()};

    private static int imagens[] = {1,2,3};


    public static Evento carrega() {
        return new Evento(nomes[getRandomValue(0, 3)], datas[getRandomValue(0, 3)], imagens[getRandomValue(0, 3)]);
    }

    private static int getRandomValue(int low, int high) {
        return new Random().nextInt(high - low) + low;
    }
}


