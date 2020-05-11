package br.com.koike.agendaong.entity;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name = "usuario")
public class User implements UserDetails {

	public User() {}
	
	public User(String username, String email) {
		this.username = username;
		this.email=email;
	}
	   
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, insertable = false)
    private long id;
    
    @Column(updatable = false, insertable = true, unique = true)
    @NotNull
    @NotEmpty
    private String username;
    
    //@Column(updatable = true, insertable = true)
    @NotEmpty
    private String password;

    //@ElementCollection(fetch = FetchType.EAGER)
    @Transient
    private List<String> roles = new ArrayList<>();

    @NotNull
    private String email;
  
    @Column(name = "fone_ddd" )
    private int foneDdd;
    
    @Column(name = "fone_numero")
    private int foneNumero;
    
    private String endereco;
    
    private String cidade;
    
    @Column(name = "uf", length = 2)
    private String uf;
    
    private String cep;
    
    private String nome;
    
    @Column(name = "cpf_cnpj", length = 15)
    private int cpfCnpj;
    
    private String observacoes;
    
    @Column(name = "contato_nome")
    private String contatoNome;
    
    @Column(name = "contato_fone")
    private int contatoFone;
    
    @Column(name = "contato_ddd")
    private int contatoDdd;
    
    @CreationTimestamp
    @Column(name = "dt_criacao", updatable = false, insertable = true)
    private Date dataCriacao;
    
    @Column(name = "flag_ativo")
    private int flagAtivo;
    
    @Column(name = "tipo_usuario")
    private int tipoUsuario;
 
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getFoneDdd() {
		return foneDdd;
	}

	public void setFoneDdd(int foneDdd) {
		this.foneDdd = foneDdd;
	}

	public int getFoneNumero() {
		return foneNumero;
	}

	public void setFoneNumero(int foneNumero) {
		this.foneNumero = foneNumero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(int cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getContatoNome() {
		return contatoNome;
	}

	public void setContatoNome(String contatoNome) {
		this.contatoNome = contatoNome;
	}

	public int getContatoFone() {
		return contatoFone;
	}

	public void setContatoFone(int contatoFone) {
		this.contatoFone = contatoFone;
	}

	public int getContatoDdd() {
		return contatoDdd;
	}

	public void setContatoDdd(int contatoDdd) {
		this.contatoDdd = contatoDdd;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public int getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(int flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
    
}