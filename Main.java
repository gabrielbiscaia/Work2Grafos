public class Main {
    public static void main(String[] args) {
        Grafo g = new LeitorGrafo().criarGrafo();
        // g.buscaLargura();
        // g.percorrerGrafo();
        g.percorrerGrafo2();
        g.imprimeVertices();
    }
}