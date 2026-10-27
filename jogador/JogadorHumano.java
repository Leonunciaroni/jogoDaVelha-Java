package jogador;
import jogo.*;

import java.io.*;

public class JogadorHumano implements Jogador
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;
    private BufferedReader teclado   = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        if (tab == null)
            throw new Exception("Tabuleiro nao pode ser null");

        tabDoJogo = tab;
        while (marca == null)
        {
            System.out.print("Escolha sua marca (X/O): ");
            String resposta = lerLinha();
            if (resposta != null && resposta.trim().length() == 1)
            {
                char simbolo = Character.toUpperCase
                    (resposta.trim().charAt(0));
                if (simbolo == 'X' || simbolo == 'O')
                    marca = new Marca(simbolo);
            }
        }
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
        if (tab == null)
            throw new Exception("Tabuleiro nao pode ser null");
        if (mrc == null)
            throw new Exception("Marca nao pode ser null");

        tabDoJogo = tab;
        marca = mrc;
    }

    public Marca getMarca ()
    {
        return marca;
    }

    public void facaSuaJogada ()
    {
        while (true)
        {
            try
            {
                System.out.println(tabDoJogo);
                System.out.print("Digite a linha (0-2): ");
                int linha = Integer.parseInt(lerLinha().trim());
                System.out.print("Digite a coluna (0-2): ");
                int coluna = Integer.parseInt(lerLinha().trim());

                if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2)
                {
                    System.out.println("Posicao invalida.");
                    continue;
                }
                if (tabDoJogo.haMarcaNaPosicao(linha, coluna))
                {
                    System.out.println("Essa casa ja esta ocupada.");
                    continue;
                }

                tabDoJogo.setMarcaNaPosicao(marca, linha, coluna);
                return;
            }
            catch (NumberFormatException erro)
            {
                System.out.println("Digite numeros validos.");
            }
            catch (IOException erro)
            {
                System.out.println("Nao foi possivel ler a jogada.");
                return;
            }
            catch (Exception erro)
            {
                System.out.println("Nao foi possivel realizar a jogada.");
            }
        }
    }

    public void vcGanhou ()
    {
        System.out.println("Voce ganhou!");
    }

    public void vcPerdeu ()
    {
        System.out.println("Voce perdeu!");
    }

    public void deuVelha ()
    {
        System.out.println("Deu velha!");
    }

    public boolean querMaisUmaPartida ()
    {
        while (true)
        {
            try
            {
                System.out.print("Deseja jogar novamente? (S/N): ");
                String resposta = lerLinha();
                if (resposta != null && resposta.trim().length() == 1)
                {
                    char opcao = Character.toUpperCase
                        (resposta.trim().charAt(0));
                    if (opcao == 'S')
                        return true;
                    if (opcao == 'N')
                        return false;
                }
                System.out.println("Resposta invalida. Digite S ou N.");
            }
            catch (IOException erro)
            {
                System.out.println("Nao foi possivel ler a resposta.");
                return false;
            }
        }
    }

    private String lerLinha () throws IOException
    {
        String linha = teclado.readLine();
        if (linha == null)
            throw new IOException("Fim da entrada");
        return linha;
    }
}