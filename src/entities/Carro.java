package entities;

public class Carro extends Veiculo {
    private int numeroPortas;

    public Carro(String placa, String modelo, int ano, int numeroPortas) {
        super(placa, modelo, ano);
        this.numeroPortas = numeroPortas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    @Override
    public String toString() {
        return "Carro [Placa: " + placa + ", Modelo: " + modelo + ", Ano: " + ano + ", Número de Portas: " + numeroPortas + "]";
    }
}
