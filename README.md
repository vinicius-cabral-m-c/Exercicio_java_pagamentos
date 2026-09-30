# 💳 Gateway de Pagamentos em Java

Projeto da disciplina de **Desenvolvimento de Sistemas** que simula o motor de pagamentos de um e-commerce. O foco é praticar **Herança** e **Polimorfismo** em Java, usando a ideia por trás do padrão de projeto **Strategy**.

## 🎯 Objetivo

Montar as classes de forma que o sistema aceite diferentes formas de pagamento **sem precisar alterar a classe principal**. Se o e-commerce passar a aceitar criptomoedas no futuro, basta criar uma nova classe filha. O `GatewayPagamento` continua exatamente igual.

A inteligência de como cobrar fica dentro de cada tipo de pagamento, e não no gateway.

## 🗂️ Estrutura do projeto

```
src/
└── pagamento/
    ├── Pagamento.java
    ├── PagamentoPix.java
    ├── PagamentoCartao.java
    ├── GatewayPagamento.java
    └── Main.java
```

## 🧩 Classes

| Classe | Função |
|---|---|
| `Pagamento` | Classe **abstrata** base. Guarda ID da transação, valor e status, imprime o recibo e define o método abstrato `processar()`. |
| `PagamentoPix` | Filha de `Pagamento`. Gera o QR Code e sempre aprova. |
| `PagamentoCartao` | Filha de `Pagamento`. Recusa compras acima de R$ 5000 (limite excedido) e aprova as demais. |
| `GatewayPagamento` | Recebe qualquer `Pagamento`, chama `processar()` e atualiza o status para APROVADO ou RECUSADO. |
| `Main` | Classe de teste que executa um Pix de R$ 150,00 e um cartão de R$ 6000,00. |

## 📚 Conceitos praticados

- **Classe abstrata e método abstrato:** `Pagamento` define o contrato `processar()`, e cada filha é obrigada a implementá-lo.
- **Herança:** as filhas usam `extends` e chamam `super(valor)` no construtor.
- **Sobrescrita:** `@Override` no `processar()` de cada filha.
- **Polimorfismo:** `realizarCobranca(Pagamento pagamento)` recebe a classe mãe e cada objeto executa o seu próprio comportamento.
- **Princípio Aberto-Fechado:** o gateway não usa `if/else`, `switch` ou `instanceof` para descobrir o tipo de pagamento.

