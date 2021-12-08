import com.itextpdf.awt.geom.misc.HashCode;

public class Produto {

    private HashCode codigo;
    private Long quantidadeMinima;
    private String tipo;

    public Produto() {
    }

    public Produto(HashCode codigo, Long quantidadeMinima, String tipo) {
        this.codigo = codigo;
        this.quantidadeMinima = quantidadeMinima;
        this.tipo = tipo;
    }

    public HashCode getCodigo() {
        return codigo;
    }

    public void setCodigo(HashCode codigo) {
        this.codigo = codigo;
    }

    public Long getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Long quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
