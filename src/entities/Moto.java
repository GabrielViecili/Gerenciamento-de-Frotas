package entities;

public class Moto extends Veiculo {
    public Moto(String placa, String modelo, int ano) {
        super(placa, modelo, ano);
    }

    @Override
    public String toString() {
        return "Moto [Placa: " + placa + ", Modelo: " + modelo + ", Ano: " + ano + "]";
    }
}
