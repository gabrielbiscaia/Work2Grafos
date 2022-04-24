import java.util.LinkedList;

public class Vertice { //bar
    public int id, grauTotal;
    public String cor; //preto, verde, branco e vermelho.
    public LinkedList<Vertice> adj, pais;

    public Vertice(int id){
        this.id = id + 1;
        this.grauTotal = 0;
        this.adj = new LinkedList<Vertice>();
        this.pais = new LinkedList<Vertice>();
    }
}
