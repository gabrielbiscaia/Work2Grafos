import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LeitorGrafo {
    public Grafo criarGrafo() {
        try {
            FileReader arq = new FileReader("grafos_de_entrada/60_grafos.txt");
            Scanner leitor = new Scanner(arq);

            leitor.nextLine();
            leitor.nextLine(); //Só serve para pular as duas primeiras linhas do arquivo.

            String aux[] = leitor.nextLine().split("="); //aux vai reeber um vetor de 2 posições, sendo a segunda o número de vértices
            int tam = Integer.parseInt(aux[1]); //Pega o tamanho do grafo.

            leitor.nextLine(); //Pula a quarta linha.

            Grafo g = new Grafo(tam);

            while (leitor.hasNextLine()) {
                aux = leitor.nextLine().split(" ");
                g.addAresta(Integer.parseInt(aux[0]) - 1, Integer.parseInt(aux[1]) - 1);
                g.vertices[Integer.parseInt(aux[1]) - 1].pais.add(g.vertices[Integer.parseInt(aux[0]) - 1]);
            }

            leitor.close();
            return g;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            e.printStackTrace();
            return null;
        }
    }
}