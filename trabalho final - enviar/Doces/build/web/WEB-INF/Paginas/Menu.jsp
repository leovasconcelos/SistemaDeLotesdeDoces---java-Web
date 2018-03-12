
<%@page import="Dao.UsuarioDao"%>
<%@page import="Beans.Usuario"%>
<%@page import="Beans.Chat"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Agora foi Patiss�rie</title>

  <meta name="description" content="">
  <meta name="theme-color" content="#444444">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="shortcut icon" href="img/favicon.png">
  <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon.png">
  <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
  <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">

  <link rel="stylesheet" href="css/styles.css">
</head>
<body>




<div class="banner">
  <div class="header">
    <div class="header-inner container clear">
      <a class="logo" href="#"><span class="sr">#resto Logo</span></a>
      <input type="checkbox" id="navigation-toggle-checkbox" name="navigation-toggle-checkbox" class="navigation-toggle-checkbox sr">
      <label for="navigation-toggle-checkbox" class="navigation-toggle-label" onclick>
        <span class="navigation-toggle-label-inner">
          <span class="sr">Navigation</span>
        </span>
      </label>
      <div class="navigation">
        <ul class="navigation-menu">
          <li class="navigation-item">
              <form action="Controller" method="POST"><input type="submit" value="Home">
            <input type="hidden" name="tarefa" value="LevarHome"></form>
             </li>

        </ul>
        <ul class="navigation-social">
          <li class="navigation-item-social"><a class="social social-twitter" href="#"><span class="sr">Twitter</span></a></li>
          <li class="navigation-item-social"><a class="social social-facebook" href="#"><span class="sr">Facebook</span></a></li>
          <li class="navigation-item-social"><a class="social social-google-plus" href="#"><span class="sr">Google Plus</span></a></li>
        </ul>
      </div>
    </div>
  </div>
  <div class="banner-inner container">
    <h1 class="banner-lead">
      <span class="banner-lead-1">Bem-vindo!</span>
    </h1>
    <div class="banner-buttons">
        <form action="Controller" method="POST">
            <input type="submit" class="button button-secondary" value="Atualizar Cadastro!">
            <input type="hidden" name="tarefa" value="LevarParaAtualziarCadastro"> 
        </form> 
        <br>
            <form action="Controller" method="POST">
            <input type="submit" class="button button-secondary" value="Buscar lotes!">
            <input type="hidden" name="tarefa" value="BuscarLotes">
        </form>   
        <br>
        <form action="Controller" method="POST">
            <input type="submit" class="button button-secondary" value="Cadastrar Tipo!">
            <input type="hidden" name="tarefa" value="LevarCadastrarTipo">
        </form>       
        <br>
        <form action="Controller" method="POST">
            <input type="submit" class="button button-secondary" value="Cadastrar Doce!">
            <input type="hidden" name="tarefa" value="LevarCadastrarDoce">
        </form>
        <br>
                <form action="Controller" method="POST">
            <input type="submit" class="button button-secondary" value="Cadastrar lote!">
            <input type="hidden" name="tarefa" value="LevarCadastrarLote">
        </form>        
        <br>
         
      <h2 class="heading-secondary">
        <%
            // fazer uma notifica��o de mensagens tipo suas mensagens
            
            Collection<Chat> jg1 = (Collection<Chat>) request.getSession().getAttribute("Mensagens");
            
            for(Chat jgs : jg1){
                Usuario us2 = new UsuarioDao().buscaID(String.valueOf( jgs.getDeQuem()));
                out.println("<li>"+jgs.getMensagem()+ "- de: " + us2.getNome() +"</li><br>");
            }
        %>
      </h2>
        <form action="Controller" method="POST">
            <input type="submit" class="button button-primary" value="Chat">
            <input type="hidden" name="tarefa" value="LevarAchat">
        </form>
        <br>

        
        <form action="Controller" method="POST">
            <input type="submit" class="button button-primary" value="Logoff">
            <input type="hidden" name="tarefa" value="Logoff">
        </form>
 
     
    </div>
  </div>
</div>


    
    
<div id="reservations" class="content-block reservations-block">
  <div class="reservations-block-inner container">
    <div class="clear">
      <div class="reservation-block-img col-3-l none block-l">
        <img class="img-fluid " src="img/food-01.jpg" alt="Food">
      </div>
      <div class="reservation-block-img col-6-m col-3-l none block-m">
        <img class="img-fluid " src="img/food-02.jpg" alt="Food">
      </div>
      <div class="reservation-block-form col-6-m">
        <div class="text-center">
          <h2 class="heading">Contato</h2>
          <p>
            Caso tenha alguma d�vida, sugest�o ou reclama��o, n�o hesite em contatar-nos!
          </p>
        </div>
        <form class="reservations-form">
          <fieldset class="reservations-form-wrap">
            <legend class="sr">Contact Us</legend>
            <div class="clear">
              <div class="col-6-m pad-top-10 pad-bottom-10">
                <label class="block strong" for="name">Nome</label>
                <input name="full-name" class="field" id="name" type="text" placeholder="Nome completo:">
              </div>
              <div class="col-6-m pad-top-10 pad-bottom-10">
                <label class="block strong" for="email">e-mail</label>
                <input name="email" class="field" id="email" type="email" placeholder="e-mail*">
              </div>
            </div>
            <div class="clear">
              <div class="col-6-m pad-top-10 pad-bottom-10">
                <label class="block strong" for="date">Telefone</label>
                <input name="date-of-booking" class="field" id="date" type="text" placeholder="Telefone com DDD">
              </div>
              <div class="col-6-m pad-top-10 pad-bottom-10">
                <label class="block strong" for="party-size">Tipo de pedido:</label>
                <span class="select">
                  <select class="field" name="party-size" id="party-size">
                    <option value="1">Bolos</option>
                    <option value="2">P�es</option>
                    <option value="3">Doces</option>
                  </select>
                </span>
              </div>
            </div>
            <div class="text-center">
              <input type="submit" class="button reservations-submit" value="Book now!">
            </div>
          </fieldset>
        </form>
      </div>
    </div>
  </div>
</div>



<div class="footer">
  <div class="footer-inner container">
    <div class="clear">
      <div class="footer-column col-4-l">
        <h3 class="footer-heading">Sobre n�s</h3>
        <p>
          A Java Cakes traz uma experi�ncia de patiss�rie <strong>verdadeiramente</strong> aut�ntica, incluindo os melhores bolos, doces e boulang�rie pr�pria.
        </p>
      </div>
    
      <div class="footer-column col-4-l">
        <h3 class="footer-heading">Nosso endere�o</h3>
        <p>
          Av. Salgado Filho, 3501 <br>
          Vila Rio de Janeiro, Guarulhos - SP
        </p>
        <ul class="footer-social-list icon-list-inline">
          <li class="navigation-item-social"><a class="social social-twitter" href="#"><span class="sr">Twitter</span></a></li>
          <li class="navigation-item-social"><a class="social social-facebook" href="#"><span class="sr">Facebook</span></a></li>
          <li class="navigation-item-social"><a class="social social-google-plus" href="#"><span class="sr">Google Plus</span></a></li>
          <li class="navigation-item-social"><a class="social social-youtube" href="#"><span class="sr">YouTube</span></a></li>
        </ul>
      </div>
    </div>
  </div>
</div>

<script src="js/vendor/wow.js"></script>
<script src="js/vendor/webfontloader.js"></script>
<script src="js/default.js"></script>

</body>
</html>


    
