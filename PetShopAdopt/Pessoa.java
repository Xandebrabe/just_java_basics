public class Pessoa {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private int sexo; // 0 - feminino | 1 - masculino
    private Cachorro cachorroAdotado;
    
    //todo - mostrar sexo instead 0/1

    Pessoa(String nome, String endereco, String telefone, String email, int sexo, Cachorro cachorroAdotado){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        this.cachorroAdotado = cachorroAdotado;
    }
    Pessoa(String nome, int sexo){
        this.nome = nome;
        this.sexo = sexo;
    }

    String sexoString(int sexo){
        if(sexo == 1)
            return "Masculino";
        else
            return "Feminino";
    }
    void mostrarPessoa(){
        System.out.println(nome + " | " + endereco + " | " + telefone + " | " + email + " | " + sexoString(sexo) + " | " + cachorroAdotado.getNome());
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Cachorro getCachorroAdotado() {
        return cachorroAdotado;
    }
    public void setCachorroAdotado(Cachorro cachorroAdotado) {
        this.cachorroAdotado = cachorroAdotado;
    }
    public int getSexo() {
        return sexo;
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
