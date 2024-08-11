# Wave Carpet

[Carpet Mod](https://github.com/gnembon/fabric-carpet) extension 
developed by the Wavetech TMC server.

## Features
### Stop light recalculation DataFix
Prevents the ChunkDeleteLightFix DataFix from erasing the light data out of <=1.19.4 chunks.\
**Can be enabled just before you load the wanted chunks - no need to restart the server**
- Name: `stopLightRecalculationDataFix`
- Type: `boolean`
- Default: `false`
- Category: `Wavetech`

### Suppression counter
Registers the scoreboard criterion `suppressionCount`.\
Can be accessed with 
`/scoreboard objectives add {name} suppressionCount`.\
Increases by 1 for the player who triggered an update suppression.

### Player container loading
Server side implementation of TweakerMore's `autoFillContainer` for use with Carpet bots.\
Toggled with `/carpet {player} loadItems`.\
Whenever a container is opened by the player, it will move as many items as possible in it.