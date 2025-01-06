# NoJumpDelay for Minecraft Forge 1.16.5

## Overview
The **NoJumpDelay** mod for Minecraft Forge 1.16.5 eliminates the jump delay when the player is standing within two blocks. This mod provides a smoother gameplay experience by allowing instantaneous jumps, bypassing the standard delay enforced by the game mechanics.

## Features
- **Immediate Jumping:** Removes the built-in jump delay, allowing players to jump instantly when in confined spaces.
- **Reflection Utilization:** The mod uses Java Reflection to modify a private field responsible for managing jump delay. This approach ensures minimal intrusion into the game's mechanics, maintaining compatibility with other mods and game updates.

## Implementation Details
### Reflection
- The mod leverages reflection to access and modify a private field that controls the jump delay. This ensures that no hardcoded changes are required, allowing for adaptability with different versions of the mappings.

### Mappings
- **Mappings Channel:** `snapshot`
- **Version:** `20210309-1.16.5`

> **Note:** The private field names may vary in official obfuscated releases. Therefore, care should be taken when updating the mod to different Minecraft versions or mappings.

### Reflection Helper Class
The mod includes a dedicated helper class for handling reflection. This class abstracts the complexity of reflection, providing an easy-to-use interface for accessing and modifying private fields.

## Installation
1. Download and install [Minecraft Forge 1.16.5](https://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.16.5.html).
2. Place the NoJumpDelay mod `.jar` file into the `mods` directory of your Minecraft installation.
3. Launch Minecraft with the Forge profile and enjoy the enhanced jumping mechanics.
