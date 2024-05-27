package services;

import entities.Veiculo;
import entities.Carro;
import entities.Moto;

import java.util.ArrayList;
import java.util.List;

public class VeiculoService {
    private List<Veiculo> veiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo.getPlaca().isEmpty() || veiculo.getModelo().isEmpty() || veiculo.getAno() == 0) {
            throw new Exception("Campos em branco ou ano inválido.");
        }

        if (veiculo instanceof Carro && ((Carro) veiculo).getNumeroPortas() == 0) {
            throw new Exception("Número de portas não pode ser 0.");
        }

        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                throw new Exception("Veículo com a mesma placa já cadastrado.");
            }
        }

        veiculos.add(veiculo);
    }

    public List<Veiculo> listarVeiculos() {
        return new ArrayList<>(veiculos);
    }

    public Veiculo buscarPorPlaca(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(placa)) {
                return v;
            }
        }
        return null;
    }

    public void removerVeiculo(String placa) throws Exception {
        Veiculo veiculo = buscarPorPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
        } else {
            throw new Exception("Veículo não encontrado.");
        }
    }
}
