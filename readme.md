
### Récap des commandes GIT :

- Initialise un dossier comme étant un répository "git" :
``
git init
``

- Clone un répo git (le récupère depuis le serveur distant sur votre machine local) :
``
git clone URL_DU_DEPOT
``

- Vérifie l'état du git local :
``
git status
``

- Ajoute TOUS les fichiers modifiés au prochain commit :
  ``
  git add .
  ``

- Commit les fichiers ajoutés :
  ``
  git commit -m "COMMENTAIRE DU COMMIT"
  ``

- Envoie les différents commit vers le distant :
``
git push
``

- Récupère les changements du distant (nécessite de n'avoir aucun changement local non-commit !):
``
git pull
``

- Créer une branche et se déplace dessus:
  ``
  git checkout -D NOM_BRANCHE
  ``

- Change de branche :
  ``
  git checkout NOM_BRANCHE
  ``