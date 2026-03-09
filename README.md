# AntiPlace

AntiPlace is a Paper plugin that blocks placement of configured items for regular players.
Server staff with the `antiplace.admin` permission bypass the restriction.

## Features

- Blocks placement of specific materials defined in `config.yml`
- Sends a configurable prefixed message when placement is denied
- Uses a simple permission bypass for administrators
- Ships with a default blocked list (all candle variants)

## Requirements

- Java 8 or newer (project is compiled for Java 8)
- Maven 3.6+ (for building)
- Paper 1.20.x server

## Build

From the project root:

```bash
mvn clean package
```

The built plugin JAR is generated in `target/` (for example `AntiPlace-1.0.jar`).

## Install

1. Build the plugin JAR with Maven.
2. Copy the JAR from `target/` into your server's `plugins/` folder.
3. Start or restart your Paper server.
4. Edit `plugins/AntiPlace/config.yml` as needed, then restart/reload the plugin.

## Configuration

Configuration file: `src/main/resources/config.yml`

### `Prefix`

- Type: string
- Used as the chat prefix for plugin messages
- Supports `&` color codes

### `Blocked_Items`

- Type: list of Bukkit `Material` enum names
- Any listed material cannot be placed by players without bypass permission

Example:

```yml
Prefix: "&8[&5&lAnti&d&lPlace&8] &7» "
Blocked_Items:
  - Material.WHITE_CANDLE
  - Material.BLACK_CANDLE
```

## Permissions

- `antiplace.admin` - bypasses all AntiPlace placement restrictions

## Notes

- This project currently targets the Paper API `1.20.1-R0.1-SNAPSHOT`.
- If you change plugin behavior or config keys, keep this README updated so server owners have accurate setup information.