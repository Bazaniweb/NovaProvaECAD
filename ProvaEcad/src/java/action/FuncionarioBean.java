
package action;
 
import dao.FuncionarioDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import model.Funcionario;
 
/**
 *
 * @author André Bazani Cordeiro
 */
@Named(value = "funcionarioBean")
@SessionScoped
public class FuncionarioBean implements Serializable {
 
    @EJB
    private FuncionarioDAO funcionarioDAO;
    private Funcionario funcionario = new Funcionario();
    private List<Funcionario> funcionarios;
 
    public void novo(){
        funcionario = new Funcionario();
    }
 
    public void gravar() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = funcionarioDAO.gravar(funcionario);
 
        if (resultado) {
            funcionario = new Funcionario();
            context.addMessage(null, new FacesMessage("Funcionário " + funcionario.getNome() + " gravado com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao gravar os dados do funcionário  " + funcionario.getNome() + " !"));
        }
    }
 
    public void selecionar(ActionEvent evento) {
        Long cpf = (Long) evento.getComponent().getAttributes().get("cpf");
        funcionario = funcionarioDAO.selecionar(cpf);
    }
 
    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = funcionarioDAO.remover(funcionario);
 
        if (resultado) {
            funcionario = new Funcionario();
            context.addMessage(null, new FacesMessage("Funcionário " + funcionario.getNome() + " removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover o funcionário " + funcionario.getNome() + " !"));
        }
    }
 
    //Getters e Setters
    public Funcionario getFuncionario() {
        return funcionario;
    }
 
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
 
    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.listar();
        return funcionarios;
    }
 
    public void setClientes(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}