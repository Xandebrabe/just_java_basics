import java.util.*;

public class ClassePrincipal {
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int entrada;

        ArrayList<Cachorro> tabelaCachorros = new ArrayList<Cachorro>();
        ArrayList<FichaAdocao> ficha = new ArrayList<FichaAdocao>();
        ArrayList<Pessoa> adotantes = new ArrayList<Pessoa>();

        //tabelaCachorros.add(new Cachorro("Dog", new Data(25, 4, 2003), "Salsicha", "Roxo", 24));
        //tabelaCachorros.add(new Cachorro("Pug", new Data(25, 4, 2003), "Husky", "Branco", 20));

        //ficha.add(new FichaAdocao(tabelaCachorros.get(0), new Pessoa("Jorge", "Rua Santo Rei", "212352", "hdiouajdhnai@gmail.com", 1, tabelaCachorros.get(0)), new Data(24, 5, 2032)));

        do{
            System.out.println("\n\t\t\t CaoNino \n\n");
            System.out.println("1 - Cachorros \n");
            System.out.println("2 - Ficha Adocao \n");
            System.out.println("3 - Adotantes \n");
            System.out.println("0 - Fechar \n");
    

            entrada = in.nextInt();
    
            switch(entrada){
                case 1:                             //CACHORROS
                    System.out.println("1 - Visualizar \n");
                    System.out.println("2 - Adicionar \n");
    
                    entrada = in.nextInt();
                    switch(entrada){
                        case 1: 
                            for(Cachorro a : tabelaCachorros)
                                a.mostrarCachorro();
                            break;
                            
                        case 2:
                            System.out.println("Entre com o nome: ");
                            String nome = in.next();
                            System.out.println("Entre com o dia: ");
                            int dia = in.nextInt();
                            System.out.println("Entre com o mes: ");
                            int mes = in.nextInt();
                            System.out.println("Entre com o ano: ");
                            int ano = in.nextInt();
                            System.out.println("O cachorro possui raca? (0 -> N | 1 -> S): ");
                            int num = in.nextInt();
                            String raca;
                            if(num == 0)
                                raca = "Vira-Lata";
                            else{
                                System.out.println("Entre com o nome da raca: ");
                                raca = in.next();
                            }
                            System.out.println("Entre com a cor: ");              
                            String cor = in.next();
                            System.out.println("Entre com o peso: ");
                            int peso = in.nextInt();

                            tabelaCachorros.add(new Cachorro(nome, new Data(dia, mes, ano), raca, cor, peso));
                            break;
                    }
                    break;

                case 2:                            //FICHA ADOCAO

                    System.out.println("1 - Visualizar as fichas de adocoes ja criadas \n");
                    System.out.println("2 - Adicionar ficha de adocao \n");
                    System.out.println("3 - Substituir adotante \n");

                    entrada = in.nextInt();

                    switch(entrada){
                        case 1:                     //VISUALIZAR FICHAS
                            for(FichaAdocao a : ficha){
                                a.mostrarFichaAdocao();
                            }
                            break;

                        case 2:                     //ADOTAR
                            System.out.println("Insira o nome do adotante: ");
                            String nome = in.next();
                            System.out.println("Insira endereco do adotante: ");
                            String endereco = in.nextLine();
                            System.out.println("Insira telefone do adotante: ");
                            String telefone = in.next();
                            System.out.println("Insira o email do adotante: ");
                            String email = in.next();
                            System.out.println("Insira o sexo (0 -> F | 1 -> M): ");
                            int sexo = in.nextInt();
                            System.out.println("Insira o dia de adocao: ");
                            int dia = in.nextInt();
                            System.out.println("Insira o mes da adocao: ");
                            int mes = in.nextInt();
                            System.out.println("Insira o ano de adocao: ");
                            int ano = in.nextInt();
                            
                            System.out.println("Insira o nome do cachorro a ser adotado: ");
                            String nomeCachorro = in.next();
                            Cachorro c = new Cachorro();
                            for(int i = 0; i < tabelaCachorros.size(); i++){
                                if(nomeCachorro.equals(tabelaCachorros.get(i).getNome())){
                                    c = tabelaCachorros.get(i);
                                    Data dataAdocao = new Data(dia, mes, ano);

                                    if(c.getDataEntrada().maisAntiga(dataAdocao)){                  //verifica validez da data de entrada do cachorro com data de adoção
                                        tabelaCachorros.remove(i);
                                        Pessoa p = new Pessoa(nome, endereco, telefone, email, sexo, c);
                                        adotantes.add(p);
                                        ficha.add(new FichaAdocao(c, p, dataAdocao));
                                    }
                                    else{
                                        System.out.println("Data inválida, tente novamente.");
                                    }
                                    
                                    break;
                                }
                            }
                            break;

                        case 3:                                                                     //substituindo adotante
                            System.out.println("Entre com o nome do cachorro da ficha a ser alterada:");
                            String nomeC = in.next();

                            Cachorro cachorro = new Cachorro();

                            for(int i = 0; i < tabelaCachorros.size(); i++){
                                if(nomeC.equals(tabelaCachorros.get(i).getNome())){
                                    cachorro = tabelaCachorros.get(i);
                                }
                            }
                            
                            for(int i = 0; i < ficha.size(); i++){
                                if(cachorro == ficha.get(i).getCachorro()){
                                    System.out.println("Insira o nome do adotante: ");
                                    String nomeA = in.next();
                                    System.out.println("Insira endereco do adotante: ");
                                    String enderecoA = in.nextLine();
                                    System.out.println("Insira telefone do adotante: ");
                                    String telefoneA = in.next();
                                    System.out.println("Insira o email do adotante: ");
                                    String emailA = in.next();
                                    System.out.println("Insira o sexo (0 -> F | 1 -> M): ");
                                    int sexoA = in.nextInt();
                                    Pessoa pes = new Pessoa(nomeA, enderecoA, telefoneA, emailA, sexoA, cachorro);
                                    for(int j = 0; j < adotantes.size(); j++){
                                        if(adotantes.get(i) == pes){
                                            adotantes.remove(i);
                                            adotantes.add(pes);
                                            ficha.get(i).setPessoa(pes);
                                        }
                                    }
                                }
                            }
                    }
                    
                    
                    break;
                case 3:                            //ADOTANTES
                    for(Pessoa p : adotantes){
                        p.mostrarPessoa();
                    }
                    break;
            }
        }while(entrada != 0);

        in.close();
    }

    public int diasEntreDatas(Data dataS, Data dataE){
        int tempo = 0;
        boolean mesZoado = false;
        boolean anoZoado = false;

        int aux = dataS.getDia() - dataE.getDia();
        if(aux < 0){
            tempo += dataS.getDia();
            tempo += (30 - dataE.getDia());
            mesZoado = true;
        }
        else{
            tempo += aux;
        }

        aux = dataS.getMes() - dataE.getMes();
        if(aux < 0){
            tempo += dataS.getMes() * 30;
            tempo += (12 - dataE.getDia()) * 30;
            anoZoado = true;
        }
        else{
            tempo += aux * 30;
        }
        if(mesZoado){
            tempo -= 30;
        }

        aux = dataS.getAno() - dataE.getAno();
        tempo = aux * 365;
        if(anoZoado){
            tempo -= 365;
        }
        
        return tempo;
    }
    
    public int nutricao_cachorro(Cachorro cachorro){
        int peso = cachorro.getPeso();
        if(peso < 21){
            return 0;           //desnutrido
        }
        else if(peso < 31){
            return 1;           //normal
        }
        else{
            return 2;           //obeso
        }
    }

    public int tempo_de_adocao(ArrayList<FichaAdocao> ficha, Cachorro cachorro){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o dia de hoje: ");
        int dia = entrada.nextInt();
        System.out.println("Insira o mes: ");
        int mes = entrada.nextInt();
        System.out.println("Insira o ano: ");
        int ano = entrada.nextInt();
        Data deHoje = new Data(dia, mes, ano);
        Data diaAdocao = new Data();

        for(int i = 0; i < ficha.size(); i++){
            if(cachorro == ficha.get(i).getCachorro()){
                diaAdocao = ficha.get(i).getData();
            }
        }

        entrada.close();
        return diasEntreDatas(deHoje, diaAdocao); 
    }

    public int tempo_de_ong(Cachorro cachorro, ArrayList<FichaAdocao> ficha){ //final 2
        Data dataE = new Data();
        Data dataS = new Data();
        for(FichaAdocao f : ficha){
            if(cachorro == f.getCachorro()){
                dataE = cachorro.getDataEntrada();
                dataS = f.getData();
            }        
        }
        return diasEntreDatas(dataE, dataS);
    }


    public boolean existe_cachorro_adotado_nome(String nomeCachorro, ArrayList<FichaAdocao> ficha){
        for(int i = 0; i < ficha.size(); i++){
            if(nomeCachorro.equals(ficha.get(i).getCachorro().getNome())){
                return true;
            }
        }  
        return false;
    }

    public Cachorro cachorro_maior_tempo_adotado(ArrayList<FichaAdocao> ficha){
        int maiorTempo = 0;
        Cachorro maisOld = new Cachorro();
        Scanner entrada = new Scanner(System.in);
        System.out.println("Insira o dia de hoje: ");
        int dia = entrada.nextInt();
        System.out.println("Insira o mes: ");
        int mes = entrada.nextInt();
        System.out.println("Insira o ano: ");
        int ano = entrada.nextInt();
        Data deHoje = new Data(dia, mes, ano);
        
        for(FichaAdocao f : ficha){
            if(diasEntreDatas(deHoje, f.getData()) > maiorTempo){
                maisOld = f.getCachorro();
            }
        }
        entrada.close();

        return maisOld;
    }

    public int quantos_viralatas_adotados(ArrayList<FichaAdocao> ficha){
        int count = 0;
        for(FichaAdocao f : ficha){
            if(f.getCachorro().getRaca().equals("Vira-Lata")){
                count += 1;
            }
        }

        return count;
    }

    public int quantos_desnutridos(ArrayList<FichaAdocao> ficha, ArrayList<Cachorro> tabelaCachorros){
        int total = 0;
        for(FichaAdocao f : ficha){
            if(nutricao_cachorro(f.getCachorro()) == 0){
                total += 1;
            }
        }

        for(Cachorro c : tabelaCachorros){
            if(nutricao_cachorro(c) == 0){
                total += 1;
            }
        }
        return total;
    }

    public int quantos_viralatas(ArrayList<FichaAdocao> ficha, ArrayList<Cachorro> tabelaCachorros){
        int total = 0;

        for(Cachorro c : tabelaCachorros){
            if(c.getRaca().equals("Vira-Lata")){
                total += 1;
            }
        }

        total += quantos_viralatas_adotados(ficha);

        return total;
    }

    public int quantos_de_cor_amarela(ArrayList<FichaAdocao> ficha, ArrayList<Cachorro> tabelaCachorros){
        int total = 0;
        
        for(FichaAdocao f : ficha){
            if(f.getCachorro().getCor().toLowerCase().equals("amarelo")){
                total += 1;
            }
        }

        for(Cachorro c : tabelaCachorros){
            if(c.getCor().toLowerCase().equals("amarelo")){
                total += 1;
            }
        }

        return total;
    }

}


