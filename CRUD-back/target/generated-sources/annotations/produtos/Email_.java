package produtos;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Email.class)
public abstract class Email_ {

	public static volatile SingularAttribute<Email, Integer> remetente;
	public static volatile SingularAttribute<Email, Integer> codigo;
	public static volatile SingularAttribute<Email, String> mensagm;
	public static volatile SingularAttribute<Email, Integer> destinatario;

}

