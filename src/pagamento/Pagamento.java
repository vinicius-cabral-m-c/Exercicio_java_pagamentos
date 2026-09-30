package pagamento;
import java.util.UUID;

public abstract class Pagamento {

    protected String idTransacao;
    protected double valor;
    protected String status;

    public Pagamento(double valor) {
        this.idTransacao = "TRX-" + UUID.randomUUID().toString();
        this.valor = valor;
        this.status = "PENDENTE";
    }

    public void imprimirRecibo() {
        System.out.println("ID da transacao: " + idTransacao);
        System.out.println("Valor: R$ " + String.format("%.2f", valor));
        System.out.println("Status: " + status);
    }

    public abstract boolean processar();

    public void setStatus(String status) {
        this.status = status;
    }
}