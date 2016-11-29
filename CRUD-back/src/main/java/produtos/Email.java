package produtos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", schema = "public")
public class Email implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private Integer remetente;
    private Integer destinatario;
    private String mensagm;

    public Email() {
    }

    public Email(Integer codigo, Integer remetente, Integer destinatario, String mensagm) {
        this.codigo = codigo;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.mensagm = mensagm;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getRemetente() {
        return remetente;
    }

    public void setRemetente(Integer remetente) {
        this.remetente = remetente;
    }

    public Integer getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Integer destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensagm() {
        return mensagm;
    }

    public void setMensagm(String mensagm) {
        this.mensagm = mensagm;
    }
    
    
    
}
