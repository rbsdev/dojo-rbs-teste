import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;


public class PaginaFormularioCadastro {
	private WebDriver driver;

	public PaginaFormularioCadastro(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void selecionaPessoaFisica(){
		driver.findElement(By.id("legalEntity.F")).click();
		
	}
	public void selecionaPessoaJuridica(){
		driver.findElement(By.id("legalEntity.J")).click();
	}
	public void escreveNome(String nome){
		driver.findElement(By.id("firstName")).sendKeys(nome);
	}
	public void escreveUsuario(String usuario){
		driver.findElement(By.id("userName")).sendKeys(usuario);
	}
	public void escreveSenha(String senha){
		driver.findElement(By.id("password")).sendKeys(senha);
	}
	public void reEscreveSenha(String senha){
		driver.findElement(By.id("password2")).sendKeys(senha);
	}
	public void escreveEmail(String email){
		driver.findElement(By.id("email")).sendKeys(email);
	}
	public void queroInfoGrupo(){
		driver.findElement(By.id("complement.rbsEmail")).click();
	}
	public void queroInfoParceirosGrupo(){
		driver.findElement(By.id("complement.otherEmail")).click();
	}
	public void aceitaTermo(){
		driver.findElement(By.id("acceptTerms")).click();
	}
	public void cadastrar(){
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	}
	public void verificaNomeVazio(){
		assertEquals("Voc� precisa informar seu nome", driver.findElement(By.id("alert.firstName")).getText());
	}
	public void verificaUsernameVazio(){
		assertEquals("Voc� precisa informar seu usu�rio", driver.findElement(By.id("alert.userName")).getText());
	}
	public void verificaPassVazio(){
		assertEquals("Voc� precisa informar sua senha", driver.findElement(By.id("alert.password")).getText());
	}
	public void verificaSenhaDif(){
		assertEquals("Senhas n�o coincidem", driver.findElement(By.id("alert.password2")).getText());
	}
	public void verificaEmailVazio(){
		assertEquals("Voc� precisa informar um e-mail v�lido", driver.findElement(By.id("alert.email")).getText());
	}
	public void verificaMsgSucesso(String email){
		assertEquals("Obrigado.\nAgora s� falta ativar seu cadastro", driver.findElement(By.cssSelector("h3")).getText());
		assertEquals("Um e-mail de ativa��o foi enviado para "+email, driver.findElement(By.cssSelector("p.alerta-a")).getText());
	}
	public void verificaUserDup(String username){
		assertEquals(username+" n�o est� dispon�vel", driver.findElement(By.id("available.userName")).getText());
	}

}
