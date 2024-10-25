package asdasf.daf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import cadastro.projeto.enums.ESTADO;

@EntityScan
@Entity
@Table(name = "ENDERECO")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_IDENDERECO;

	@Column(name = "CEP")
	@NotEmpty(message = "O campo 'CEP' não pode ser vazio!")
	@Size(min = 1, max = 255, message = "Minimo de 5 caracteres")
	private String CEP;

	@Column(name = "RUA")
	@NotEmpty(message = "O campo 'rua' não pode ser vazio!")
	@Size(min = 5, max = 255, message = "Minimo de 5 caracteres")
	private String RUA;

	@Column(name = "NUMEROENDERECO")
	@Range(min = 1, max = 10000, message = "Digite o número da casa!")
	private int NUMEROENDERECO;

	@Column(name = "COMPLEMENTO")
	private String COMPLEMENTO;

	@Column(name = "BAIRRO")
	@NotEmpty(message = "O campo 'bairro' não pode ser vazio!")
	@Size(min = 5, max = 255, message = "Minimo de 5 caracteres")
	private String BAIRRO;

	@Column(name = "CIDADE")
	@NotEmpty(message = "O campo 'cidade' não pode ser vazio!")
	@Size(min = 5, max = 255, message = "Minimo de 5 caracteres")
	private String CIDADE;

	@Column(name = "ESTADO")
	@Enumerated
	@NotNull(message = "O campo 'Estado' não pode ser vazio!")
	private ESTADO ESTADO;

	@Column(name = "PAIS")
	@NotEmpty(message = "O campo 'País' não pode ser vazio!")
	@Size(min = 5, max = 255, message = "Minimo de 5 caracteres")
	private String PAIS;

	@Column(name = "FK_USUARIO")
	@NotNull(message = "O campo 'Id do morador' não pode ser vazio!")
	private int FK_USUARIO;

//	@OneToMany(cascade = CascadeType.ALL , mappedBy = "FK_ID_USUARIO_RL")
////	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "PK_ID_USUARIO")
//	private List <Usuario_Endereco> endereco;

	public Endereco() {
	}

//	public List<Usuario_Endereco> getEndereco() {
//		return endereco;
//	}
//
//
//	public void setEndereco(List<Usuario_Endereco> endereco) {
//		this.endereco = endereco;
//	}

	public int getPK_IDENDERECO() {
		return PK_IDENDERECO;
	}

	public void setPK_IDENDERECO(int pK_IDENDERECO) {
		PK_IDENDERECO = pK_IDENDERECO;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getRUA() {
		return RUA;
	}

	public void setRUA(String rUA) {
		RUA = rUA;
	}

	public int getNUMEROENDERECO() {
		return NUMEROENDERECO;
	}

	public void setNUMEROENDERECO(int nUMEROENDERECO) {
		NUMEROENDERECO = nUMEROENDERECO;
	}

	public String getCOMPLEMENTO() {
		return COMPLEMENTO;
	}

	public void setCOMPLEMENTO(String cOMPLEMENTO) {
		COMPLEMENTO = cOMPLEMENTO;
	}

	public String getBAIRRO() {
		return BAIRRO;
	}

	public void setBAIRRO(String bAIRRO) {
		BAIRRO = bAIRRO;
	}

	public String getCIDADE() {
		return CIDADE;
	}

	public void setCIDADE(String cIDADE) {
		CIDADE = cIDADE;
	}

	public ESTADO getESTADO() {
		return ESTADO;
	}

	public void setESTADO(ESTADO eSTADO) {
		ESTADO = eSTADO;
	}

	public String getPAIS() {
		return PAIS;
	}

	public void setPAIS(String pAIS) {
		PAIS = pAIS;
	}

	public int getFK_USUARIO() {
		return FK_USUARIO;
	}

	public void setFK_USUARIO(int fK_USUARIO) {
		FK_USUARIO = fK_USUARIO;
	}

}