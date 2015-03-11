package escola;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco_de_dados.dao.Alunos;
import banco_de_dados.dao.Responsaveis;

/**
 * Servlet implementation class Remover
 */
@WebServlet("/Remover")
public class Remover extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Remover() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
        	out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Edi��o de Respons�veis</title>"); 
	        out.println("<link rel=\"stylesheet\" href=\"resources/styles/style.css\" type=\"text/css\"/>");
	        out.println("<script src='resources/scripts/jquery.js'> </script>");
	        out.println("<script src='resources/scripts/script-mascara.js'> </script>");
	        out.println("<script src='resources/scripts/script-cadastro-responsaveis.js'> </script>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div>");
	            
	        out.println("<div class=\"menu-holder\"> \n" +
"                <ul>\n" +
"                    <li>\n" +
"                        <a href=\"index.jsp \"  id=\"home-item\"><img src=\"resources/images/home.ico\" class=\"home-image\"></a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroAlunos\"  >Cadastro de Alunos</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroResponsaveis\" >Cadastro de Respons�veis</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarAluno\" >Editar Aluno</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarResponsavel\" >Editar Respons�vel</a>\n" +
"                    </li>\n"+"<li>"+
						"<a href='Remover' class=\"menu-item-selected\">Remover</a>"+
					"</li>"
	                    + "<li>\n" +
"                        <a href=\"Busca\" id=\"search-item\"><img src=\"resources/images/search-item.png\" class=\"search-image\"></a>\n" +
"                    </li>" +
"                </ul>\n" +
"            </div>");
	            
	        out.println("</div>");
	        out.println("<div class='conteudo'>");
	        out.println("<form id='formulario' class='rounded' method='post' action='Remover' onsubmit='return validaResponsavel(this)'>");
	        
	        
	        if(request.getParameter("ra") != null){
	        	try{
	        		Alunos alunos = new Alunos();
	        		alunos.removerAluno(request.getParameter("ra"));
	        		out.println("<h2>Remo��o de Alunos</h2>");
	        		out.println("<div class='mensagem'>O Aluno For Excluido Com Sucesso</div>");
                    out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('Remover');\"/>");
	        	}catch(Exception e){
	        		out.println("<h2>Remo��o de Alunos</h2>");
	        		out.println("<div class='mensagem'>" +e.getMessage()+"</div>");
	        		out.println("<div class='field'><label for='RA'>RA:</label><input type='text' class='input ra' name='ra' id='ra' maxlength='5'/><p class='hint'>Insira o RA</p></div>");
                    out.println("<input type='submit' name='Submit'  class='submit' value='Remover Aluno' />");
                    out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('Remover');\"/>");
	        	}
	        }else if(request.getParameter("emailResp")!= null){
	        	try{
	        		Responsaveis responsaveis = new Responsaveis();
	        		responsaveis.removerResponsavel(request.getParameter("emailResp"));
	        		out.println("<h2>Remo��o de Respons�veis</h2>");
	        		out.println("<div class='mensagem'>O Aluno For Excluido Com Sucesso</div>");
                    out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('Remover');\"/>");
	        	}catch(Exception e){
	        		out.println("<h2>Remo��o de Respons�veis</h2>");
	        		out.println("<div class='mensagem'>" +e.getMessage()+"</div>");
	        		out.println("<div class='field'><label for='emailResp'>Email:</label><input type='text' class='input'  name='emailResp' id='emailResp' maxlength='100'/><p class='hint'>Insira o Email</p></div>");
	        		out.println("<input type='submit' name='Submit'  class='submit' value='Remover Respons�vel' />");
                    out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('Remover');\"/>");
	        	}
	        }else if(request.getParameter("opcao") != null){
	        	int opcao = Integer.parseInt(request.getParameter("opcao"));
	        	if(opcao == 0){
	        		out.println("<h2>Remo��o de Alunos</h2>");
	        		out.println("<div class='field'><label for='RA'>RA:</label><input type='text' class='input ra' name='ra' id='ra' maxlength='5'/><p class='hint'>Insira o RA</p></div>");
                    out.println("<input type='submit' name='Submit'  class='submit' value='Remover Aluno' />");
                    out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('Remover');\"/>");

	        	}else{
	        		out.println("<h2>Remo��o de Respons�veis</h2>");
	        		out.println("<div class='field'><label for='emailResp'>Email:</label><input type='text' class='input'  name='emailResp' id='emailResp' maxlength='100'/><p class='hint'>Insira o Email</p></div>");
	        		out.println("<input type='submit' name='Submit'  class='submit' value='Remover Respons�vel' />");
                    out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('Remover');\"/>");
	        	}
	        }else{
	        	out.println("<h2>Remo��o</h2>");
		        out.println("<div class='field'><label for='tipoBusca'>Tipo de Remo��o:</label><select class='input' name='opcao'><option value='0'>Aluno</option><option value='1'>Respons�vel</option></select> <p class='hint'>Selecione o Tipo de Remo��o Que Voc� Deseja</p></div>");
	            out.println("<input type='submit' name='Submit'  class='submit' value='Enviar' />");
	        }
	            
	            
	        out.println("</form>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
        }finally{
        	out.close();
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}