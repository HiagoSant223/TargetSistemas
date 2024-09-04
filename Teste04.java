import java.util.HashMap;
import java.util.Map;

public class Teste04 {
    public static void main(String[] args) {
        
        Map<String, Double> faturamentoEstados = new HashMap<>();
        faturamentoEstados.put("SP", 67836.43);
        faturamentoEstados.put("RJ", 36678.66);
        faturamentoEstados.put("MG", 29229.88);
        faturamentoEstados.put("ES", 27165.48);
        faturamentoEstados.put("Outros", 19849.53);
        
        double totalFaturamento = faturamentoEstados.values().stream()
            .mapToDouble(Double::doubleValue)
            .sum();
        
        for (Map.Entry<String, Double> entry : faturamentoEstados.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / totalFaturamento) * 100;
            System.out.println("Percentual de " + estado + ": " + String.format("%.2f", percentual) + "%");
        }
    }
}

