package jogo;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // colocar tab em tabDoJogo
        if (tab == null) throw new Exception ("Tabuleiro ausente!");

        this.tabDoJogo = tab;
    }

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor
        try
        {
            // linhas
            for (int lin = 0; lin < 3; lin++)
                if (this.tabDoJogo.haMarcaNaPosicao(lin, 0) &&
                    this.tabDoJogo.getMarcaNaPosicao(lin, 0).equals(this.tabDoJogo.getMarcaNaPosicao(lin, 1)) &&
                    this.tabDoJogo.getMarcaNaPosicao(lin, 0).equals(this.tabDoJogo.getMarcaNaPosicao(lin, 2)))
                    return this.tabDoJogo.getMarcaNaPosicao(lin, 0);

            // colunas
            for (int col = 0; col < 3; col++)
                if (this.tabDoJogo.haMarcaNaPosicao(0, col) &&
                    this.tabDoJogo.getMarcaNaPosicao(0, col).equals(this.tabDoJogo.getMarcaNaPosicao(1, col)) &&
                    this.tabDoJogo.getMarcaNaPosicao(0, col).equals(this.tabDoJogo.getMarcaNaPosicao(2, col)))
                    return this.tabDoJogo.getMarcaNaPosicao(0, col);

            // diagonal principal
            if (this.tabDoJogo.haMarcaNaPosicao(0, 0) &&
                this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(1, 1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0, 0).equals(this.tabDoJogo.getMarcaNaPosicao(2, 2)))
                return this.tabDoJogo.getMarcaNaPosicao(0, 0);

            // diagonal secundaria
            if (this.tabDoJogo.haMarcaNaPosicao(0, 2) &&
                this.tabDoJogo.getMarcaNaPosicao(0, 2).equals(this.tabDoJogo.getMarcaNaPosicao(1, 1)) &&
                this.tabDoJogo.getMarcaNaPosicao(0, 2).equals(this.tabDoJogo.getMarcaNaPosicao(2, 0)))
                return this.tabDoJogo.getMarcaNaPosicao(0, 2);
        }
        catch (Exception erro)
        {} // ignorando pois sei que nao uso posicao invalida

        return null;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        try
        {
            for (int lin = 0; lin < 3; lin++)
                for (int col = 0; col < 3; col++)
                    if (!this.tabDoJogo.haMarcaNaPosicao(lin, col))
                        return false;
        }
        catch (Exception erro)
        {} // ignorando pois sei que nao uso posicao invalida

        return true;
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false
        if (this.getMarcaDoVencedor() != null)
            return true;

        if (this.tabuleiroCheio())
            return true;

        return false;
    }

    @Override
    public String toString ()
    {
        // faça
        return "Analista do tabuleiro:\n" + this.tabDoJogo.toString();
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (this == obj) return true;

        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;

        AnalistaSituacional anl = (AnalistaSituacional) obj;

        if (!this.tabDoJogo.equals(anl.tabDoJogo)) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        // faça
        int ret = 7;

        ret = ret * 11 + this.tabDoJogo.hashCode();

        return ret;
    }
}
