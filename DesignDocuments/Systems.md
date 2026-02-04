# Interaction System
**Depth-Based Interaction**

A system that digs deeper when flags are active `isSearching` `isCrafting` `isScavenging` etc so the player feels like they are able to make concious choices
***
**AI EXAMPLE**

``To make the ship feel derelict and mysterious, we shouldn't just list every button immediately. We will use a Depth-Based Interaction system. The player sees an object, investigates it to reveal its state (Broken, Locked, Powered Down), and then sees the options to interact. This adds tension and discovery.
``

**Creative Twist**

**"Analog Interfaces"**: Since this is Sci-Fi survival, not all interactions are digital. Differentiate between ***Manual*** (Prying, Smashing) and ***Digital*** (Hacking, Rerouting). 

Manual actions are 100% success but loud (noise risk); Digital actions are silent but require a skill check.

### **Example Scenario**

**You:** "Investigate Airlock Console"

**Game:** You wipe the dust off the screen. It's flickering, but the manual override lever is rusted shut.
Options:

`[Hack]` Bypass security protocol (Requires: Software lvl 1)

`[Force]` Kick the lever (Noise: High, Success: Guaranteed)

***
**Logic Flow**:
* ***Input***
  * Player selects an option presented `Investigate [OBJ_ID]` 
  * `[OBJ_ID]` activates flag i.e `isInvestigating` and player is presented with following options: Ie: `HACK [OBJ_ID]` and `Brute Foce [OBJ_ID]`

* ***Process***
  * `RoomManager` validates object exists
  * `InteractionManager` activates flag to put it into the **[STATE_MODE]**
  * `InteractionManager` checks objects state `hasPower` `locked` `broken` via `RoomObject`? 
  * `InteractionManager` checks player for requirements present, skill and or item req

* ***Result***
  * StateView switches `ROOM_VIEW` or `OBJ_VIEW`
  * Submenu generates based on flags. 
    * if `isLocked`: Show option `[1] Attempt to Hack`
    * if `!isLocked` : Show option `[2] Force open with [TOOL]`
    * Always shown `[x] Leave room` when pressed Nav options appear.
  
***
### **InteractionTypes**

* `SEARCH`
* `INVESTIGATE`
* `SALVAGE`
* `HACK`
* `LEAVE`
* `CRAFT`
* `OPEN INVENTORY`
* `CHECK SKILLS?`
* `QUESTS?`

***
***
# Inventory System

Avoiding weight calculations, using a slot based inventory would be preferential.
`Container` as base, for other containers within the game **Shop**, **Chest**, **Backpack** etc

* **BULK ITEMS** 
  * Actual items `SCRAP`, `TOOLS` etc will take up a slot. Usable items.
  
* **DATA ITEMS**
  * `KEYCARDS`, `LOGS`, `LORE ITEMS` etc take no slot, and stored in a ***DATAPAD*** style container on the player
  to save the need for having to drop needed quest-critical items just to pick up `SCRAP`
    
***
# Crafting System
Not using a workbench style system due to being on a dying ship,  **Combinatorial System** is best
You combine 2 items in your inventory, when using the `CRAFT` interaction to solve an immediate problem

```if player has [item 1] and [item 2] in inventory give [crafted_item]```

**Logic Flow**:
* ***Input***
  * Player selects [CRAFT] from the option`
  * activates flag i.e `isCrafting` and player is presented with following options: Ie: `CRAFT [ITEM]` and / or `UPGRADE [ITEM]`


* ***Process***
  * `InteractionManager` activates flag `isCrafting` and passes off to...
  * `CraftingManager` validates items and req's exist with the player
  * `RecipeManager` validates that recipe exists using a `RecipeMap <Item, <Item, Item>>` 


* ***Result***
  * Remove `[Item1]` and `[Item2]` from player inventory
  * Add `[Crafted_Item]` to player inventory
