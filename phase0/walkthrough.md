When starting the game, the user will have restricted actions until they complete the tutorial Quest. Then once the program runs, the program will:
- access SceneManager to start the initial scene
- provide information about the Scene and NPCs within it
- the list of traversable lists will be restricted and users will not be able to traverse to other scenes until they complete the tutorial
- interact with the NPC in the first Scene with SceneManager and accept a Quest through QuestManager, which should change the Quest’s status to accepted and add the Quest to the Player’s (or QuestJournal, whichever one is implemented) list of accepted quests.
- then the user can view information about the Quest by accessing the Player’s quests attribute / QuestJournal

After receiving the first Quest, which should be a FetchQuest, the user should:
- traverse to the desired Scene using SceneManager
- interact with the item using SceneManager that is stored in WorldState to obtain the desired item, then the item should be added to the PlayerCharacter’s inventory and removed from the Scene
- traverse to the desired Scene with the NPC that desires the item using SceneManager
- interact with the NPC using SceneManager

Then, after interacting with the NPC:
- the accepted quest should be marked as completed in the QuestJournal using CompleteQuest 
