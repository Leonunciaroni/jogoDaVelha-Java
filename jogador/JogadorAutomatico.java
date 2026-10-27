package jogador;
import jogo.*;

public class JogadorAutomatico implements Jogador
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

    private static final int[][][] LINHAS =
    {
        {{0,0}, {0,1}, {0,2}},
        {{1,0}, {1,1}, {1,2}},
        {{2,0}, {2,1}, {2,2}},
        {{0,0}, {1,0}, {2,0}},
        {{0,1}, {1,1}, {2,1}},
        {{0,2}, {1,2}, {2,2}},
        {{0,0}, {1,1}, {2,2}},
        {{0,2}, {1,1}, {2,0}}
    };

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        this (tab, new Marca (Math.random () < 0.5 ? 'X' : 'O'));
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        if (tab == null || mrc == null)
            throw new Exception ("Tabuleiro ou marca ausente");
        this.tabDoJogo = tab;
        this.marca     = mrc;
    }

    public Marca getMarca ()
    {
        return marca;
    }

    public void facaSuaJogada ()
    {
        try
        {
            if (jogarNaLinhaComDuasMarcas(marca))
                return;

            Marca adversaria = new Marca
                (marca.getSimbolo() == 'X' ? 'O' : 'X');
            if (jogarNaLinhaComDuasMarcas(adversaria))
                return;

            if (jogarNaLinhaComUmaMarca())
                return;

            jogarEmQualquerCasaLivre();
        }
        catch (Exception erro)
        {}
    }

    private boolean jogarNaLinhaComDuasMarcas (Marca alvo) throws Exception
    {
        for (int[][] linha : LINHAS)
        {
            int vazias = 0;
            int linhaVazia = -1;
            int colunaVazia = -1;
            int encontradas = 0;

            for (int[] posicao : linha)
            {
                Marca atual = tabDoJogo.getMarcaNaPosicao
                    (posicao[0], posicao[1]);
                if (atual == null)
                {
                    vazias++;
                    linhaVazia = posicao[0];
                    colunaVazia = posicao[1];
                }
                else if (atual.equals(alvo))
                    encontradas++;
            }

            if (vazias == 1 && encontradas == 2)
            {
                tabDoJogo.setMarcaNaPosicao
                    (marca, linhaVazia, colunaVazia);
                return true;
            }
        }
        return false;
    }

    private boolean jogarNaLinhaComUmaMarca () throws Exception
    {
        for (int[][] linha : LINHAS)
        {
            int vazias = 0;
            int minhasMarcas = 0;
            int linhaVazia = -1;
            int colunaVazia = -1;

            for (int[] posicao : linha)
            {
                Marca atual = tabDoJogo.getMarcaNaPosicao
                    (posicao[0], posicao[1]);
                if (atual == null)
                {
                    vazias++;
                    linhaVazia = posicao[0];
                    colunaVazia = posicao[1];
                }
                else if (atual.equals(marca))
                    minhasMarcas++;
            }

            if (vazias == 2 && minhasMarcas == 1)
            {
                tabDoJogo.setMarcaNaPosicao
                    (marca, linhaVazia, colunaVazia);
                return true;
            }
        }
        return false;
    }

    private void jogarEmQualquerCasaLivre () throws Exception
    {
        for (int linha = 0; linha < 3; linha++)
            for (int coluna = 0; coluna < 3; coluna++)
                if (tabDoJogo.getMarcaNaPosicao(linha, coluna) == null)
                {
                    tabDoJogo.setMarcaNaPosicao(marca, linha, coluna);
                    return;
                }
    }
}