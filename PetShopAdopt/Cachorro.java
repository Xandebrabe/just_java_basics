public class Cachorro {
    private String nome;
    private Data dataEntrada;
    private String raca;
    private String cor;
    private int peso;

    Cachorro(){}

    Cachorro(String nome, Data dataEntrada, String raca, String cor, int peso){
        this.nome = nome;
        this.dataEntrada = dataEntrada;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
    }

    void mostrarCachorro(){
        System.out.println(nome + " | " + dataEntrada.pegarData() + " | " + raca + " | " + cor + " | " + peso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Data dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
