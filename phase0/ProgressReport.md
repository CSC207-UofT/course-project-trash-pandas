# Progress Report

#### Specification Summary:
*Divinity 3: Rise of the Trash Pandas* is a **text-based role-playing game** where the user controls a raccoon in an unnamed city.

The world is represented by multiple scenes which the player can traverse between. The world state can be affected by the actions of the player and completing certain quests.
Certain things in the scene can be interacted with, including NPCs and objects.

#### CRC Model Summary:
- run (main method)
- basic command line UI
- quest_system.Quest Package (controllers/use cases(accept, fail, complete)/quest_system.Quest superclass and different types of classes as subclasses)
- characters.GameCharacter Package (controller/ use case: characters.InventoryChange / characters.GameCharacter superclass with playable/non-playable chars as subclasses)
- Combat Package (controller/ use cases)
- World State Package(controller/use case/ entity)
- scene_system.Scene Package (controller /use case/entity)

#### Scenario Walkthrough Summary:
The program will print a basic description of the scene using scene_system.SceneManager and the user will be prompted to accept and complete the tutorial fetch quest with quest_system.QuestManager. 
The player will be required to traverse to the next scene and add the desired item to their inventory using scene_system.SceneManager. 
The user should traverse back to the original area and bring the NPC the item. 
After some dialogue, the quest should be marked as completed.

#### Skeleton Program:
See src\main\java.

#### Open Questions:
- did we do too much for phase 0?
- is it possible to implement multiple methods/classes for the UI?
- what is gradle and do we need to implement it?
- how to remove github classroom errors?


#### What has gone well?
- group members participating equally and being active, people aren't afraid to ask questions/ask for help
- design: we are trying our best to follow clean architexture and SOLID principles

#### Delegated Tasks
- John: CRC planning and implementation, skeleton code for scene_system.Scene, scene_system.Scene Manager, scene_system.DisplayScene
- Bernie: CRC edits, scene_system.DisplayDialogue, characters.GameCharacter implementation, game.CommandLine, scene_system.Scene getters
- Edward: CRC planning/edits, scenario walkthourgh, specification, progress report,
- George: consulation, specification/crc code planning, ideas
- Eric: CRC card creation, wrote run function in skeleton code
- Tim: CRC edits, wrote quest classes, wrote dialogue, style adjustments

#### Planned Tasks
- Combat Package, items, World State package, QuestJournal, better implementation of Quests, scene_system.Scene Package, certain events occuring only if certain conditions are fufilled
- delegations have not been decided yet
