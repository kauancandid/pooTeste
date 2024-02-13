package TestePraticoPoo.poo.enuns;

public enum Cargo {
    SECRETARIO(7000, 1000, 0.2), // Salário base, benefício por ano de serviço, percentual de benefício por venda
    VENDEDOR(12000, 1800, 0.3),
    GERENTE(20000, 3000, 0); // Gerente não tem benefício por venda

    private final double salarioBase;
    private final double beneficioPorAnoDeServico;
    private final double percentualBeneficioPorVenda;

    Cargo(double salarioBase, double beneficioPorAnoDeServico, double percentualBeneficioPorVenda) {
        this.salarioBase = salarioBase;
        this.beneficioPorAnoDeServico = beneficioPorAnoDeServico;
        this.percentualBeneficioPorVenda = percentualBeneficioPorVenda;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBeneficioPorAnoDeServico() {
        return beneficioPorAnoDeServico;
    }

    public double getPercentualBeneficioPorVenda() {
        return percentualBeneficioPorVenda;
    }
}
