import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



    public class LeituraArquivoDeTexto {

        public static void main(String[] args) {

            String path = "C:\\Users\\Luis Felipe\\Desktop\\ArquivosCsv";

            List<Cidades> list = new ArrayList<Cidades>();

            try (BufferedReader br = new BufferedReader(new FileReader(path))) {

                String line = br.readLine();
                line = br.readLine();
                while (line != null) {

                    String[] vect = line.split(",");
                    String name = vect[0];
                    Double price = Double.parseDouble(vect[1]);
                    Integer qte = Integer.parseInt(vect[2]);

                    Cidades prod = new Cidades(name, price, qte);
                    list.add(prod);

                    line = br.readLine();
                }

                System.out.println("PRODUCTS:");
                for (Cidades p : list) {
                    System.out.println(p);
                }
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

