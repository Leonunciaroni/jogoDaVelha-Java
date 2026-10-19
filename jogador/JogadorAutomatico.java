package jogador;

public class JogadorAutomatico implements Jogador
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

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
        // retorna a marca do jogador
    }

    public void facaSuaJogada ()
    {
        try
        {
            // tentando ganhar na linha 0
            if (this.tabDoJogo.matriz[0][0]==null &&
                this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,0);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]==null &&
                this.tabDoJogo.matriz[0][2]!=null && this.tabDoJogo.matriz[0][2].equals(this.marca))
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,1);
            else
            if (this.tabDoJogo.matriz[0][0]!=null && this.tabDoJogo.matriz[0][0].equals(this.marca) &&
                this.tabDoJogo.matriz[0][1]!=null && this.tabDoJogo.matriz[0][1].equals(this.marca) &&
                this.tabDoJogo.matriz[0][2]==null)
                this.tabDoJogo.setMarcaNaPosicao(this.marca, 0,2);
            else
            // tentando ganhar na linha 1
            if ... else if ... else if ...
            else
            // tentando ganhar na linha 2
            if ... else if ... else if ...
            else
            // tentando ganhar na coluna 0
            if ... else if ... else if ...
            else
            // tentando ganhar na coluna 1
            if ... else if ... else if ...
            else
            // tentando ganhar na coluna 2
            if ... else if ... else if ...
            else
            // tentando ganhar na diagonal principal
            if ... else if ... else if ...
            else
            // tentando ganhar na diagonal secundaria
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na linha 0
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na linha 1
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na linha 2
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na coluna 0
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na coluna 1
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na coluna 2
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na diagonal principal
            if ... else if ... else if ...
            else
            // tentando atrapalhar vitoria na diagonal secundaria
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na linha 0
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na linha 1
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na linha 2
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na coluna 0
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na coluna 1
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na coluna 2
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na diagonal principal
            if ... else if ... else if ...
            else
            // tentando jogada de futuro (há 1 marca do jogador e mais nada; vamos lá e plantamos outra marca) na diagonal secundaria
            if ... else if ... else if ...
            else
            // termine jogando num lugar qualquer que esteja livre
        }
        catch (Exception erro)
        {} // ignorando pois sei que n o estou usando posicao invalida nem comparando com equals um null
    }
}