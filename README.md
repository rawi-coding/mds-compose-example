# MDSExample

Example Android project showing a Compose Design System structure for a fictive `SBBComponent`.

## What this includes

- `SBBTheme` as the base DS entry point
- `SBBComponentTheme` and `SBBComponentStyle` token model
- Static geometric token (`SBBComponentDefaults.shape`)
- Default DS style values
- Per-instance style override (`style` parameter)
- Theme-wide subtree style override (`ProvideSBBComponentStyle`)
- Convenience and slot APIs for component content

## Key files

- `app/src/main/java/ch/sbb/appbakery/app/mdsexample/theme/SBBTheme.kt`
- `app/src/main/java/ch/sbb/appbakery/app/mdsexample/theme/SBBComponentTheme.kt`
- `app/src/main/java/ch/sbb/appbakery/app/mdsexample/theme/SBBComponentStyle.kt`
- `app/src/main/java/ch/sbb/appbakery/app/mdsexample/components/SBBComponent.kt`
- `app/src/main/java/ch/sbb/appbakery/app/mdsexample/MainActivity.kt`

## Run

```bash
cd /Users/ralfwinkelmann/Development/workspace/playground/MDSExample
./gradlew :app:assembleDebug
```

## Verify tests

```bash
cd /Users/ralfwinkelmann/Development/workspace/playground/MDSExample
./gradlew :app:testDebugUnitTest --no-daemon
```

