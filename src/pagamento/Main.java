package pagamento;
public class Main {
 
    public static void main(String[] args) {
        GatewayPagamento gateway = new GatewayPagamento();
 
        PagamentoPix pix = new PagamentoPix(150.00, "email@exemplo.com");
        PagamentoCartao cartao = new PagamentoCartao(6000.00, "1234 5678 9012 3456", "Joao Silva");
 
        System.out.println("===== Pagamento via PIX =====");
        gateway.realizarCobranca(pix);
 
        System.out.println();
 
        System.out.println("===== Pagamento via Cartao =====");
        gateway.realizarCobranca(cartao);
    }
}