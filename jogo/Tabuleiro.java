package jogo;

public class Tabuleiro implements Cloneable
{
    private Marca matriz [][];

    public Tabuleiro ()
    {
        this.matriz = new Marca [3][3];
    }
    private void valida (int lin, int col) throws Exception
    {
        if (lin < 0 || lin > 2 || col < 0 || col > 2)
            throw new Exception ("Posicao invalida");
    }

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        valida (lin, col);
        return this.matriz[lin][col] != null;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        valida (lin, col);
        return this.matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        valida (lin, col);
        if (mrc == null)
            throw new Exception ("Marca ausente");
        this.matriz[lin][col] = mrc;
    }

    @Override
    public String toString ()
    {
        StringBuilder sb = new StringBuilder ();
        for (int l = 0; l < 3; l++)
        {
            for (int c = 0; c < 3; c++)
            {
                sb.append (this.matriz[l][c] == null ? " " : this.matriz[l][c]);
                if (c < 2) sb.append (" | ");
            }
            sb.append ("\n");
            if (l < 2) sb.append ("---------\n");
        }
        return sb.toString ();
    }

    @Override
    public boolean equals (Object obj)
    {
        if (this == obj) return true;

        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;

        Tabuleiro tab = (Tabuleiro) obj;

        for (int l = 0; l < 3; l++)
            for (int c = 0; c < 3; c++)
            {
                if (this.matriz[l][c] == null)
                {
                    if (tab.matriz[l][c] != null) return false;
                }
                else if (!this.matriz[l][c].equals(tab.matriz[l][c])) return false;
            }

        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 7;

        for (int l = 0; l < 3; l++)
            for (int c = 0; c < 3; c++)
                ret = ret * 11 + (this.matriz[l][c] == null ? 0 : this.matriz[l][c].hashCode());

        return ret;
    }

    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        this ();
        if (modelo == null)
            throw new Exception ("Modelo ausente");
        for (int l = 0; l < 3; l++)
            for (int c = 0; c < 3; c++)
                this.matriz[l][c] = modelo.matriz[l][c]; // copia as referencias das Marcas, ok pois Marca e imutavel
    }

    @Override
    public Object clone ()
    {
        try
        {
            return new Tabuleiro (this);
        }
        catch (Exception e)
        {
            return null; // nunca acontece: this nao e null
        }
    }
}