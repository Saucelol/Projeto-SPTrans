package asdasf.daf.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int PK_ID_USUARIO;

	@Column(name = "NOME_USUARIO")
	@NotEmpty(message = "O campo 'nome' não pode ser vazio!")
	@Size(min = 5 , max = 255 , message = "Minimo de 5 caracteres")
	private String NOME_USUARIO;

	@Column(name = "EMAIL")
	@Email(message = "Digite um E-mail valido")
	@NotEmpty(message = "O campo 'E-mail' não pode ser vazio!")
	private String EMAIL;

	@Column(name = "TELEFONE")
	@NotEmpty(message = "O campo 'telefone' não pode ser vazio!")
	@Size(min = 5 , max = 255 , message = "Minimo de 5 caracteres")
	private String TELEFONE;

	@Column(name = "CPF")
	@NotEmpty(message = "O campo 'CPF' não pode ser vazio!")
	@Size(min = 5 , max = 255 , message = "Minimo de 5 caracteres")
	private String CPF;

	@Column(name = "RG")
	@NotEmpty(message = "O campo 'RG' não pode ser vazio!")
	@Size(min = 5 , max = 255 , message = "Minimo de 5 caracteres")
	private String RG;

	@Column(name = "DATA_NASC")
	@NotEmpty(message = "O campo 'Data de nascimento' não pode ser vazio!")
	@Size(min = 5 , max = 255 , message = "Minimo de 5 caracteres")
	private String DATA_NASC;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "PK_ID_BILHETE")
//	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "PK_ID_USUARIO")
	private List<Bilhete> bilhete;

//	@Cascade(CascadeType.ALL)
	@ManyToMany
	@JoinTable(
			name = "USUARIO_ENDERECO",
			joinColumns = @JoinColumn(name = "FK_ID_USUARIO_RL"),
			inverseJoinColumns = @JoinColumn(name = "FK_IDENDERECO_RL"))
	private List <Endereco> endereco ;

//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "FK_ID_USUARIO_RL")
////	@JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "PK_ID_USUARIO")
//	private List<Usuario_Endereco> endereco;

	public Usuario() {
	}

	public int getPK_ID_USUARIO() {
		return PK_ID_USUARIO;
	}

	public void setPK_ID_USUARIO(int pK_ID_USUARIO) {
		PK_ID_USUARIO = pK_ID_USUARIO;
	}

	public String getNOME_USUARIO() {
		return NOME_USUARIO;
	}

	public void setNOME_USUARIO(String nOME_USUARIO) {
		NOME_USUARIO = nOME_USUARIO;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getTELEFONE() {
		return TELEFONE;
	}

	public void setTELEFONE(String tELEFONE) {
		TELEFONE = tELEFONE;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getDATA_NASC() {
		return DATA_NASC;
	}

	public void setDATA_NASC(String dATA_NASC) {
		DATA_NASC = dATA_NASC;
	}

	public List<Bilhete> getBilhete() {
		return bilhete;
	}

	public void setBilhete(List<Bilhete> bilhete) {
		this.bilhete = bilhete;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	
	
}