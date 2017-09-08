package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 *
 * @author André Bazani Cordeiro
 */

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable {
 
    //Não vou utilizar número sequancial como primary key
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(length=11, name="cpf", nullable=false)
    private Long cpf;
 
    @Column(length=20, name="nome", nullable=false)
    private String nome;
    
    @Column(length=60, name="sobrenome", nullable=false)
    private String sobrenome;
    
    @Column(length=2, name="idade")
    private String idade;
    
    @Column(length=30, name="funcao", nullable=false)
    private String funcao;  
    
 
    public Long getCpf() {
        return cpf;
    }
 
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }
 
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    
    public String getIdade() {
        return idade;
    }
 
    public void setIdade(String idade) {
        this.idade = idade;
    }
    
    public String getFuncao() {
        return funcao;
    }
 
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}