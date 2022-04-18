public class Grafo {
    public Vertice[] vertices;

    public void addAresta(int u, int v){
        vertices[u].adj.add(vertices[v]);
    }
}
