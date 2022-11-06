## MessageQueue avec Broadcast et un petit peu d'évènementiel

1.	**Spécifications**
Chaque processus est une séquence de réactions d'évènements.
chaque processus peut échouer à partir d'un certain temps et un détecteur de faille est mis en place pour
détecter et corriger ces failles
un évènement est une action déclenchée au moment de l'envoi du message ou de la reception d'un message
les messages passent par une file d'attente FIFO et par des canaux de communication sans perte
Un éxécuteur (Executor) est une file d'attente FIFO d'événements qui s'exécute sur un seul thread et qui
peut exécuter des événements appartenant à de nombreuses tâches
Les réactions aux évènements sont éxécutées jusqu'à la fin
Les méthodes ou les appels sont alors non bloquantes 
Un **MessageQueue** permet l'envoie et la réception de messages
la classe Task possède un attribut **QueueBroker** permettant d'autoriser les connexions et de se connecter à d'autres **QueueBroker**
La réception d'un évènement déclenche une réaction qui sera spécifiée dans la méthode **react()** de la classe Event.
la méthode **post** permet d'ajouter un évènement à traiter dans la liste des évènements de l'objet **Executor** 
Detection de fautes et/ou de pannes et/ou
Detection des exceptions
Utilisation de deux types de modes :
   - Mode stateful : ici, le serveur a fait les sauvegardes avant son arrêt complet et se restitue avant le démarrage
   - Mode stateless : ici, le serveur ne fait aucune sauvegarde après son arrêt brusque et ne peut pas se restituer avant le démarrage



2.	**Design**

- Créer un RDV : accept() et connect()
- Un Manager pour gérer tous les RDVs, c'est quoi un Manager ? 
- Le premier thread crée le RDV et le deuxième thread le trouve 
- Créer une liste ou une table de hash de RDV avec l'unicité : nom, port 
- **Ajouter un RDV accept(nom, port)** dans la liste, sans problème
- **Ajouter un RDV connecct(nom, port)** le thread attend s'il existe déjà un RDV connect() avec le même nom et le même port. Le thread ajoute le RDV s'il est le premier thread à demander le connecct() avec le même nom et le même port . 
- Un seul accept() et plusieurs connect() : plusieurs RDVs 
- l'environment est multi-threadé 
- La liste des RDVs est chez le manager 
- Une tâche correspond à un thread 
- Le manager a une liste de RDVs 
- Le manager a une HashMap de Brokers associés avec leurs noms
- Détecteur de fautes 
- Correction des pannes du serveur, serveur avec mémoire: stateful et serveur sans mémoire : stateless. 


3.	**Implémentation**

voir le dossier **TD3/brokers** et **TD3/channels** et **TD3/tâches** 
et le point principal pour l'execution est le fichier **Main.java**

*Il suffit de lancer l'execution du fichier Main.java via l'IDE*

 
 Et l'implémentation ne marche pas très bien pour la simple raison que j'ai pas du tout 
 eu le succès de comprendre le niveau de design
 
 
 ## MessageQueue avec Broadcast et un petit peu d'évènementiel (end)