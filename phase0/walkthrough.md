When starting the game, the user will have restricted actions until they complete the tutorial quest_system.Quest. Then once the program runs, the program will:
- access scene_system.SceneManager to start the initial scene
- provide information about the scene_system.Scene and NPCs within it
- the list of traversable lists will be restricted and users will not be able to traverse to other scenes until they complete the tutorial
- interact with the NPC in the first scene_system.Scene with scene_system.SceneManager and accept a quest_system.Quest through quest_system.QuestManager, which should change the quest_system.Quest’s status to accepted and add the quest_system.Quest to the Player’s (or QuestJournal, whichever one is implemented) list of accepted quests.
- then the user can view information about the quest_system.Quest by accessing the Player’s quests attribute / QuestJournal

After receiving the first quest_system.Quest, which should be a quest_system.FetchQuest, the user should:
- traverse to the desired scene_system.Scene using scene_system.SceneManager
- interact with the item using scene_system.SceneManager that is stored in WorldState to obtain the desired item, then the item should be added to the characters.PlayerCharacter’s inventory and removed from the scene_system.Scene
- traverse to the desired scene_system.Scene with the NPC that desires the item using scene_system.SceneManager
- interact with the NPC using scene_system.SceneManager

Then, after interacting with the NPC:
- the accepted quest should be marked as completed in the QuestJournal using quest_system.CompleteQuest 
