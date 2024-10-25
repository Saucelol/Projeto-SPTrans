package asdasf.daf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import cadastro.projeto.enums.ATIVO;
import cadastro.projeto.enums.TIPOBILHETE;

@EntityScan
@Entity
@Table(name = "bilhete")
public class Bilhete {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_ID_BILHETE;

	@Column(name = "TIPOBILHETE")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo 'tipo de bilhete' não pode ser vazio!")
	private TIPOBILHETE TIPOBILHETE;

	@Column(name = "DATA_EMISSAO")
	@NotEmpty(message = "O campo 'data de emissão' não pode ser vazio!")
	@Size(min = 5, max = 255, message = "Minimo de 5 caracteres")
	private String DATA_EMISSAO;

	@Column(name = "DATA_VALIDADE")
	@NotEmpty(message = "O campo 'data de valiadade' não pode ser vazio!")
	@Size(min = 5, max = 255, message = "Minimo de 5 caracteres")
	private String DATA_VALIDADE;

	@Column(name = "ATIVO")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Selecione uma opção!")
	private ATIVO ATIVO;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "PK_ID_BILHETE")
////	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "PK_ID_USUARIO")
//	private List<Endereco> endereco;
//	@Column(name = "FK_ID_USUARIO")
	
	@ManyToOne
	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "PK_ID_USUARIO")
	@NotNull(message = "Digite um Id de proprietário valido!")
	private Usuario FK_ID_USUARIO;

	public Bilhete() {

	}

	public int getPK_ID_BILHETE() {
		return PK_ID_BILHETE;
	}

	public void setPK_ID_BILHETE(int pK_ID_BILHETE) {
		PK_ID_BILHETE = pK_ID_BILHETE;
	}

	public TIPOBILHETE getTIPOBILHETE() {
		return TIPOBILHETE;
	}

	public void setTIPOBILHETE(TIPOBILHETE tIPOBILHETE) {
		TIPOBILHETE = tIPOBILHETE;
	}

	public String getDATA_EMISSAO() {
		return DATA_EMISSAO;
	}

	public void setDATA_EMISSAO(String dATA_EMISSAO) {
		DATA_EMISSAO = dATA_EMISSAO;
	}

	public String getDATA_VALIDADE() {
		return DATA_VALIDADE;
	}

	public void setDATA_VALIDADE(String dATA_VALIDADE) {
		DATA_VALIDADE = dATA_VALIDADE;
	}

	public ATIVO getATIVO() {
		return ATIVO;
	}

	public void setATIVO(ATIVO aTIVO) {
		ATIVO = aTIVO;
	}

	public Usuario getFK_ID_USUARIO() {
		return FK_ID_USUARIO;
	}

	public void setFK_ID_USUARIO(Usuario fK_ID_USUARIO) {
		FK_ID_USUARIO = fK_ID_USUARIO;
	}

}