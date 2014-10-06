<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="UPMC Project - SNCF">
    <meta name="author" content="UPMC">
    <link rel="icon" href="../../favicon.ico">

    <title>Projet UPMC - Transilien SNCF 2014/2015</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/cover.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>

  </head>

  <body>

    <div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <li class="masthead-brand">Projet UPMC</li>
              <ul class="nav masthead-nav">
                <li><a href="#">Home</a></li>
                <li><a href="#">Login</a></li>
                <li><a href="#">Contact/Credits</a></li>
              </ul>
            </div>
          </div>
          <div class="inner cover">
          <p class="bg-primary">
            <h1>Envoi ton colis ! </h1>
            <p>Achete des objets sur ebay ou le bon coin et organise le transport de ton colis ! <br>
            Des milliers de personnes voyagent chaque jour sur le reseau transilien et peuvent livrer ton colis ! </p>
            
            <h1>Livre des colis ! </h1>
            <p>Tu utilise chaque matin le reseau transilien pour aller à ton travail? Livre des colis ! Une superbe façon d'amortir, chaque matin avant de commencer à travailler ! </p>
            
           </p> 
            <p class="lead" >
            
<form class="form-inline" role="form" action="/sncf_upmc">
  <div class="form-group">
    <label class="sr-only" for="depart">Station de départ</label>
    <input type="text" class="form-control" id="depart" placeholder="D&eacute;part">
  </div>
  <div class="form-group">
    <label class="sr-only" for="arrivee">Station d'arrivée</label>
    <input type="text" class="form-control" id="arrivee" placeholder="Arriv&eacute;e">
  </div>
  <br>
  <div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios1" value="option1" checked>
    Je livre !
  </label>
</div>
<div class="radio">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios2" value="option2">
   J'envoi/receptionne un colis !
  </label>
</div>
<br>
  <button type="submit" class="btn btn-primary">Rechercher</button>
</form>
            	<!-- changer lien, pour rediriger sur javascript et faire un appel ajax -->
            </p>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>UPMC Projects - 2014/2015</p>
            </div>
          </div>

        </div>

      </div>

    </div>
  </body>
</html>