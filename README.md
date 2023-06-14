Cette application contient une barre de recherche. En insérant le nom d’une ligue dans la barre de recherche, par autocomplétion, la liste des ligues s’affiche grace à l’API suivante : https://www.thesportsdb.com/api/v1/json/50130162/all\_leagues.php 

 
Ci-dessous les deux images : 

  
![](https://lh5.googleusercontent.com/VNTcDNjYbNUAhcxRplZRju-VRFv-F9p3SHcvDPk7K3FY-kWDskASrYoydUj_E_cUsDMPOYlnJ_3BHx_VkP9tfEIAONd18a2tgOVEWHL8ZlkC1UVydx1dlydfAn1Rk8fOptrRf6kMA__otjgHNxx84gY)![](https://lh3.googleusercontent.com/BaCz0KBOL3EbejEY899kLRVA8XxyHUchm5mj-RDGOPZWXrDOf5oyK_TFNlYMM7RvJYkRuQOmt0prneeC5_oISuxzrp77Bslry7ZekJ_m6R2duZCYOin_NUlPIAsLUdDh1jn3A2IwNpCJ2Bvjtr1sQxQ)

  
En sélectionnant une ligue dans le résultat de recherche, l’application nous affiche toutes les équipes de cette ligue. 

la liste des équipes d’une  ligue s’affiche grâce à l’API suivante :

https://www.thesportsdb.com/api/v1/json/50130162/search\_all\_teams.php?l=French%20Ligue%201 

Ci-après, l’image correspondante : 

  

![](https://lh4.googleusercontent.com/Lgb76lRkTKohXUBJq4MmT51BiMTlk5Jr2Ms_2wP3oXonpYwsPfEtgpEIEF_lkc8xse64DkgTXzoiDua_5zshxlB0gK9QbYihlL7fVX6t7Lxd2i9LXlk8SWPqxRmc4W-dou70BGJDT5hHs5WsPyx_0Eg)

  
Bonus : J’ai ajouté une splash Screen et un écran permettant de visualiser le détail d’une équipe.

  

Au lancement de l’application, une splash screen s’affiche : 

![](https://lh6.googleusercontent.com/1ZrNBDY7SLtztHj0IlR0B4UhJZyvtdamTjA47LNryAoMD3BAdL50XFqg2ADj4LoXHdx6A14NeHg_llAu1uxgi2Jaykjr0Ze5-h6e6j6_aJ_uSdmIfYrE0xMUIo84YK8MdR96b1hAF_NZeYO65HIM5JQ)

 
Après avoir affiché la liste des équipes, on peut sélectionner une équipe pour visualiser les informations détaillées sur celle-ci:


![](https://lh6.googleusercontent.com/vYLa0An9Bm2emDVQRChulyieICAffWZGNhkzoYtBA2IqtBFzv-mm3it2X8g7P8yi3W3YQCIim7i5EpbWTFX1MuG5PSomKCWeg-PIwTBdKSlifxwpmcPs7G4CPO_CGRepUBfxxxIphAbu5HV71Jgam8I)

**Librairies utilisées :** 

Librairies

Rôle de la librairie

Retrofit

Pour préparer les requêtes HTTP

Coroutine

Pour la programmation asynchrone

dagger2 Hilt 

Pour l’injection de dépendance

Glide 

Pour le chargement des images

data binding

Pour lier les données (comme des variables, des objets ou des expressions) avec les éléments de l'interface utilisateur dans les fichiers de mise en page XML. Il facilite l'interaction entre la logique de l'application et l'interface utilisateur en permettant une liaison bidirectionnelle entre les deux.

**Architecture MVVM avec le langage Kotlin**
