# Interaction System
**Depth-Based Interaction**

A system that digs deeper when flags are active `isSearching` `isCrafting` `isScavenging` etc so the player feels like they are able to make concious choices
***
**AI EXAMPLE**

``To make the ship feel derelict and mysterious, we shouldn't just list every button immediately. We will use a Depth-Based Interaction system. The player sees an object, investigates it to reveal its state (Broken, Locked, Powered Down), and then sees the options to interact. This adds tension and discovery.
``
***
**Logic Flow**:
* ***Input***
  * Player selects an option presented `Investigate [OBJ_ID]` 
  * `[OBJ_ID]` activates flag i.e `isInvestigating` and player is presented with following options: Ie: `HACK [OBJ_ID]` and `Brute Foce [OBJ_ID]`

* ***Process***
  * `RoomManager` validates object exists
  * `InteractionManager` checks objects state `hasPower` `locked` `broken`
  * `InteractionManager` checks players items for requirements present

* ***Result***
  * StateView switches `ROOM_VIEW` or `OBJ_VIEW`
  * Submenu generates based on flags. 
    * if `isLocked`: Show option `[1] Attempt to Hack`
    * if `!isLocked` : Show option `[2] Repair with scrap`
    * Always shown `[3] Leave room` when pressed Nav options appear.
  
***
### **InteractionTypes**

*  `SEARCH`
* 