package progconcorrente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Flávio
 */
public class DadosExtraidos {
    private long tempoGastoS;
    private long tempoGastoC;
    private long tempoGastoD;
    
    private int tamEntrada;
    private int tamVetores;
    private String tipoProg;
    private String nomeArquivo;

    public DadosExtraidos() {
        this.tempoGastoS = 0;
        this.tempoGastoC = 0;
        this.tempoGastoD = 0;
        this.tamEntrada = 0;
        this.tamVetores = 0;
        this.tipoProg = "";
    }

    public long getTempoGastoS() {
        return tempoGastoS;
    }

    public void setTempoGastoS(long tempoGasto) {
        this.tempoGastoS = tempoGasto;
    }
    
    public long getTempoGastoC() {
        return tempoGastoC;
    }

    public void setTempoGastoC(long tempoGasto) {
        this.tempoGastoC = tempoGasto;
    }
    
    public long getTempoGastoD() {
        return tempoGastoD;
    }

    public void setTempoGastoD(long tempoGasto) {
        this.tempoGastoD = tempoGasto;
    }
    
    public String getNomeArquivo() {
        return this.nomeArquivo;
    }

    public void setNomeArquivo(String nome) {
        this.nomeArquivo = nome;
    }

    public int getTamEntrada() {
        return tamEntrada;
    }

    public void setTamEntrada(int tamEntrada) {
        this.tamEntrada = tamEntrada;
    }

    public int getTamVetores() {
        return tamVetores;
    }

    public void setTamVetores(int tamVetores) {
        this.tamVetores = tamVetores;
    }

    public String getTipoProg() {
        return tipoProg;
    }

    public void setTipoProg(String tipoProg) {
        this.tipoProg = tipoProg;
    }
    
    void gerarValoresGravaArquivo(String nomeArquivo, int tam){
    int temp = 0;
    String palavra = "";
    Random valor = new Random();
    int [] Vetor = new int[tam];
    for(int i = 0; i < tam; i++){
        //System.out.println("Olá Mundo");
        temp = valor.nextInt(9999999);
        Vetor[i] = temp;
        //System.out.println(Vetor[i]);
    }

    File file = new File(nomeArquivo);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                //Logger.getLogger(SequencialProg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        FileWriter fw = null;
    try {
        fw = new FileWriter(file.getAbsoluteFile());
    } catch (IOException ex) {
        Logger.getLogger(ProgConcorrente.class.getName()).log(Level.SEVERE, null, ex);
    }
        BufferedWriter bw = new BufferedWriter(fw);

    for(int i = 0; i < tam; i++){
        //System.out.println(Vetor[i]);
        palavra = Integer.toString(Vetor[i]);
        //System.out.println(palavra);
        try {
            bw.write(palavra+"\n");        
        } catch (IOException ex) {
            Logger.getLogger(ProgConcorrente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ProgConcorrente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    
}
