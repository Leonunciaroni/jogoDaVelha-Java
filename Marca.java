public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        // validar smb, garantindo que ele
        // seja 'X' ou 'O' e coloca-lo em
        // simbolo
        // dar excecao em caso de valor invalido
        if (smb != 'X' && smb != 'O') throw new Exception ("Código inválido!");

        this.simbolo = smb;
    }

    public char getSimbolo ()
    {
        return this.simbolo;
    }

    @Override
    public String toString ()
    {
        return ""+simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (this == obj) return true;

        if (obj == null) return false;

        if (this.getClass() != obj.getClass()) return false;

        Marca mrc = (Marca) obj;

        if (this.simbolo != mrc.simbolo) return false;

        return true;
    }

    @Override
    public int hashCode ()
    {
        // faça
        int ret = 7;

        ret = ret * 11 + Character.valueOf(this.simbolo).hashCode();

        return ret;
    }
}