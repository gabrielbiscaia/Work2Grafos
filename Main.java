public class Main {
    public static void main(String[] args) {
        Grafo g = new LeitorGrafo().criarGrafo();
        g.buscaLargura();
        g.imprimeVertices();
        //adicionar função para imprimir todos os vértices com suas respectivas cores
    }
}
