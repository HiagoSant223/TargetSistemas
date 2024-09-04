import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teste03 {
    public static void main(String[] args) {
        try {
            
            FileReader fileReader = new FileReader("faturamento.json");
            StringBuilder jsonText = new StringBuilder();
            int c;
            while ((c = fileReader.read()) != -1) {
                jsonText.append((char) c);
            }
            fileReader.close();

            JSONObject jsonObject = new JSONObject(jsonText.toString());
            JSONArray faturamentoArray = jsonObject.getJSONArray("faturamento");

            List<Double> valores = new ArrayList<>();
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0.0;
            int diasComFaturamento = 0;

            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject diaFaturamento = faturamentoArray.getJSONObject(i);
                double valor = diaFaturamento.getDouble("valor");

                if (valor > 0) {
                    valores.add(valor);
                    if (valor < menorValor) menorValor = valor;
                    if (valor > maiorValor) maiorValor = valor;
                    somaValores += valor;
                    diasComFaturamento++;
                }
            }

            double media = somaValores / diasComFaturamento;
            int diasAcimaDaMedia = 0;
            for (double valor : valores) {
                if (valor > media) diasAcimaDaMedia++;
            }

      
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
