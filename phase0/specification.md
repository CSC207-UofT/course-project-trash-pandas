The program is a **text-based role-playing game**, where the user will control a raccoon in an unnamed city.

There are multiple world areas/scenes that represent the world. Each scene has a text description of the scene: 
- a basic description listing interactable objects, 
- non-playable characters(NPCs) within the scene, 
- and other accessible scenes.

Certain player actions will affect the world state, which in turn affects choices and how the player character interacts with the world and other NPCs interact with the player.

Upon opening the program, the user will be presented with the option of creating a new game, or of loading an existing save game.

While running, the program will print information about the scene, after which the user will be prompted for an action, such as:
- interacting with objects and characters in the scenes,
- traversing to other scenes, and
- checking player inventory or status.

The player will have the option to accept quests. These quests will include:
- Fetch quests (retrieving an item/items and bringing it to an NPC or location),
- Combat quests (fighting an NPC),
- Dialogue quests (requiring speaking to an NPC to progress, this may be implemented using fetch quests)
Quests may have reward items or affect the world state.
