import java.util.Date;

import org.junit.Test;


public class CadastraUsuarioWRSTest extends Teste{
	
	static Usuario username = new Usuario(new Date().toString());

	
	@Test 
	public void cenario1(){
		PaginaFormularioCadastro cadastro=new PaginaFormularioCadastro(driver);
		cadastro.escreveNome("Ciclano do Selenium");
		cadastro.escreveUsuario(username.getUsername());
		cadastro.escreveSenha("teste");
		cadastro.reEscreveSenha("teste");
		cadastro.escreveEmail("ciclanoselenium@mailinator.com");
		cadastro.aceitaTermo();
		cadastro.cadastrar();
		cadastro.verificaMsgSucesso("ciclanoselenium@mailinator.com");
	}
	@Test
	public void cenario2(){
		PaginaFormularioCadastro cadastro=new PaginaFormularioCadastro(driver);
		cadastro.escreveNome("Ciclano do Selenium");
		cadastro.escreveUsuario(username.getUsername());
		cadastro.escreveSenha("teste");
		cadastro.reEscreveSenha("teste");
		cadastro.escreveEmail("ciclanoselenium@mailinator.com");
		cadastro.aceitaTermo();
		cadastro.cadastrar();
		cadastro.verificaUserDup(username.getUsername());
	}
	@Test 
	public void cenario3(){
		PaginaFormularioCadastro cadastro=new PaginaFormularioCadastro(driver);
		cadastro.cadastrar();
		cadastro.verificaNomeVazio();
		cadastro.escreveNome("Teste");
		cadastro.cadastrar();
		cadastro.verificaUsernameVazio();
		cadastro.escreveUsuario("testeselenium5");
		cadastro.escreveSenha("");
		cadastro.cadastrar();
		cadastro.verificaPassVazio();
		cadastro.escreveSenha("Teste");
		cadastro.cadastrar();
		cadastro.verificaSenhaDif();
		cadastro.reEscreveSenha("Teste");
		cadastro.cadastrar();
		cadastro.verificaEmailVazio();
	}
	

}
