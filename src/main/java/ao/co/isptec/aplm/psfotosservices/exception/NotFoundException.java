
package ao.co.isptec.aplm.psfotosservices.exception;


public class NotFoundException extends RuntimeException{
    public NotFoundException(Integer id)
    {
        super("Não foi possível encontrar o usuário pesquisado "+id);
    }
}
