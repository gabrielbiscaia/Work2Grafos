import java.util.LinkedList;
import java.util.List;

public class Grafo {
    public Vertice[] vertices;

    public Grafo(int n) {
        vertices = new Vertice[n];
        for (int i = 0; i < n; i++) {
            vertices[i] = new Vertice(i); //instancia cada vértice
        }
    }

    public void addAresta(int u, int v){
        vertices[u].adj.add(vertices[v]);
    }

    public void buscaLargura() {
        for (Vertice v : vertices) { //a lista de vértices vai ser percorrido e pintar cada vértice da cor cinza demonstrando que não foi percorrido
            v.cor = "cinza"; //não percorrido
        }
        vertices[0].cor = "branco"; //primeiro vértice da cor branca
        List<Vertice> prioridade = new LinkedList<>();
        prioridade.add(vertices[0]);
        while(!prioridade.isEmpty()) { //Enquanto a lista não for vazia
            Vertice u = prioridade.remove(0);
            for (Vertice v : u.adj) {
                if (v.cor.equals("branco")) { //chamar função pra colorir
                    v.cor = "cinza";
                    prioridade.add(v);
                }
            }
            u.cor = "preto";
        }
    }
}
