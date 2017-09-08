
package dao;
 
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Funcionario;
 
/**
 *
 * @author André Bazani Cordeiro
 */
 
@Stateless
public class FuncionarioDAO {
 
    @PersistenceContext(unitName="ProvaEcadPU")
    private EntityManager em;
 
    public boolean gravar(Funcionario funcionario){
        boolean sucesso = false;
        try {
            em.merge(funcionario);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public Funcionario selecionar(Long cpf){
        Funcionario funcionario = null;
        try {
            funcionario = em.find(Funcionario.class, cpf);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return funcionario;
    }
 
    public boolean remover(Funcionario funcionario){
        boolean sucesso = false;
        try {
            funcionario = em.find(Funcionario.class, funcionario.getCpf());
            em.remove(funcionario);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
    }
 
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = null;
        try {
            Query query = em.createQuery("Select c from Funcionario c");
            funcionarios = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        return funcionarios;
    }
}