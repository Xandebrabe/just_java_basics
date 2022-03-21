public class FichaAdocao {
    private Cachorro cachorro;
    private Pessoa pessoa;
    private Data data;

    FichaAdocao(Cachorro cachorro, Pessoa pessoa, Data data){
        this.cachorro = cachorro;
        this.pessoa = pessoa;
        this.data = data;
    }

    void mostrarFichaAdocao(){
        System.out.println(pessoa.getNome() + " | " + cachorro.getNome() + " | " + data.pegarData());
    }

    public Cachorro getCachorro() {
        return cachorro;
    }
        
    public void setCachorro(Cachorro cachorro) {
        this.cachorro = cachorro;
    }
    public Pessoa getPessoa() {
        return pessoa;
    }
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }
	
}
