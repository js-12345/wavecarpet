# Wavecarpet

[Carpet Mod](https://www.curseforge.com/minecraft/mc-mods/carpet) extensions 
developed by the Wavetech TMC server.

## Features
### Light recalculation fix
Prevents the ChunkDeleteLightFix DataFix from erasing the light data out of <=1.19.4 chunks.  
**Must be enabled before launching the world in 1.20+. Open `{world dir}/carpet.conf` and add `stopLightRecalculationDataFix true` line**
- Name: `stopLightRecalculationDataFix`
- Type: `boolean`
- Default: `false`
- Category: `Wavetech`

### Suppression counter
Registers a scoreboard criteria `suppressionCount`. Can be accessed with 
`/scoreboard objectives add {name} suppressionCount`
When active increases by 1 for the player who triggered an update suppression.

### Player container loading
Server side implementation of TweakerMore's `autoFillContainer` for use with Carpet bots.  
Toggled with `/carpet {player} loadItems`. When enabled whenever a container is opened by the player, 
it will move as many items as possible in it.