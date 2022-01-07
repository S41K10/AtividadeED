package AtividadeED2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class MyBoolean {

    private static String minTermo(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        String tabelaVerdade[][] = new String[(int) Math.pow(2, numVar(path))][numVar(path) + 1];

        for (int linha = 0; linha < (int) Math.pow(2, numVar(path)); linha++) {
            for (int coluna = 0; coluna < numVar(path) + 1; coluna++) {
                if (coluna == 0) {
                    tabelaVerdade[linha][coluna] = null;
                } else tabelaVerdade[linha][coluna] = String.valueOf(random.nextInt(2));;
            }
        }

        BufferedReader buffReader;

        try {
            buffReader = new BufferedReader(new FileReader(path));
            String linha;
            int nlinha = 0;

            while (true) {
                linha = buffReader.readLine();

                if (linha != null) {
                    tabelaVerdade[nlinha][0] = linha;
                    nlinha++;
                } else break;
            }

            buffReader.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (int linha = 0; linha < (int) Math.pow(2, numVar(path)); linha++) {

            int code = 65;

            if (tabelaVerdade[linha][0].equals("1")) {
                for (int coluna = 1; coluna < numVar(path) + 1; coluna++)
                {
                    if(tabelaVerdade[linha][coluna].equals("1"))
                    {
                        stringBuilder.append((char) code);
                        code++;
                    }
                    else if(tabelaVerdade[linha][coluna].equals("0"))
                    {
                        stringBuilder.append((char) code);
                        stringBuilder.append("~");
                        code++;
                    }
                }

                if(linha + 1 < (int) Math.pow(2, numVar(path)))
            {
                stringBuilder.append(" + ");
            }

            }
        }

        MyBoolean.printMatriz(tabelaVerdade);

        return stringBuilder.toString();
    }

    public static void printMatriz(String[][] matriz) {
        for (String[] linha: matriz) {
            for (String coluna: linha) {
                System.out.printf("[%s] ", coluna);
            }

            System.out.println();
        }
    }

    public static int numVar(String path) {
        int count = 0;


        BufferedReader buffReader;

        try {
            buffReader = new BufferedReader(new FileReader(path));
            String linha;

            while (true) {
                linha = buffReader.readLine();

                if (linha != null) {
                    count++;
                } else break;
            }

            buffReader.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        int numVar = myLog(count, 2);

        return numVar;
    }

    public static int myLog(int logaritmando, int base) {
        return (int)(Math.log(logaritmando) / Math.log(base));

    }

    public static void main(String[] args) {
        //         Faça uma codificação em uma linguagem de programação, ao seu critério de escolha,
        // que a partir da leitura de um arquivo de texto contendo apenas a saída de uma tabela
        // verdade, gere a expressão booleana por maxtermo ou mintermo. Deve-se considerar
        // saídas da tabela verdade em potências de 2 conforme a quantidade de variáveis, ou seja,
        // 2, 4, 8, 16, 32...

        //Recomendo que para o método minTermo utilize o caminho absoluto do arquivo txt que contém a tabela verdade
        System.out.println(minTermo("Aqui entra o caminho absoluto"));
        
    }

}
