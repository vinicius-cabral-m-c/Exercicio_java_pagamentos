package pagamento;

public class PagamentoCartao extends Pagamento {

    private String numeroCartao;
    private String nomeTitular;

    public PagamentoCartao(double valor, String numeroCartao, String nomeTitular) {
        super(valor);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    @Override
    public boolean processar() {
        if (valor > 5000) {
            System.out.println("Transação negada: Limite excedido");
            return false;
        }
        System.out.println("Aprovando cartão no banco...");
        return true;
    }
}