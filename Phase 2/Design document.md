# Phase 2 Design Document

## Updated Specification

Same as before, but with abilities and status effects, music, and a save and load system.

## Major Design Decisions

+ decided to use text files to store story-specific data (Quest, Scene, and Character data) as well as to implement saving/loading
+ decided to use the Facade design pattern for multiple different parts of the program to encapsulate complex subsystem functionality

## How the project adheres to Clean Architecture

The project adheres to clean architecture because the classes are divided into distinct levels, with a set of entities (GameCharacter and subclasses, Quest and subclasses, Item and subclasses, and Scene), use cases (CharacterManager, QuestManager, SceneManager), controller(guiLogic, combat), and presenters (MainFrame). Almost all entity parameters have been removed from our phase 1 code, except for a select few. This means that we do not violate Clean Architecture by passing Entities/UseCases between boundaries. An example of how we follow this is when the user chooses they want to move to a new scene, the controller calls on a use case (Scenemanager) which then calls on the entity scene to find the scenes connected to it. The Scenemanager returns an arraylist containing string representations of the scenes which the controller then passes to the presenter for the user to see. The controller never directly accesses the scenes.

## Brief description of how the project is consistent with the SOLID design principles

The project is consistent with the single-responsibility principle because all of the classes have a single responsibility. The project is consistent with the open-closed principle because the abstract classes are open for extension by some of the concrete classes, while they are no longer heavily modified. The project is consistent with the Liskov substitution principle because objects of superclasses can largely be (and frequently are) substituted for objects of their subclasses. The project is consistent with the interface segregation principle because the interfaces for all of our classes were built with methods only added as needed. The project is consistent with the dependency inversion principle because higher level modules never depend on lower level modules.

## Description of which packaging strategies we considered, which we decided to use and why

Initially, we were split between packaging by feature and packaging by layer. Packaging by layer would allow us to confirm more easily that we were adhering to clean architecture through the course of development. However, in the end, we packaged our classes by feature because our program is composed of a number of distinct, highly cohesive features. We decided that this was the most intuitive strategy and easiest to work with.

## Summary of design patterns we implemented

We’ve implemented a facade to facilitate pairing inventories and characters as well as a facade pairing status with characters. We’ve also implemented dependency inversion. We’ve also implemented observers with our questmanager which observes the player's CharacterInventoryFacade and npcs killed in combat to update the quests stored in it depending on what was observed.

## Progress report

### Contributions since Phase 1

**Tim** (logatsang): style + Javadoc, implementation of Ability and StatusEffect, GUI additions, assorted bugfixing, maintaining design document (and converting to Markdown), helping others with assorted issues + participating in decision making

+ [Implementation of combined Ability and StatusEffect system…](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/47)
This class implemented abilities and status effects for use in combat, as well as a varied list of specific abilities and effects added to the game constants. Abilities play a major role in combat, allowing for more variety in attacks.
 
**Bernie** (wBernie): made TA-requested changes, tests, and a lot of random fixes post merging, helped others with any issues, CombatQuest, Observers, minor fixes

+ [command line finished and changes to character and scene](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/16): Created the original Logic and command line interface. Without this pull, we wouldn’t have a running program for phase 0 and 1. However this has since been replace with the gui.

+ [Quest changes](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/40): changed how quests checked for completion through the use of observers. This allowed for fetch quests to require more than 1 item and made creating combat quests easier.

**Eric** (Erkle-on-Bones): wrote the SceneManager system, CharacterFacadeManager. Partook in decision making and design choices regarding the saving and loading system. Refactored large amounts of code to adhere to clean architecture. 

+ [Finished refactoring scenes and scenemanager to adhere to…](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/61): This is the less significant pull request I made that completed refactoring code related to stopping the MainFrame from accessing scenes directly. I could not find the more significant one.

**Edward** (edwardsues): Wrote various helper methods throughout the code to better work with the UI. Aided Tim with GUI additions, helped other students implement design patterns. Wrote tests for Inventory / Inventory Manager with 80% method coverage average for the two classes, 100% method coverage for ItemList and Constants.

+ [Added CharacterInventoryFacade.java, CompleteQuest.java, HealingItem… ](https://github.com/CSC207-UofT/course-project-trash-pandas/commit/3b29720920ef36c45061e5aedf342d372a9457a6): Character/Inventory/CharacterInventoryFacade was used in many classes, including combat, mainframe, and run, and is a large portion of the code’s foundation.

+ [Added Item package with Item.java, ConsumableHealingItem.java, Consum… ](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/21/commits/fb29591feb103a2b32c69c0d2f032fb50d4c1cac): Item System for Quests/Combats, although the implementation never happened, These classes could have been a significant portion of the game through a progression system and provide more interactivity with the user. These two classes allow for significant future extendibility if needed. 

**John** (skawldnjs9): Implemented initial code in scene_systems: cene, Scene Manager. Implemented saving/loading for scenes. Added needed getter methods. Contributed in fixing gui. Edited main frame and choice handler in gui. Created text files that build the scenes by loading. Participated in ideas for design patterns.

+ [Save/load](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/66): Implemented save/load feature for the entire program.

**George** (glyon3 and georgewesley, had issues accessing georgewesley account on different computer): Before phase one: Handled writing code for facilitating combat. Since Phase 1: Implemented GUI and Music.

+ [Wesley GUI](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/39):
This is where I converted the whole game to a GUI instead of a console. I also did combat implementation in GUI.

+ [Updated GUI so that the logic is separated…](https://github.com/CSC207-UofT/course-project-trash-pandas/pull/55):
I improved the GUI here, improving its adherence to the Universal Design Principles.
