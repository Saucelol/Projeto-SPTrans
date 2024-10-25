package asdasf.daf.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Usuario_Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_ID_RELACIONAL;

//	@ManyToOne
//	@JoinColumn(name = "PK_ID_USUARIO", referencedColumnName = "FK_ID_USUARIO_RL")
//	private Usuario Usuario_RL;
//	
//	@ManyToOne
//	@JoinColumn(name = "PK_IDENDERECO", referencedColumnName = "FK_IDENDERECO_RL")
//	private Endereco Endereco_RL;
}
