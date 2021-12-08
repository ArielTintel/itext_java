public class Indicador {

    private String nomeIndicador;
    private Long objetivo;
    private String tipo;
    private String tipoPremiacao;

    public Indicador() {
    }

    public Indicador(String nomeIndicador, Long objetivo, String tipo, String tipoPremiacao) {
        this.nomeIndicador = nomeIndicador;
        this.objetivo = objetivo;
        this.tipo = tipo;
        this.tipoPremiacao = tipoPremiacao;
    }

    public String getNomeIndicador() {
        return nomeIndicador;
    }

    public void setNomeIndicador(String nomeIndicador) {
        this.nomeIndicador = nomeIndicador;
    }

    public Long getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Long objetivo) {
        this.objetivo = objetivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoPremiacao() {
        return tipoPremiacao;
    }

    public void setTipoPremiacao(String tipoPremiacao) {
        this.tipoPremiacao = tipoPremiacao;
    }


}
