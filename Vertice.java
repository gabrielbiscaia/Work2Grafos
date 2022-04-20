import java.util.LinkedList;

public class Vertice { //bar
    public int id;
    public String cor; //preto, verde, branco e vermelho.
    public LinkedList<Vertice> adj;
    public boolean colorido;

    public Vertice(int id){
        this.id = id + 1;
        this.adj = new LinkedList<Vertice>();
        this.colorido = false;
    }
}
