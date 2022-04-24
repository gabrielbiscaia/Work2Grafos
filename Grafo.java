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

    public void buscaLargura() { //LEMBRAR DE PERCORRER VÉRTICES ISOLADOS DEPOIS
        for (Vertice v : vertices) { //a lista de vértices vai ser percorrido e pintar cada vértice da cor cinza demonstrando que não foi percorrido
            v.cor = "cinza"; //não percorrido
        }
        vertices[0].cor = "branco"; //primeiro vértice da cor branca
        List<Vertice> prioridade = new LinkedList<>();
        prioridade.add(vertices[0]);
        while(!prioridade.isEmpty()) { //Enquanto a lista não for vazia
            Vertice u = prioridade.remove(0);
            for (Vertice v : u.adj) {
                if (v.cor.equals("cinza")) {
                    v.cor = pintarVertice(v); //função pra colorir os adjacentes
                    prioridade.add(v);
                }
            }
            if(u.cor == "todas as cores foram utilizadas"){
                System.out.println("AQUI TEM QUE ENCERRAR O PROGRAMA");
            }
        }
    }

    public void percorrerGrafo() { //Percorre o grafo em sequência de vértices.
        for (Vertice v : vertices) 
            v.cor = "cinza";
        for (Vertice v : vertices) {
            if (v.cor.equals("cinza")) 
                v.cor = pintarVertice(v);
        }
    }

    public void percorrerGrafo2() { //Percorre o grafo em ordem decrescente dos graus totais de cada vértice.
        for (Vertice v : vertices)
            v.cor = "cinza";
        for (int i = 0; i < vertices.length; i++) {
            int maiorGrau = maiorGrau();
            vertices[maiorGrau].cor = pintarVertice(vertices[maiorGrau]);
            vertices[maiorGrau].grauTotal = -1; //Garante que um vértice já percorrido não retorne;
        }
    }

    private int maiorGrau() { //Retorna o index do grafo de maior grau.
        Vertice maior = vertices[0];
        for (Vertice v : vertices) {
            if (v.grauTotal > maior.grauTotal)
                maior = v;
        }
        int index = maior.id - 1;

        return index;
    }

    public void imprimeVertices(){
        for(Vertice v : vertices){
            System.out.println("--------------------");
            System.out.println("Numero do vertice: "+v.id);
            System.out.println("Cor do vertice: "+v.cor);
        }
        System.out.println("--------------------");
        System.out.println("Todos os vertices foram imprimidos");
    }

    public String pintarVertice(Vertice u){
        LinkedList<String> coresDisponiveis = new LinkedList<>();
        coresDisponiveis.add("preto");
        coresDisponiveis.add("branco");
        coresDisponiveis.add("verde");
        coresDisponiveis.add("vermelho");
        for(Vertice adjacente : u.adj){
            if(adjacente.cor.equals("preto"))
                coresDisponiveis.remove("preto");
            if(adjacente.cor.equals("branco"))
                coresDisponiveis.remove("branco");
            if(adjacente.cor.equals("verde"))
                coresDisponiveis.remove("verde");
            if(adjacente.cor.equals("vermelho"))
                coresDisponiveis.remove("vermelho");
        }
        for (Vertice pai : u.pais) {
            if(pai.cor.equals("preto"))
                coresDisponiveis.remove("preto");
            if(pai.cor.equals("branco"))
                coresDisponiveis.remove("branco");
            if(pai.cor.equals("verde"))
                coresDisponiveis.remove("verde");
            if(pai.cor.equals("vermelho"))
                coresDisponiveis.remove("vermelho");
        }
        if(coresDisponiveis.isEmpty()){
            return "todas as cores foram utilizadas";
        }
        return coresDisponiveis.get(0);
    }

}
