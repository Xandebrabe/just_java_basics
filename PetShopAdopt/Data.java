public class Data {
    private int dia;
    private int mes;
    private int ano;

    Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    Data(){
        
    }

    void mostrarData(){
        System.out.println(dia + "/" + mes + "/" + ano);
    }

    boolean maisAntiga(Data data){
        if(this.ano < data.ano)
            return true;
        else if(this.mes < data.mes)
            return true;
        else if(this.dia < data.dia)
            return true;
        else
            return false;
    }

    String pegarData(){
        String a = dia + "/" + mes + "/" + ano;
        return a;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
